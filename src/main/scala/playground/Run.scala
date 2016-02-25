// test -- this can be run from the repl
package playground

import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.catalyst.plans._
import org.apache.spark.sql.execution.datasources.LogicalRelation
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.DataFrame
import com.databricks.spark.csv.CsvRelation
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.expressions.aggregate._

import optiql.compiler._
import optiql.library._
import optiql.shared._
import scala.reflect.{Manifest,SourceContext,ManifestFactory,RefinedManifest}
import scala.virtualization.lms.common.{Record, TupleOps}
import scala.math.Ordering
import playground._
import java.util.{Date, Calendar, TimeZone}
import java.text._

object Run {
  val lgr = "org.apache.spark.sql.execution.datasources.LogicalRelation"
  val aggexp = "org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression"
  val expcl = "org.apache.spark.sql.catalyst.plans.logical.Expand"

  def convertDataType(e: DataType) : Manifest[_] = e match {
      case ByteType => manifest[Char]
      case BooleanType => manifest[Boolean]
      case IntegerType => manifest[Int]
      case LongType => manifest[Long]
      case DoubleType => manifest[Double]
      case DateType => manifest[java.util.Date]
      case StringType => manifest[String]
      case StructType(fields) =>
        val names = fields map {
          case StructField(name,tpe,nullable,metadata) => name
        }
        val elems = fields map {
          case StructField(name,tpe,nullable,metadata) => convertDataType(tpe)
        }
        ManifestFactory.refinedType[Record](manifest[Record], names.toList, elems.toList)
      case _ => throw new RuntimeException("convertDataType, TODO: " + e.toString)
  }

  def convertType(e: Expression): Manifest[_] = e match {
    case Count(_) => manifest[Long]
    case Alias(Count(_), _) => manifest[Long]
    case _ => convertDataType(e.dataType)
  }

  def getType(e: Option[Expression]) : Manifest[_] = e match {
    case Some(EqualTo(left, right)) => convertType(left)
    case _ => manifest[Any]
  }

  def escapeDelim(c: Char) = if (c == '|') "\\|" else c.toString

  def runDelite(d : LogicalPlan) = {
    object DeliteQuery extends OptiQLApplicationCompiler with DeliteTestRunner {
      // ### begin modified code for groupBy fusion from hyperdsl ###
      private def hashReduce[A:Manifest,K:Manifest,T:Manifest,R:Manifest](resultSelector: Exp[T] => Exp[R], keySelector: Exp[A] => Exp[K]): Option[(Exp[A]=>Exp[R], (Exp[R],Exp[R])=>Exp[R], (Exp[R],Exp[Int])=>Exp[R])] = {
        var failed: Boolean = false
        val ctx = implicitly[SourceContext]
        def rewriteMap(value: Exp[Any]): Exp[A]=>Exp[R] = (value match {
          case Def(Field(Def(Field(s,"_1")),index)) => (a:Exp[A]) => field(keySelector(a),index)(value.tp,ctx)
          case Def(Field(s,"_1")) => keySelector
          case Def(Field(Def(Field(s,"_2")),index)) => (a:Exp[A]) => field(keySelector(a),index)(value.tp,ctx) // we know that it must be part of the selector ....
          case Def(Table_Sum(s, sumSelector)) => sumSelector
          case Def(Table_Average(s, avgSelector)) => avgSelector
          case Def(Table2_Count(s)) => (a:Exp[A]) => unit(1)
          case Def(Table_Max(s, maxSelector)) => maxSelector
          case Def(Table_Min(s, minSelector)) => minSelector
          case Def(Internal_pack2(u,v)) => (a: Exp[A]) => 
            pack(rewriteMap(u)(a), rewriteMap(v)(a))(mtype(u.tp),mtype(v.tp),ctx,implicitly)
          // TODO: Spark/Delite
          case Def(a) => Console.err.println("found unknown map: " + a.toString); failed = true; null
          case _ => Console.err.println("found unknown map: " + value.toString); failed = true; null
        }).asInstanceOf[Exp[A]=>Exp[R]]

        def rewriteReduce[N](value: Exp[Any]): (Exp[N],Exp[N])=>Exp[N] = (value match {
          case Def(Field(Def(Field(s,"_1")),index)) => (a:Exp[N],b:Exp[N]) => a
          case Def(Field(s,"_1")) => (a:Exp[N],b:Exp[N]) => a
          case Def(Field(Def(Field(s,"_2")),index)) => (a:Exp[N],b:Exp[N]) => a
          case Def(d@Table_Sum(_,_)) => (a:Exp[N],b:Exp[N]) => numeric_pl(a,b)(ntype(d._numR),mtype(d._mR),ctx)
          case Def(d@Table_Average(_,_)) => (a:Exp[N],b:Exp[N]) => numeric_pl(a,b)(ntype(d._numR),mtype(d._mR),ctx)
          case Def(d@Table2_Count(s)) => (a:Exp[N],b:Exp[N]) => numeric_pl(a,b)(ntype(implicitly[Numeric[Int]]),mtype(manifest[Int]),ctx)
          case Def(d@Table_Max(_,_)) => (a:Exp[N],b:Exp[N]) => ordering_max(a,b)(otype(d._ordR),mtype(d._mR),ctx)
          case Def(d@Table_Min(_,_)) => (a:Exp[N],b:Exp[N]) => ordering_min(a,b)(otype(d._ordR),mtype(d._mR),ctx)
          case Def(d@Internal_pack2(u,v)) => (a:Exp[Tup2[N,N]],b:Exp[Tup2[N,N]]) => 
            pack(rewriteReduce(u)(tup2__1(a)(mtype(u.tp),ctx),tup2__1(b)(mtype(u.tp),ctx)), 
                 rewriteReduce(v)(tup2__2(a)(mtype(v.tp),ctx),tup2__2(b)(mtype(v.tp),ctx)))(mtype(u.tp),mtype(v.tp),ctx,implicitly)
          case Def(a) => Console.err.println("found unknown reduce: " + a.toString); failed = true; null
          case _ => Console.err.println("found unknown reduce: " + value.toString); failed = true; null
        }).asInstanceOf[(Exp[N],Exp[N])=>Exp[N]]

        def rewriteAverage[N](value: Exp[Any]): (Exp[N],Exp[Int])=>Exp[N] = (value match {
          case Def(d@Table_Average(_,_)) => (a:Exp[N],count:Exp[Int]) => fractional_div(a, count.asInstanceOf[Exp[N]])(mtype(d._mR),frtype(d._fracR),mtype(d._mR),ctx,implicitly[Rep[N]=>Rep[N]])
          case _ => (a:Exp[N],count:Exp[N]) => a
        }).asInstanceOf[(Exp[N],Exp[Int])=>Exp[N]]


        val funcs = resultSelector(fresh[T]) match {
          case Def(Struct(tag: StructTag[R], elems)) =>
            val valueFunc = (a:Exp[A]) => struct[R](tag, elems map { case (key, value) => (key, rewriteMap(value)(a)) })
            val reduceFunc = (a:Exp[R],b:Exp[R]) => struct[R](tag, elems map { case (key, value) => (key, rewriteReduce(value)(field(a,key)(value.tp,ctx), field(b,key)(value.tp,ctx))) })
            val averageFunc = (a:Exp[R],count:Exp[Int]) => struct[R](tag, elems map { case (key, value) => (key, rewriteAverage(value)(field(a,key)(value.tp,ctx), count)) })
            (valueFunc, reduceFunc, averageFunc)

          case a => (rewriteMap(a), rewriteReduce[R](a), rewriteAverage[R](a))
        }

        if (failed) None else Some(funcs)
      }

      def table_selectA[A:Manifest,R:Manifest](self: Rep[Table[A]], resultSelector: (Rep[A]) => Rep[R])(implicit __pos: SourceContext): Exp[Table[R]] = self match {
        //case Def(QueryableWhere(origS, predicate)) => //Where-Select fusion
        //  QueryableSelectWhere(origS, resultSelector, predicate)
        case Def(g@Table_GroupBy(origS: Exp[Table[a]], keySelector)) => hashReduce(resultSelector, keySelector)(g._mA,g._mK,manifest[A],manifest[R]) match {
          case Some((valueFunc, reduceFunc, averageFunc)) =>
            //Console.err.println("fused GroupBy-Select")
            val hr = groupByReduce(origS, keySelector, valueFunc, reduceFunc, (e:Exp[a]) => unit(true))(g._mA,g._mK,manifest[R],implicitly[SourceContext])
            val count = groupByReduce(origS, keySelector, (e:Exp[a]) => unit(1), (a:Exp[Int],b:Exp[Int])=>forge_int_plus(a,b), (e:Exp[a])=>unit(true))(g._mA,g._mK,manifest[Int],implicitly[SourceContext])
            bulkDivide(hr, count, averageFunc)(manifest[R],implicitly[SourceContext])
          case None =>
            Console.err.println("WARNING: unable to fuse GroupBy-Select")
            return super.table_select(self, resultSelector)
        }
        case Def(g@Table_GroupByWhere(origS: Exp[Table[a]], keySelector, cond)) => hashReduce(resultSelector, keySelector)(g._mA,g._mK,manifest[A],manifest[R]) match {
          case Some((valueFunc, reduceFunc, averageFunc)) =>
            //Console.err.println("fused GroupBy-Select")
            val hr = groupByReduce(origS, keySelector, valueFunc, reduceFunc, cond)(g._mA,g._mK,manifest[R],implicitly[SourceContext])
            val count = groupByReduce(origS, keySelector, (e:Exp[a]) => unit(1), (a:Exp[Int],b:Exp[Int])=>forge_int_plus(a,b), cond)(g._mA,g._mK,manifest[Int],implicitly[SourceContext])
            bulkDivide(hr, count, averageFunc)(manifest[R],implicitly[SourceContext])
          case None =>
            Console.err.println("WARNING: unable to fuse GroupBy-Select")
            return super.table_select(self, resultSelector)
        }
        case _ => super.table_select(self, resultSelector)
      }

    

      override def table_select[A:Manifest,R:Manifest](self: Rep[Table[A]], resultSelector: (Rep[A]) => Rep[R])(implicit __pos: SourceContext): Exp[Table[R]] = {
        def sel1(a: Rep[R]): Rep[R] = (a match {
          // right now only a/b is supported. TODO: add a+b etc
          case Def(Primitive_Forge_double_divide(a,b)) => 
            val a1 = a/*rewriteMap(a)(e)*/.asInstanceOf[Exp[Double]] // should we recurse here?
            val b1 = b/*rewriteMap(b)(e)*/.asInstanceOf[Exp[Double]]  
            pack(a1,b1)
          case Def(Primitive_Forge_double_times(Const(c),b)) => b // TODO: more general case
          case Def(Ordering_Gt(a,b@Const(c))) => a
          case Def(Struct(tag: StructTag[R], elems)) =>
            struct[R](tag, elems map { case (key, value) => (key, sel1(value.asInstanceOf[Rep[R]])) })
          case _ => a
        }).asInstanceOf[Rep[R]]

        def sel2(a: Rep[R])(v: Rep[R]): Rep[R] = (a match {
          case Def(Primitive_Forge_double_divide(a,b)) => 
            val v1 = v.asInstanceOf[Rep[Tup2[Double,Double]]]
            val a1 = tup2__1(v1)/*sel2(a)(v._1)*/.asInstanceOf[Exp[Double]] // should we recurse here?
            val b1 = tup2__2(v1)/*sel2(b)(v._2)*/.asInstanceOf[Exp[Double]]
            primitive_forge_double_divide(a1,b1)
          case Def(Primitive_Forge_double_times(Const(c:Double),b)) => // TODO: handle more general case
            primitive_forge_double_times(Const(c),v.asInstanceOf[Rep[Double]])
          case Def(d@Ordering_Gt(a,b@Const(c))) => ordering_gt(v,b)(d._ordA,d._mA,__pos)
          case Def(Struct(tag: StructTag[R], elems)) =>
            struct[R](tag, elems map { case (key, value) => 
              (key, sel2(value.asInstanceOf[Rep[R]])(field[R](v,key)(mtype(value.tp),__pos))) })
          case _ => v
        }).asInstanceOf[Rep[R]]

        def tpe1(a: Rep[R]): Manifest[R] = (a match {
          case Def(Primitive_Forge_double_divide(a,b)) => manifest[Tup2[Double,Double]]
          case Def(Primitive_Forge_double_times(Const(c),b)) => b.tp
          case Def(Ordering_Gt(a,b@Const(c))) => a.tp
          case Def(Struct(tag: StructTag[R], elems)) =>
            val em = elems map { case (key, value) => (key, tpe1(value.asInstanceOf[Rep[R]])) }
            ManifestFactory.refinedType[Record](manifest[Record], em.map(_._1).toList, em.map(_._2).toList)
          case _ => a.tp
        }).asInstanceOf[Manifest[R]]

        val isGroupBy = self match {
          case Def(g@Table_GroupBy(origS: Exp[Table[a]], keySelector)) => true
          case Def(g@Table_GroupByWhere(origS: Exp[Table[a]], keySelector, cond)) => true
          case _ => false
        }
        if (isGroupBy) {
          val rs = resultSelector(fresh[A])
          val mfr = tpe1(rs)
          val sel2func = sel2(rs) _

          table_selectA(self, (x:Rep[A]) => sel1(resultSelector(x)))(manifest[A], mtype(mfr), __pos)
               .Select(sel2func)
        } else {
          table_selectA(self,resultSelector)
        }
      }
      // ### end groupBy fusion code ###

      def extractMF[T](x: Rep[Table[T]]): Manifest[T] = {
       //  println(x.tp.typeArguments)
        x.tp.typeArguments.head.asInstanceOf[Manifest[T]]
      }

      def println(x: Any) = System.out.println(x)

      def conv_date(days: Int): Rep[Date] = {
        val c = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        c.setTime(new java.util.Date(0)); // set origin 1970-01-01.
        c.add(Calendar.DAY_OF_YEAR, days); // Adding the number of days
        Date(primitive_forge_int_plus(primitive_forge_int_shift_left(c.get(Calendar.YEAR), unit(9)), primitive_forge_int_plus(primitive_forge_int_shift_left(c.get(Calendar.MONTH) + 1, unit(5)), c.get(Calendar.DATE))))
      }

      def appendMan(v1 : RefinedManifest[Record], v2 : RefinedManifest[Record]) = {
        val name = v1.fields.map { _._1 } ++ v2.fields.map { _._1 }
        val tpe  = v1.fields.map { _._2 } ++ v2.fields.map { _._2 }

        ManifestFactory.refinedType[Record](
                  manifest[Record],
                  name,
                  tpe)
      }

      def compileAggExpr[T:Manifest](d: AggregateFunction)(rec: Rep[Table[Record]]): Rep[T] = d match {
        case Sum(child) =>
          val res = child.dataType match {
            case FloatType  =>
              rec.Sum(l => compileExpr[Float](child)(l))
            case DoubleType  =>
              rec.Sum(l => compileExpr[Double](child)(l))
            case IntegerType =>
              rec.Sum(l => compileExpr[Int](child)(l))
            case LongType =>
              rec.Sum(l => compileExpr[Long](child)(l))
          }
          res.asInstanceOf[Rep[T]]
        case Average(child) =>
          val res = child.dataType match {
            case FloatType  =>
              rec.Average(l => compileExpr[Float](child)(l))
            case DoubleType  =>
              rec.Average(l => compileExpr[Double](child)(l))
            //case IntegerType =>
            //  rec.Average(l => compileExpr[Fractional[Int]](child)(l))
            //case LongType =>
            //  rec.Average(l => compileExpr[Fractional[Long]](child)(l))
            case _ => throw new RuntimeException("Average, " + child.dataType)
          }
          res.asInstanceOf[Rep[T]]
        case Count(child) =>
          val res = rec.Sum(l => compileExpr[Long](child.head)(l))
          res.asInstanceOf[Rep[T]]
        case Min(child) =>
          val res = child.dataType match {
            case IntegerType  => rec.Min(l => compileExpr[Int](child)(l))
            case LongType     => rec.Min(l => compileExpr[Long](child)(l))
            case FloatType    => rec.Min(l => compileExpr[Float](child)(l))
            case DoubleType   => rec.Min(l => compileExpr[Double](child)(l))
            //case DateType     => rec.Min(l => compileExpr[Date](child)(l))
            case StringType   => rec.Min(l => compileExpr[String](child)(l))
            case _ => throw new RuntimeException("Min: TODO " + child.dataType)
          }
          res.asInstanceOf[Rep[T]]
        case Max(child) =>
          val res = child.dataType match {
            case IntegerType  => rec.Max(l => compileExpr[Int](child)(l))
            case LongType     => rec.Max(l => compileExpr[Long](child)(l))
            case FloatType    => rec.Max(l => compileExpr[Float](child)(l))
            case DoubleType   => rec.Max(l => compileExpr[Double](child)(l))
            //case DateType     => rec.Min(l => compileExpr[Date](child)(l))
            case StringType   => rec.Max(l => compileExpr[String](child)(l))
            case _ => throw new RuntimeException("Max: TODO " + child.dataType)
          }
          res.asInstanceOf[Rep[T]]
        case _ => throw new RuntimeException("TODO: AggregateExpression, " + d.getClass.getName)
      }

      def compileExpr[T:Manifest](d: Expression)(rec: Rep[_]): Rep[T] = d match {
        case AttributeReference(name, _, _, _) =>
          field[T](rec, name)
        case Literal(value, DateType) =>
          conv_date(value.asInstanceOf[Int]).asInstanceOf[Rep[T]]
        case Literal(value, StringType) =>
          unit[String](String.valueOf(value)).asInstanceOf[Rep[T]]
        case Literal(value, _) =>
          unit[T](value.asInstanceOf[T])
        case And(left, right) =>
          infix_&&(compileExpr[Boolean](left)(rec), compileExpr[Boolean](right)(rec)).asInstanceOf[Rep[T]]
        case Or(left, right) =>
          infix_||(compileExpr[Boolean](left)(rec), compileExpr[Boolean](right)(rec)).asInstanceOf[Rep[T]]
        case Not(value) =>
          (!compileExpr[Boolean](value)(rec)).asInstanceOf[Rep[T]]
        case LessThan(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a)(rec) < compileExpr[Float](b)(rec)
            case DoubleType   => compileExpr[Double](a)(rec) < compileExpr[Double](b)(rec)
            case IntegerType  => compileExpr[Int](a)(rec) < compileExpr[Int](b)(rec)
            case LongType     => compileExpr[Long](a)(rec) < compileExpr[Long](b)(rec)
            case DateType     => compileExpr[Date](a)(rec) < compileExpr[Date](b)(rec)
            case StringType   => compileExpr[String](a)(rec) < compileExpr[String](b)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case LessThanOrEqual(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a)(rec) <= compileExpr[Float](b)(rec)
            case DoubleType   => compileExpr[Double](a)(rec) <= compileExpr[Double](b)(rec)
            case IntegerType  => compileExpr[Int](a)(rec) <= compileExpr[Int](b)(rec)
            case LongType     => compileExpr[Long](a)(rec) <= compileExpr[Long](b)(rec)
            case DateType     => compileExpr[Date](a)(rec) <= compileExpr[Date](b)(rec)
            case StringType   => compileExpr[String](a)(rec) <= compileExpr[String](b)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case GreaterThan(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a)(rec) > compileExpr[Float](b)(rec)
            case DoubleType   => compileExpr[Double](a)(rec) > compileExpr[Double](b)(rec)
            case IntegerType  => compileExpr[Int](a)(rec) > compileExpr[Int](b)(rec)
            case LongType     => compileExpr[Long](a)(rec) > compileExpr[Long](b)(rec)
            case DateType     => compileExpr[Date](a)(rec) > compileExpr[Date](b)(rec)
            case StringType   => compileExpr[String](a)(rec) > compileExpr[String](b)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case GreaterThanOrEqual(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a)(rec) >= compileExpr[Float](b)(rec)
            case DoubleType   => compileExpr[Double](a)(rec) >= compileExpr[Double](b)(rec)
            case IntegerType  => compileExpr[Int](a)(rec) >= compileExpr[Int](b)(rec)
            case LongType     => compileExpr[Long](a)(rec) >= compileExpr[Long](b)(rec)
            case DateType     => compileExpr[Date](a)(rec) >= compileExpr[Date](b)(rec)
            case StringType   => compileExpr[String](a)(rec) >= compileExpr[String](b)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case EqualTo(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a)(rec) == compileExpr[Float](b)(rec)
            case DoubleType   => compileExpr[Double](a)(rec) == compileExpr[Double](b)(rec)
            case IntegerType  => compileExpr[Int](a)(rec) == compileExpr[Int](b)(rec)
            case LongType     => compileExpr[Long](a)(rec) == compileExpr[Long](b)(rec)
            case DateType     => compileExpr[Date](a)(rec) == compileExpr[Date](b)(rec)
            case StringType   => compileExpr[String](a)(rec) == compileExpr[String](b)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case Alias(child, name) =>
          val res = compileExpr[T](child)(rec)
          res
        case Cast(child, dataType) =>
          compileExpr[T](child)(rec)
      //  case AggregateExpression(func, mode, isDistinct) =>
      //    compileExpr[T](func)(rec)
        case Add(left, right) =>
          val res = left.dataType match {
            case FloatType  =>
              compileExpr[Float](left)(rec) + compileExpr[Float](right)(rec)
            case DoubleType  =>
              compileExpr[Double](left)(rec) + compileExpr[Double](right)(rec)
            case IntegerType =>
              compileExpr[Int](left)(rec) + compileExpr[Int](right)(rec)
            case LongType =>
              compileExpr[Long](left)(rec) + compileExpr[Long](right)(rec)
          }
          res.asInstanceOf[Rep[T]]
        case Subtract(left, right) =>
          val res = left.dataType match {
            case FloatType  =>
              compileExpr[Float](left)(rec) - compileExpr[Float](right)(rec)
            case DoubleType  =>
              compileExpr[Double](left)(rec) - compileExpr[Double](right)(rec)
            case IntegerType =>
              compileExpr[Int](left)(rec) - compileExpr[Int](right)(rec)
            case LongType =>
              compileExpr[Long](left)(rec) - compileExpr[Long](right)(rec)
          }
          res.asInstanceOf[Rep[T]]
        case Multiply(left, right) =>
          val res = left.dataType match {
            case FloatType  =>
              compileExpr[Float](left)(rec) * compileExpr[Float](right)(rec)
            case DoubleType  =>
              compileExpr[Double](left)(rec) * compileExpr[Double](right)(rec)
            case IntegerType =>
              compileExpr[Int](left)(rec) * compileExpr[Int](right)(rec)
            case LongType =>
              compileExpr[Long](left)(rec) * compileExpr[Long](right)(rec)
          }
          res.asInstanceOf[Rep[T]]
        case Divide(left, right) =>
          val res = left.dataType match {
            case FloatType  =>
              compileExpr[Float](left)(rec) / compileExpr[Float](right)(rec)
            case DoubleType  =>
              val ll = compileExpr[Double](left)(rec)
              val rr = compileExpr[Double](right)(rec)
              ll / rr
            case IntegerType =>
              compileExpr[Int](left)(rec) / compileExpr[Int](right)(rec)
            case LongType =>
              compileExpr[Long](left)(rec) / compileExpr[Long](right)(rec)
          }
          res.asInstanceOf[Rep[T]]
        case CaseWhen(branches) =>
          def aux_t (list:Seq[Expression]): List[(Expression, Expression)] = list match {
            case cond::value::q => (cond, value)::aux_t(q)
            case _ => Nil
          }

          val default = compileExpr[T](branches.last)(rec)

          val list = aux_t(branches)
          def case_t () : Rep[T] = {
            list.foldRight (default) {
              case ((cond, value), rhs) => if (compileExpr[Boolean](cond)(rec))
                                              compileExpr[T](value)(rec)
                                            else
                                              rhs
            }
          }
          case_t()
        case StartsWith(str, pref) =>
          compileExpr[String](str)(rec).startsWith(compileExpr[String](pref)(rec)).asInstanceOf[Rep[T]]
        case EndsWith(str, suff) =>
          compileExpr[String](str)(rec).startsWith(compileExpr[String](suff)(rec)).asInstanceOf[Rep[T]]
        case Contains(str, suff) =>
          compileExpr[String](str)(rec).contains(compileExpr[String](suff)(rec)).asInstanceOf[Rep[T]]
        case Like(left, right) =>

          // Hack
          val token = right match {
            case Literal(value, StringType) => value.toString.split('%')
            case _ => throw new RuntimeException("Like: shouldn't happen")
          }

          val default = unit[Boolean](true).asInstanceOf[Rep[Boolean]]
          val value = compileExpr[String](left)(rec)
          def like_t() : Rep[Boolean] = {
            token.foldLeft (default) {
              case (lhs, p) => infix_&&(lhs, fstring_contains(value, unit[String](p)))
            }
          }
          like_t().asInstanceOf[Rep[T]]
        case Substring(value, idx1, idx2) =>
          compileExpr[String](value)(rec).substring(compileExpr[Int](idx1)(rec), compileExpr[Int](idx2)(rec)).asInstanceOf[Rep[T]]

        case Year(exp) =>
          primitive_forge_int_shift_right_unsigned(date_value(compileExpr[Date](exp)(rec)), unit[Int](9)).asInstanceOf[Rep[T]]
        case In (value, list) =>
          val default = unit[Boolean](false).asInstanceOf[Rep[Boolean]]
          def in_t() : Rep[Boolean] = {
            list.foldRight (default) {
              case (p, rhs) => infix_||(compileExpr[Boolean](EqualTo(p, value))(rec), rhs)
            }
          }
          in_t().asInstanceOf[Rep[T]]
        case IsNull(value) =>
          unit[Boolean](true).asInstanceOf[Rep[T]]
        case a : Expression if a.getClass.getName == aggexp =>
          // class AggregateExpression is private, so we use reflection
          // to get around access control
          val fld = a.getClass.getDeclaredFields.filter(_.getName == "aggregateFunction").head
          fld.setAccessible(true)
          val children = fld.get(a).asInstanceOf[AggregateFunction]
          compileAggExpr[T](children)(rec.asInstanceOf[Rep[Table[Record]]])
        case _ =>
          throw new RuntimeException("compileExpr, TODO: " + d.getClass.getName)
      }

      def getName(p: Expression): String = p match {
        case AttributeReference(name, _, _, _) => name
        case Alias(_, name) => name
        case _ => throw new RuntimeException("getName, TODO: " + p.getClass.getName)
      }

      def fieldInRecord(man: RefinedManifest[Record], exp: Expression) : Boolean = exp match {
        case AttributeReference(name, _, _, _) =>
          man.fields.exists {
            case (n, _) => n == name
          }
        case _ => true
      }

      // TODO: for non-equijoin conditions (e.g. >), return a predicate that will be used as filter after the join
      // TODO: for Or, generate a nested loop join
      def compileCond(cond: Option[Expression], mfl: RefinedManifest[Record], mfr: RefinedManifest[Record]) : (Rep[Record] => Rep[Any], Rep[Record] => Rep[Any], Manifest[Any]) = cond match {
        case Some(EqualTo(le, re)) =>
          val mfk = getType(cond).asInstanceOf[Manifest[Any]]
          val lekey = (p: Rep[Record]) => { compileExpr[Any](le)(p)(mfk) }
          val rekey = (p: Rep[Record]) => { compileExpr[Any](re)(p)(mfk) }
          if (fieldInRecord(mfl, le) && fieldInRecord(mfr, re)) {
            (lekey, rekey, mfk)
          } else if (fieldInRecord(mfl, re) && fieldInRecord(mfr, le)) {
            (rekey, lekey, mfk)
          } else {
            throw new RuntimeException("Invalid syntax")
          }
        case Some(And(le, re)) =>
          val (llekey, rlekey, lmfk) = compileCond(Some(le), mfl, mfr)
          val (lrekey, rrekey, rmfk) = compileCond(Some(re), mfl, mfr)
          val pos = implicitly[SourceContext]

          val lekey = (p: Rep[Record]) => { tup2_pack((llekey(p), lrekey(p)))(lmfk, rmfk, pos, new Overload4()) }
          val rekey = (p: Rep[Record]) => { tup2_pack((rlekey(p), rrekey(p)))(lmfk, rmfk, pos, new Overload4()) }
          val mfk = m_Tup2(lmfk, rmfk).asInstanceOf[Manifest[Any]]
          (lekey, rekey, mfk)

        case Some(value) => throw new RuntimeException("Join: unsupported operation " + value.getClass.getName)
        case None => // Cartersien product
          val key = (p: Rep[Record]) => { unit[Int](1) }
          val mfk = manifest[Int].asInstanceOf[Manifest[Any]]
          (key, key, mfk)
      }

      def compile(d: LogicalPlan): Rep[Table[Record]] = d match {
        case Sort(sortingExpr, global, child) =>
          val res = compile(child)
          val mfa = extractMF(res)
          table_orderby(
            res,
            sortingExpr.map {
              (p:Expression) => p match {
                case SortOrder(child, order) =>
                  child.dataType match {
                    case FloatType =>
                      if (order == Ascending)
                        (x:Rep[Record], y:Rep[Record]) => {
                          (compileExpr[Float](child)(x) - compileExpr[Float](child)(y)).toInt
                        }
                      else
                        (x:Rep[Record], y:Rep[Record]) => {
                          (compileExpr[Float](child)(y) - compileExpr[Float](child)(x)).toInt
                        }
                    case DoubleType =>
                      if (order == Ascending)
                        (x:Rep[Record], y:Rep[Record]) => {
                          (compileExpr[Double](child)(x) - compileExpr[Double](child)(y)).toInt
                        }
                      else
                        (x:Rep[Record], y:Rep[Record]) => {
                          (compileExpr[Double](child)(y) - compileExpr[Double](child)(x)).toInt
                        }
                    case IntegerType =>
                      if (order == Ascending)
                        (x:Rep[Record], y:Rep[Record]) => {
                          compileExpr[Int](child)(x) - compileExpr[Int](child)(y)
                        }
                      else
                        (x:Rep[Record], y:Rep[Record]) => {
                          compileExpr[Int](child)(y) - compileExpr[Int](child)(x)
                        }
                    case LongType =>
                      if (order == Ascending)
                        (x:Rep[Record], y:Rep[Record]) => {
                          (compileExpr[Long](child)(x) - compileExpr[Long](child)(y)).toInt
                        }
                      else
                        (x:Rep[Record], y:Rep[Record]) => {
                          (compileExpr[Long](child)(y) - compileExpr[Long](child)(x)).toInt
                        }
                    case DateType =>
                      if (order == Ascending)
                        (x:Rep[Record], y:Rep[Record]) => {
                          (date_value(compileExpr[Date](child)(x)) - date_value(compileExpr[Date](child)(y))).toInt
                        }
                      else
                        (x:Rep[Record], y:Rep[Record]) => {
                          (date_value(compileExpr[Date](child)(y)) - date_value(compileExpr[Date](child)(x))).toInt
                        }
                    case StringType =>
                      if (order == Ascending)
                        (x:Rep[Record], y:Rep[Record]) => {
                          (compileExpr[String](child)(x).fcharAt(0) - compileExpr[String](child)(y).fcharAt(0)).toInt
                        }
                      else
                        (x:Rep[Record], y:Rep[Record]) => {
                          (compileExpr[String](child)(y).fcharAt(0) - compileExpr[String](child)(x).fcharAt(0)).toInt
                        }
                  }
                case _ => throw new RuntimeException("Sorting Expression " + p.getClass + " not supported")
              }
            }
          )(mfa, implicitly[SourceContext])
        case Aggregate(groupingExpr, aggregateExpr, child) =>
          val res = compile(child)

          if (aggregateExpr.length == 0)
            return res

          val mfa = extractMF(res)
          val pos = implicitly[SourceContext]
          val mfo = ManifestFactory.refinedType[Record](
                  manifest[Record],
                  aggregateExpr.map {p => getName(p)}.toList,
                  aggregateExpr.map { (p:Expression) =>
                      convertType(p)}.toList )

          if (groupingExpr.length == 0) {
            table_object_apply(
              Seq(
                record_new[Record](
                  aggregateExpr.map { (p:Expression) =>
                    val mfp = convertType(p).asInstanceOf[Manifest[Any]]
                    (getName(p), false, (x:Any) => compileExpr[Any](p)(res)(mfp))
                  }
                )(mfo)
              )
            )(mfo, pos, null)
          } else {

            val mfk = ManifestFactory.refinedType[Record](
                    manifest[Record],
                    groupingExpr.map {p => getName(p)}.toList,
                    groupingExpr.map { (p:Expression) =>
                        convertType(p).asInstanceOf[Manifest[_]]}.toList).asInstanceOf[Manifest[Any]]

            val group = table_groupby(
              res,
              {(rec:Rep[Record]) =>
              record_new(
                groupingExpr.map {
                  (p:Expression) =>
                    val mfp = convertType(p).asInstanceOf[Manifest[Any]]
                    (getName(p), false, {(x:Any) => compileExpr[Any](p)(rec)(mfp)})
                }
              )(mfk)
              }
            )(mfa, mfk, pos)


            val mfg = extractMF(group)
            val tmp = table_select(
                group,
                { (coup:Rep[Tup2[Any, Table[Record]]]) =>
                  val key = tup2__1(coup)(mfk, pos)
                  val tab = tup2__2(coup)(res.tp.asInstanceOf[Manifest[Table[Record]]],pos)
                  val tmp = record_new[Record](aggregateExpr.map {
                    (p:NamedExpression) =>
                      val mfp = convertType(p).asInstanceOf[Manifest[Any]]
                      p match {
                        case AttributeReference(_, _, _, _) =>
                          (getName(p), false, {(x:Any) => compileExpr[Any](p)(key)(mfp)})
                        case _ =>
                          (getName(p), false, {(x:Any) => compileExpr[Any](p)(tab)(mfp)})
                      }
                  })(mfo)
                  tmp
                }
               )(mfg, mfo, pos)
            tmp
          }

        case Project(projectList, child) =>
          val res = compile(child)

          if (projectList.length == 0)
            return res


          val mfb = extractMF(res)
          val mfa = ManifestFactory.refinedType[Record](
                  manifest[Record],
                  projectList.map {p => getName(p)}.toList,
                  projectList.map { (p:NamedExpression) =>
                      convertType(p)}.toList )
          table_select(
            res,
            { (rec:Rep[Record]) =>
              record_new[Record](projectList.map {
                (p:NamedExpression) => val mfp = convertType(p).asInstanceOf[Manifest[Any]]
                  (getName(p), false, (x:Any) => compileExpr[Any](p)(rec)(mfp))
                }
              )(mfa)
            }
          )(mfb, mfa, implicitly[SourceContext])
        case Filter(condition, child) =>
          val res = compile(child)
          val mf = extractMF(res)
          table_where(res, { (rec:Rep[Record]) =>
            compileExpr[Boolean](condition)(rec)
          })(mf, implicitly[SourceContext])
        case Limit(value, child) =>
          val res = compile(child)
          res
        case a: LeafNode if a.getClass.getName == lgr =>
          // class LogicalRelation is private, so we use reflection
          // to get around access control
          val fld = a.getClass.getDeclaredFields.filter(_.getName == "relation").head
          fld.setAccessible(true)
          val relation = fld.get(a).asInstanceOf[BaseRelation]
          relation match {
            case relation: CsvRelation =>
              //println("schema:")
              //println(relation.schema)
              /*
              println("got it: ")
              println(relation)
              println("location:")
              println(relation.location)
              println("delimiter:")
              println(relation.delimiter)
               */
              trait TYPE
              implicit val mf: Manifest[TYPE] = convertDataType(relation.schema).asInstanceOf[Manifest[TYPE]]

              Table.fromFile[TYPE](relation.location, escapeDelim(relation.delimiter)).asInstanceOf[Rep[Table[Record]]]

          }
        case Join(left, right, tpe, cond) =>
          val resl = compile(left)
          val resr = compile(right)

          val mfl = extractMF(resl)
          val mfr = extractMF(resr)

          tpe match {
            case Inner =>
              val mfo = appendMan(mfl.asInstanceOf[RefinedManifest[Record]], mfr.asInstanceOf[RefinedManifest[Record]])
              val reskey =
                (l: Rep[Record], r: Rep[Record]) => {
                  record_new[Record](
                    mfl.asInstanceOf[RefinedManifest[Record]].fields.map {
                      case (name, _) => (name, false, (x:Rep[Record]) => field[Any](l, name))
                    }
                    ++
                    mfr.asInstanceOf[RefinedManifest[Record]].fields.map {
                      case (name, _) => (name, false, (x:Rep[Record]) => field[Any](r, name))
                    }
                  )(mfo)
                }

              val (lkey, rkey, mfk) = compileCond(cond, mfl.asInstanceOf[RefinedManifest[Record]], mfr.asInstanceOf[RefinedManifest[Record]])
              table_join(resl, resr, lkey, rkey, reskey)(mfl, mfr, mfk, mfo, implicitly[SourceContext])
            case LeftOuter =>
              val reskey =
                (l: Rep[Record], r: Rep[Record]) => l
              val (lkey, rkey, mfk) = compileCond(cond, mfl.asInstanceOf[RefinedManifest[Record]], mfr.asInstanceOf[RefinedManifest[Record]])
              table_join(resl, resr, lkey, rkey, reskey)(mfl, mfr, mfk, mfl, implicitly[SourceContext])
            case RightOuter =>
              val reskey =
                (l: Rep[Record], r: Rep[Record]) => r
              val (lkey, rkey, mfk) = compileCond(cond, mfl.asInstanceOf[RefinedManifest[Record]], mfr.asInstanceOf[RefinedManifest[Record]])
              table_join(resl, resr, lkey, rkey, reskey)(mfl, mfr, mfk, mfl, implicitly[SourceContext])
            case _ => throw new RuntimeException(tpe.toString + " joins is not supported")
          }
        case a if a.getClass.getName == expcl =>
          val flp = a.getClass.getDeclaredFields.filter(_.getName == "projections").head
          flp.setAccessible(true)
          val projections = flp.get(a).asInstanceOf[Seq[Seq[Expression]]]
          val flo = a.getClass.getDeclaredFields.filter(_.getName == "output").head
          flo.setAccessible(true)
          val output = flo.get(a).asInstanceOf[Seq[Seq[Expression]]]
          val flc = a.getClass.getDeclaredFields.filter(_.getName == "child").head
          flc.setAccessible(true)
          val child = flc.get(a).asInstanceOf[LogicalPlan]
          compile(child)
        case _ => throw new RuntimeException("unknown query operator: " + d.getClass)
      }

      override def main() {
        println("TPC-H")

        val res = compile(d)
        System.out.println("Compiled")

        val mf = extractMF(res)
        infix_printAsTable(res, 20)(mf, implicitly[SourceContext])
        System.out.println("Done")
      }
    }
    DeliteRunner.compileAndTest(DeliteQuery)
  }
}
