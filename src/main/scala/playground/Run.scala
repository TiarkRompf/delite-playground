// test -- this can be run from the repl
package playground

import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.catalyst.plans._
import org.apache.spark.sql.execution.datasources.LogicalRelation
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.DataFrame
import com.databricks.spark.csv.CsvRelation
import org.apache.spark.sql.execution.datasources.HadoopFsRelation
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.expressions.aggregate._
import org.apache.spark.sql.execution.datasources.ListingFileCatalog

import optimql.compiler._
import optimql.library._
import optimql.shared._
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

  type NMap = scala.collection.Map[Any,Any]

  def convertDataType(e: DataType, metadata: Metadata = null) : Manifest[_] = e match {
      case ByteType => manifest[Char]
      case BooleanType => manifest[Boolean]
      case IntegerType => manifest[Int]
      case LongType => manifest[Long]
      case DoubleType => manifest[Double]
      case DateType => manifest[java.util.Date]
      case StringType => if (metadata != null && metadata.contains("length") && metadata.getLong("length") == 1) {
        manifest[Char]
      } else manifest[String]
      // case StructType(fields) =>
      //   val names = fields map {
      //     case StructField(name,tpe,nullable,metadata) => name
      //   }
      //   val elems = fields map {
      //     case StructField(name,tpe,nullable,metadata) => convertDataType(tpe,metadata)
      //   }
      //   ManifestFactory.refinedType[Record](manifest[Record], names.toList, elems.toList)
      case _ => throw new RuntimeException("convertDataType, TODO: " + e.toString)
  }

  def convertType(e: Expression): Manifest[_] = e match {
    case Count(_) => manifest[Long]
    case Alias(Count(_), _) => manifest[Long]
    case AttributeReference(_,tpe,_,metadata) => convertDataType(tpe,metadata)
    case _ => convertDataType(e.dataType)
  }

  def getType(e: Option[Expression]) : Manifest[_] = e match {
    case Some(EqualTo(left, right)) => convertType(left)
    case _ => manifest[Any]
  }

  def escapeDelim(c: Char) = if (c == '|') "\\|" else c.toString

  def filterUseless(exp: Expression): Option[Expression] = exp match {
    case And(e1, e2)          => filterUseless(e1) match {
      case None                 => filterUseless(e2)
      case Some(a)              => filterUseless(e2) match {
        case None               => Some(a)
        case Some(b)            => Some(And(a, b))
      }
    }
    case IsNotNull(_)           => None
    case _                      => Some(exp)
  }

  def reorderString(exp: Expression): (Expression, Int) = exp match {
    case AttributeReference(_, StringType, _, _) => (exp, 2)
    case Literal(_, StringType) => (exp, 2)
    case And(left, right) =>
      val (l, ll) = reorderString(left)
      val (r, rl) = reorderString(right)
      if (ll > rl)
        (And(r, l), ll)
      else
        (And(l, r), rl)
    case Or(left, right) =>
      val (l, ll) = reorderString(left)
      val (r, rl) = reorderString(right)
      if (ll > rl)
        (Or(r, l), ll)
      else
        (Or(l, r), rl)
    case Not(value) => val (e, l) = reorderString(value)
      (Not(e), l)
    case LessThan(a,b) =>
      a.dataType match {
        case StringType   => (exp, 2)
        case _            => (exp, 1)
      }
    case LessThanOrEqual(a,b) =>
      a.dataType match {
        case StringType   => (exp, 2)
        case _            => (exp, 1)
      }
    case GreaterThan(a,b) =>
      a.dataType match {
        case StringType   => (exp, 2)
        case _            => (exp, 1)
      }
    case GreaterThanOrEqual(a,b) =>
      a.dataType match {
        case StringType   => (exp, 2)
        case _            => (exp, 1)
      }
    case EqualTo(a,b) =>
      a.dataType match {
        case StringType   => (exp, 2)
        case _            => (exp, 1)
      }
    case CaseWhen(branches, defval) => (exp, 1)
    case CaseWhenCodegen(branches, defval) => (exp, 1)
    case StartsWith(str, pref) => (exp, 2)
    case EndsWith(str, suff) => (exp, 2)
    case Contains(str, suff) => (exp, 2)
    case Like(left, right) => (exp, 3)
    case Substring(value, idx1, idx2) => (exp, 2)
    case In (value, list) =>
      value.dataType match {
        case StringType   => (exp, 3)
        case _            => (exp, 2)
      }
    case IsNull(value)    =>
      val (e, l) = reorderString(value)
      (IsNull(e), l)
    case IsNotNull(value) =>
      val (e, l) = reorderString(value)
      (IsNotNull(e), l)
    case _ => (exp, 1)
  }

  def runOptiMQLExample(spark: SparkSession, file: String) = {
    object DeliteQuery extends OptiMQLApplicationCompiler with DeliteTestRunner {

      val preloadData = false

      //TODO: merge this into standard SoA transform and check safety
      // TODO Tiark: this is not enough to have a Delite-Like OptiQL
      // override def transformLoop(stm: Stm): Option[Exp[Any]] = stm match {
      //   case TP(sym, r:DeliteOpReduceLike[_]) if r.mutable => None // mutable reduces don't work yet
      //   case TP(sym, Loop(size, v, body: DeliteReduceElem[a])) => soaReduce[a](size,v,body)(body.mA)
      //   case TP(sym, Loop(size, v, body: DeliteHashReduceElem[k,v,i,cv])) => soaHashReduce[k,v,i,cv](size,v,body)(body.mK,body.mV,body.mI,body.mCV)
      //   case _ => super.transformLoop(stm)
      // }

      override def structName[T](m: Manifest[T]): String = m match {
        case rm: RefinedManifest[_] =>
          // order matters here!!
          "Anon" + math.abs(rm.fields.map(f => f._1.## + f._2.toString.##).##)
        case _ => super.structName(m)
      }

      import java.io.{PrintWriter,StringWriter}
      import scala.virtualization.lms.internal.{GenericFatCodegen}

      // TODO: Tiark: This code do not compile with OptiQML
      // prettify & indent generated code files output
      // override def emitRegisteredSource(gen: GenericFatCodegen{val IR: DeliteQuery.this.type}, stream: PrintWriter): List[(Sym[Any], Any)] = {
      //   def printIndented(str: String)(out: PrintWriter): Unit = {
      //     val lines = str.split("[\n\r]")
      //     var indent: Int = 0
      //     for (l0 <- lines) {
      //       val l = l0.trim
      //       if (l.length > 0) {
      //         var open: Int = 0
      //         var close: Int = 0
      //         var initClose: Int = 0
      //         var nonWsChar: Boolean = false
      //         l foreach {
      //           case '{' => {
      //             open += 1
      //             if (!nonWsChar) {
      //               nonWsChar = true
      //               initClose = close
      //             }
      //           }
      //           case '}' => close += 1
      //           case x => if (!nonWsChar && !x.isWhitespace) {
      //             nonWsChar = true
      //             initClose = close
      //           }
      //         }
      //         if (!nonWsChar) initClose = close
      //         out.println("  " * (indent - initClose) + l)
      //         indent += (open - close)
      //       }
      //     }
      //     assert (indent==0, "indentation sanity check")
      //   }
      //   val s = new StringWriter
      //   val p = new PrintWriter(s)
      //   val res = super.emitRegisteredSource(gen, p)
      //   p.close()
      //   val content = s.toString
      //   printIndented(content)(stream)
      //   stream.flush()
      //   res
      // }


      def extractMF[T](x: Rep[Table[T]]): Manifest[T] = {
       //  println(x.tp.typeArguments)
        x.tp.typeArguments.head.asInstanceOf[Manifest[T]]
      }

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

      val intnull    = unit[Int](0x7FFFFFFF)
      val longnull   = unit[Long](0x7FFFFFFF)
      val floatnull  = unit[Float](1e20f)
      val doublenull = unit[Double](1e20)
      val datenull   = Date(0)
      val strnull    = unit[String]("")

      def nullrec(v1 : RefinedManifest[Record]): Rep[Record] = {
        record_new[Record](
          v1.fields.map {
            case (name, man) if man == manifest[Int]    => (name, false, (x:Any) => intnull)
            case (name, man) if man == manifest[Long]   => (name, false, (x:Any) => longnull)
            case (name, man) if man == manifest[Float]  => (name, false, (x:Any) => floatnull)
            case (name, man) if man == manifest[Double] => (name, false, (x:Any) => doublenull)
            case (name, man) if man == manifest[java.util.Date]   => (name, false, (x:Any) => datenull)
            case (name, man) if man == manifest[String] => (name, false, (x:Any) => strnull)
            case (name, man) => throw new RuntimeException(">> " + man.getClass)
          }
        )(v1)

      }

      val metadatas = scala.collection.mutable.HashMap[String,Long]()
      def convertAttribRefsType(fields: Seq[AttributeReference]) : RefinedManifest[Record] = {
        val names = fields map (a => getName(a))
        val elems = fields map (a => convertDataType(a.dataType, a.metadata))
        fields foreach {
          case a@AttributeReference(name, StringType, _, metadata) => if (metadata contains "length") metadatas += (getName(a) -> (metadata getLong "length"))
          case _                                                 => ()
        }
        ManifestFactory.refinedType[Record](manifest[Record], names.toList, elems.toList).asInstanceOf[RefinedManifest[Record]]
      }

      def isnull(value: Expression, input: Map[LogicalRelation,Rep[Table[Record]]])(l: Rep[Record]): Rep[Boolean] = {
          value.dataType match {
            case IntegerType  => compileExpr[Int](value, input)(l) == intnull
            case LongType     => compileExpr[Long](value, input)(l) == longnull
            case FloatType    => compileExpr[Float](value, input)(l) == floatnull
            case DoubleType   => compileExpr[Double](value, input)(l) == doublenull
            case DateType     => compileExpr[Date](value, input)(l) == datenull
            case StringType   => compileExpr[String](value, input)(l) == strnull
          }
      }

      sealed class FlareUDF
      case class InternalUDF(func: Any) extends FlareUDF
      case class ExternalUDF(func: Any) extends FlareUDF

      def compileAggExpr[T:Manifest](d: AggregateFunction, input: Map[LogicalRelation,Rep[Table[Record]]])(rec: Rep[Table[Record]]): Rep[T] = d match {
        case org.apache.spark.sql.catalyst.expressions.aggregate.Sum(child) =>
          val res = child.dataType match {
            case FloatType  =>
              rec.Sum(l => compileExpr[Float](child, input)(l))
            case DoubleType  =>
              rec.Sum(l => compileExpr[Double](child, input)(l))
            case IntegerType =>
              rec.Sum(l => compileExpr[Int](child, input)(l))
            case LongType =>
              rec.Sum(l => compileExpr[Long](child, input)(l))
          }
          res.asInstanceOf[Rep[T]]
        case Average(child) =>
          val res = child.dataType match {
            case FloatType  =>
              rec.Average(l => compileExpr[Float](child, input)(l))
            case DoubleType  =>
              rec.Average(l => compileExpr[Double](child, input)(l))
            //case IntegerType =>
            //  rec.Average(l => compileExpr[Fractional[Int]](child)(l))
            //case LongType =>
            //  rec.Average(l => compileExpr[Fractional[Long]](child)(l))
            case _ => throw new RuntimeException("Average, " + child.dataType)
          }
          res.asInstanceOf[Rep[T]]
        case Count(child) =>
          val res = child.head match {
            case AttributeReference(_, _, _, _) => rec.Count((l: Rep[Record]) => !isnull(child.head, input)(l))
            case _ => rec.Count()
          }
          res.asInstanceOf[Rep[T]]
        case Min(child) =>
          val res = child.dataType match {
            case IntegerType  => rec.Min(l => compileExpr[Int](child, input)(l))
            case LongType     => rec.Min(l => compileExpr[Long](child, input)(l))
            case FloatType    => rec.Min(l => compileExpr[Float](child, input)(l))
            case DoubleType   => rec.Min(l => compileExpr[Double](child, input)(l))
            //case DateType     => rec.Min(l => compileExpr[Date](child)(l))
            case StringType   => rec.Min(l => compileExpr[String](child, input)(l))
            case _ => throw new RuntimeException("Min: TODO " + child.dataType)
          }
          res.asInstanceOf[Rep[T]]
        case Max(child) =>
          val res = child.dataType match {
            case IntegerType  => rec.Max(l => compileExpr[Int](child, input)(l))
            case LongType     => rec.Max(l => compileExpr[Long](child, input)(l))
            case FloatType    => rec.Max(l => compileExpr[Float](child, input)(l))
            case DoubleType   => rec.Max(l => compileExpr[Double](child, input)(l))
            //case DateType     => rec.Min(l => compileExpr[Date](child, input)(l))
            case StringType   => rec.Max(l => compileExpr[String](child, input)(l))
            case _ => throw new RuntimeException("Max: TODO " + child.dataType)
          }
          res.asInstanceOf[Rep[T]]
        case _ => throw new RuntimeException("TODO: AggregateExpression, " + d.getClass.getName)
      }

      def nullvalue(e: DataType): Rep[_] = e match {
        case FloatType    => floatnull
        case DoubleType   => doublenull
        case IntegerType  => intnull
        case LongType     => longnull
        case DateType     => datenull
        case StringType   => strnull
      }

      def compileExpr[T:Manifest](d: Expression, input: Map[LogicalRelation,Rep[Table[Record]]])(rec: Rep[_]): Rep[T] = d match {
        case AttributeReference(_, _, _, _) =>
          field[T](rec, getName(d))
        case Literal(null, tpe) => nullvalue(tpe).asInstanceOf[Rep[T]]
        case Literal(value, DateType) =>
          val tmp = conv_date(value.asInstanceOf[Int])
          tmp.asInstanceOf[Rep[T]]
        case Literal(value, StringType) =>
          unit[String](String.valueOf(value)).asInstanceOf[Rep[T]]
        case Literal(value, _) =>
          unit[T](value.asInstanceOf[T])
        case And(left, right) =>
          infix_&&(compileExpr[Boolean](left, input)(rec), compileExpr[Boolean](right, input)(rec)).asInstanceOf[Rep[T]]
        case Or(left, right) =>
          infix_||(compileExpr[Boolean](left, input)(rec), compileExpr[Boolean](right, input)(rec)).asInstanceOf[Rep[T]]
        case Not(value) =>
          (!compileExpr[Boolean](value, input)(rec)).asInstanceOf[Rep[T]]
        case LessThan(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a, input)(rec) < compileExpr[Float](b, input)(rec)
            case DoubleType   => compileExpr[Double](a, input)(rec) < compileExpr[Double](b, input)(rec)
            case IntegerType  => compileExpr[Int](a, input)(rec) < compileExpr[Int](b, input)(rec)
            case LongType     => compileExpr[Long](a, input)(rec) < compileExpr[Long](b, input)(rec)
            case DateType     => compileExpr[Date](a, input)(rec) < compileExpr[Date](b, input)(rec)
            case StringType   => compileExpr[String](a, input)(rec) < compileExpr[String](b, input)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case LessThanOrEqual(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a, input)(rec) <= compileExpr[Float](b, input)(rec)
            case DoubleType   => compileExpr[Double](a, input)(rec) <= compileExpr[Double](b, input)(rec)
            case IntegerType  => compileExpr[Int](a, input)(rec) <= compileExpr[Int](b, input)(rec)
            case LongType     => compileExpr[Long](a, input)(rec) <= compileExpr[Long](b, input)(rec)
            case DateType     => compileExpr[Date](a, input)(rec) <= compileExpr[Date](b, input)(rec)
            case StringType   => compileExpr[String](a, input)(rec) <= compileExpr[String](b, input)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case GreaterThan(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a, input)(rec) > compileExpr[Float](b, input)(rec)
            case DoubleType   => compileExpr[Double](a, input)(rec) > compileExpr[Double](b, input)(rec)
            case IntegerType  => compileExpr[Int](a, input)(rec) > compileExpr[Int](b, input)(rec)
            case LongType     => compileExpr[Long](a, input)(rec) > compileExpr[Long](b, input)(rec)
            case DateType     => compileExpr[Date](a, input)(rec) > compileExpr[Date](b, input)(rec)
            case StringType   => compileExpr[String](a, input)(rec) > compileExpr[String](b, input)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case GreaterThanOrEqual(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a, input)(rec) >= compileExpr[Float](b, input)(rec)
            case DoubleType   => compileExpr[Double](a, input)(rec) >= compileExpr[Double](b, input)(rec)
            case IntegerType  => compileExpr[Int](a, input)(rec) >= compileExpr[Int](b, input)(rec)
            case LongType     => compileExpr[Long](a, input)(rec) >= compileExpr[Long](b, input)(rec)
            case DateType     => compileExpr[Date](a, input)(rec) >= compileExpr[Date](b, input)(rec)
            case StringType   => compileExpr[String](a, input)(rec) >= compileExpr[String](b, input)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case EqualTo(a,b) =>
          val bo = a.dataType match {
            case FloatType    => compileExpr[Float](a, input)(rec) == compileExpr[Float](b, input)(rec)
            case DoubleType   => compileExpr[Double](a, input)(rec) == compileExpr[Double](b, input)(rec)
            case IntegerType  => compileExpr[Int](a, input)(rec) == compileExpr[Int](b, input)(rec)
            case LongType     => compileExpr[Long](a, input)(rec) == compileExpr[Long](b, input)(rec)
            case DateType     => compileExpr[Date](a, input)(rec) == compileExpr[Date](b, input)(rec)
            case StringType   => compileExpr[String](a, input)(rec) == compileExpr[String](b, input)(rec)
          }
          bo.asInstanceOf[Rep[T]]
        case Alias(child, name) =>
          compileExpr[T](child, input)(rec)
        case Cast(child, dataType) =>
          compileExpr[T](child, input)(rec)
        case Add(left, right) =>
          val res = left.dataType match {
            case FloatType  =>
              compileExpr[Float](left, input)(rec) + compileExpr[Float](right, input)(rec)
            case DoubleType  =>
              compileExpr[Double](left, input)(rec) + compileExpr[Double](right, input)(rec)
            case IntegerType =>
              compileExpr[Int](left, input)(rec) + compileExpr[Int](right, input)(rec)
            case LongType =>
              compileExpr[Long](left, input)(rec) + compileExpr[Long](right, input)(rec)
          }
          res.asInstanceOf[Rep[T]]
        case Subtract(left, right) =>
          val res = left.dataType match {
            case FloatType  =>
              compileExpr[Float](left, input)(rec) - compileExpr[Float](right, input)(rec)
            case DoubleType  =>
              compileExpr[Double](left, input)(rec) - compileExpr[Double](right, input)(rec)
            case IntegerType =>
              compileExpr[Int](left, input)(rec) - compileExpr[Int](right, input)(rec)
            case LongType =>
              compileExpr[Long](left, input)(rec) - compileExpr[Long](right, input)(rec)
          }
          res.asInstanceOf[Rep[T]]
        case Multiply(left, right) =>
          val res = left.dataType match {
            case FloatType  =>
              compileExpr[Float](left, input)(rec) * compileExpr[Float](right, input)(rec)
            case DoubleType  =>
              compileExpr[Double](left, input)(rec) * compileExpr[Double](right, input)(rec)
            case IntegerType =>
              compileExpr[Int](left, input)(rec) * compileExpr[Int](right, input)(rec)
            case LongType =>
              compileExpr[Long](left, input)(rec) * compileExpr[Long](right, input)(rec)
          }
          res.asInstanceOf[Rep[T]]
        case Divide(left, right) =>
          val res = left.dataType match {
            case FloatType  =>
              compileExpr[Float](left, input)(rec) / compileExpr[Float](right, input)(rec)
            case DoubleType  =>
              compileExpr[Double](left, input)(rec) / compileExpr[Double](right, input)(rec)
            case IntegerType =>
              compileExpr[Int](left, input)(rec) / compileExpr[Int](right, input)(rec)
            case LongType =>
              compileExpr[Long](left, input)(rec) / compileExpr[Long](right, input)(rec)
          }
          res.asInstanceOf[Rep[T]]
        case CaseWhen(branches, defval) =>
          val default = defval match {
            case None        => nullvalue(branches.head._2.dataType).asInstanceOf[Rep[T]]
            case Some(value) => compileExpr[T](value, input)(rec)
          }
          branches.foldRight (default) {
            case ((cond, value), rhs) => if (compileExpr[Boolean](cond, input)(rec))
                                            compileExpr[T](value, input)(rec)
                                          else
                                            rhs
          }
        case CaseWhenCodegen(branches, defval) =>
          val default = defval match {
            case None        => nullvalue(branches.head._2.dataType).asInstanceOf[Rep[T]]
            case Some(value) => compileExpr[T](value, input)(rec)
          }
          branches.foldRight (default) {
            case ((cond, value), rhs) => if (compileExpr[Boolean](cond, input)(rec))
                                            compileExpr[T](value, input)(rec)
                                          else
                                            rhs
          }
        case StartsWith(str, pref) =>
          compileExpr[String](str, input)(rec).startsWith(compileExpr[String](pref, input)(rec)).asInstanceOf[Rep[T]]
        case EndsWith(str, suff) =>
          compileExpr[String](str, input)(rec).endsWith(compileExpr[String](suff, input)(rec)).asInstanceOf[Rep[T]]
        case Contains(str, suff) =>
          compileExpr[String](str, input)(rec).contains(compileExpr[String](suff, input)(rec)).asInstanceOf[Rep[T]]
        case Like(left, right) =>

          // Hack
          // TODO use indexWhere(c => "%_".contains(c))
          val token = right match {
            case Literal(value, StringType) => value.toString.split('%').toList.filter(_.length > 0)
            case _ => throw new RuntimeException("Like: shouldn't happen")
          }

          val minusone = unit[Int](-1).asInstanceOf[Rep[Int]]
          val zero = unit[Int](0).asInstanceOf[Rep[Int]]
          val value = compileExpr[String](left, input)(rec)

          def res(l: List[String], idx: Rep[Int]): Rep[Boolean] = l match {
            case h::q => val idxx = fstring_indexof(value, unit[String](h), idx)
                         if (idxx == minusone)
                            unit[Boolean](false)
                         else
                            res(q, idxx + h.length)
            case Nil => unit[Boolean](true)
          }

          res(token, zero).asInstanceOf[Rep[T]]
        case Substring(value, idx1, idx2) =>
          val tmp = compileExpr[Int](idx1, input)(rec) - 1
          fstring_substring(compileExpr[String](value, input)(rec), tmp, tmp + compileExpr[Int](idx2, input)(rec))(implicitly[SourceContext], new Overload2).asInstanceOf[Rep[T]]

        case Year(exp) =>
          primitive_forge_int_shift_right_unsigned(date_value(compileExpr[Date](exp, input)(rec)), unit[Int](9)).asInstanceOf[Rep[T]]
        case In (value, list) =>
          val default = unit[Boolean](false).asInstanceOf[Rep[Boolean]]
          // TODO improve code?
          val res = list.foldRight (default) {
              case (p, rhs) => infix_||(rhs, compileExpr[Boolean](EqualTo(p, value), input)(rec))
            }
          res.asInstanceOf[Rep[T]]
        case IsNull(value) =>
          val res = isnull(value, input)(rec.asInstanceOf[Rep[Record]])
          res.asInstanceOf[Rep[T]]
        case IsNotNull(value) =>
          val res = !isnull(value, input)(rec.asInstanceOf[Rep[Record]])
          res.asInstanceOf[Rep[T]]
        case If(condition, firstbranch, secondbranch) =>
          filterUseless(condition) match {
            case Some (condition) =>
              val (rcond, _) = reorderString(condition)
              if (compileExpr[Boolean](rcond, input)(rec))
                compileExpr[T](firstbranch, input)(rec)
              else
                compileExpr[T](secondbranch, input)(rec)
            case None => // System.out.println("Filter removed (" + condition + ")")
              compileExpr[T](secondbranch, input)(rec)
          }
        case AggregateExpression(child, _, _, _) =>
          compileAggExpr[T](child, input)(rec.asInstanceOf[Rep[Table[Record]]])
        case ScalarSubquery(query, children, id) =>
          val res = compile(query, null)
          val mf = extractMF(res)
          field[T](table_first(res)(mf, implicitly[SourceContext]), mf.asInstanceOf[RefinedManifest[Record]].fields.head._1)
        case ScalaUDF(function, dataType,  children,  inputTypes) =>

          val extractedFunction = udfMap(function) match {
            case InternalUDF(func) => func
            case ExternalUDF(func) => (func.asInstanceOf[(OptiMQLApplicationCompiler) => Any])(this)
          }

          children map { compileExpr[Any](_, input)(rec) } match {
            case Seq(a) =>
              val f = extractedFunction.asInstanceOf[(Rep[Any]) => Rep[T]]
              f(a)

            case Seq(a, b) =>
              val f = extractedFunction.asInstanceOf[(Rep[Any],Rep[Any]) => Rep[T]]
              f(a, b)

            case Seq(a, b, c) =>
              val f = extractedFunction.asInstanceOf[(Rep[Any],Rep[Any],Rep[Any]) => Rep[T]]
              f(a, b, c)

            case Seq(a, b, c, d) =>
              val f = extractedFunction.asInstanceOf[(Rep[Any],Rep[Any],Rep[Any],Rep[Any]) => Rep[T]]
              f(a, b, c, d)

            case Seq(a, b, c, d, e) =>
              val f = extractedFunction.asInstanceOf[(Rep[Any],Rep[Any],Rep[Any],Rep[Any],Rep[Any]) => Rep[T]]
              f(a, b, c, d, e)
          }

        case _ =>
          throw new RuntimeException("compileExpr, TODO: " + d.getClass.getName)
      }

      def getName(p: Expression): String = p match {
        case p@AttributeReference(name, _, _, _) =>
          name.replaceAll("[\\p{Punct}\\s&&[^_]]", "") + "_" + p.exprId.id.toString
        case p@Alias(x, name) =>
          name.replaceAll("[\\p{Punct}\\s&&[^_]]", "") + "_" + p.exprId.id.toString
        case _ => throw new RuntimeException("getName, TODO: " + p.getClass.getName)
      }

      def fieldInRecord(man: RefinedManifest[Record], exp: Expression) : Boolean = exp match {
        case AttributeReference(_, _, _, _) =>
          val name = getName(exp)
          man.fields.exists {
            case (n, _) => n == name
          }
        case _ => true
      }

      sealed trait CondVal
      case class EquiJoin(lkey: Rep[Record] => Rep[Any], rkey: Rep[Record] => Rep[Any], man: Manifest[Any]) extends CondVal
      case class PredicateJoin(pred: (Rep[Record], Rep[Record]) => Rep[Boolean]) extends CondVal
      case class MixedJoin(lkey: Rep[Record] => Rep[Any], rkey: Rep[Record] => Rep[Any], man: Manifest[Any], pred: (Rep[Record], Rep[Record]) => Rep[Boolean]) extends CondVal
      case class CartesianJoin() extends CondVal
      case class Skip() extends CondVal

      def compileCond(cond: Option[Expression], mfl: RefinedManifest[Record], mfr: RefinedManifest[Record], input: Map[LogicalRelation,Rep[Table[Record]]], forcePred: Boolean = false): CondVal = cond match {
        case Some(EqualTo(le, re)) =>
          val mfk = getType(cond).asInstanceOf[Manifest[Any]]
          val lekey = (p: Rep[Record]) => { compileExpr[Any](le, input)(p)(mfk) }
          val rekey = (p: Rep[Record]) => { compileExpr[Any](re, input)(p)(mfk) }
          if (fieldInRecord(mfl, le) && fieldInRecord(mfr, re)) {
            if (forcePred)
              PredicateJoin((l: Rep[Record], r: Rep[Record]) => { lekey(l) == rekey(r) })
            else
              EquiJoin(lekey, rekey, mfk)
          } else if (fieldInRecord(mfl, re) && fieldInRecord(mfr, le)) {
            if (forcePred)
              PredicateJoin((l: Rep[Record], r: Rep[Record]) => { rekey(l) == lekey(r) })
            else
              EquiJoin(rekey, lekey, mfk)
          } else {
            throw new RuntimeException("Invalid syntax")
          }
        case Some(And(le, re)) =>
          (compileCond(Some(le), mfl, mfr, input, forcePred), compileCond(Some(re), mfl, mfr, input, forcePred)) match {
            case (EquiJoin(llkey, rlkey, lmfk), EquiJoin(lrkey, rrkey, rmfk)) =>
              val pos = implicitly[SourceContext]

              val lekey = (p: Rep[Record]) => { tup2_pack((llkey(p), lrkey(p)))(lmfk, rmfk, pos, null) }
              val rekey = (p: Rep[Record]) => { tup2_pack((rlkey(p), rrkey(p)))(lmfk, rmfk, pos, null) }
              val mfk = m_Tup2(lmfk, rmfk).asInstanceOf[Manifest[Any]]
              EquiJoin(lekey, rekey, mfk)
            case (EquiJoin(llkey, lrkey, lmfk), PredicateJoin(pred)) =>
                MixedJoin(llkey, lrkey, lmfk, pred)
            case (PredicateJoin(pred), EquiJoin(rlkey, rrkey, rmfk)) =>
              MixedJoin(rlkey, rrkey, rmfk, pred)
            case (PredicateJoin(lpred), PredicateJoin(rpred)) =>
              PredicateJoin((l, r) => lpred(l, r) && rpred(l, r))
            case (MixedJoin(lkey, rkey, mfk, pred1), PredicateJoin(pred2)) =>
              MixedJoin(lkey, rkey, mfk, (l, r) => pred1(l, r) && pred2(l, r))
            case (MixedJoin(llkey, rlkey, lmfk, pred1), EquiJoin(lrkey, rrkey, rmfk)) =>
              val pos = implicitly[SourceContext]

              val lekey = (p: Rep[Record]) => { tup2_pack((llkey(p), lrkey(p)))(lmfk, rmfk, pos, null) }
              val rekey = (p: Rep[Record]) => { tup2_pack((rlkey(p), rrkey(p)))(lmfk, rmfk, pos, null) }
              val mfk = m_Tup2(lmfk, rmfk).asInstanceOf[Manifest[Any]]

              MixedJoin(lekey, rekey, mfk, pred1)
            case (Skip(), other) => other
            case (other, Skip()) => other
          }
        case Some(Or(le, re)) =>
          (compileCond(Some(le), mfl, mfr, input, true), compileCond(Some(re), mfl, mfr, input, true)) match {
            case (PredicateJoin(pred1), PredicateJoin(pred2)) =>
              val pred = (l: Rep[Record], r: Rep[Record]) => { pred1(l, r) || pred2(l, r) }
              PredicateJoin(pred)
            case (Skip(), _) => compileCond(Some(re), mfl, mfr, input, forcePred)
            case (_, Skip()) => compileCond(Some(le), mfl, mfr, input, forcePred)
            case _ => throw new RuntimeException("ERROR: unsupported operation in Or")
          }
        case Some(In(value, list)) =>
          val default = unit[Boolean](false).asInstanceOf[Rep[Boolean]]
          val pred = (l: Rep[Record], r: Rep[Record]) =>  if (fieldInRecord(mfl, value)) {
            list.foldRight (default) {
              case (p, rhs) => infix_||(compileExpr[Boolean](EqualTo(p, value), input)(l), rhs)
            }
          } else {
            list.foldRight (default) {
              case (p, rhs) => infix_||(compileExpr[Boolean](EqualTo(p, value), input)(r), rhs)
            }
          }
          PredicateJoin(pred)
        case Some(GreaterThanOrEqual(lhs, rhs)) =>
          val pred = (l: Rep[Record], r: Rep[Record]) => {
            val ll = if (fieldInRecord(mfl, lhs)) l else r
            val rr = if (fieldInRecord(mfl, rhs)) l else r
            lhs.dataType match {
              case FloatType    => compileExpr[Float](lhs, input)(ll) >= compileExpr[Float](rhs, input)(rr)
              case DoubleType   => compileExpr[Double](lhs, input)(ll) >= compileExpr[Double](rhs, input)(rr)
              case IntegerType  => compileExpr[Int](lhs, input)(ll) >= compileExpr[Int](rhs, input)(rr)
              case LongType     => compileExpr[Long](lhs, input)(ll) >= compileExpr[Long](rhs, input)(rr)
              case DateType     => compileExpr[Date](lhs, input)(ll) >= compileExpr[Date](rhs, input)(rr)
              case StringType   => compileExpr[String](lhs, input)(ll) >= compileExpr[String](rhs, input)(rr)
            }
          }
          PredicateJoin(pred)
        case Some(GreaterThan(lhs, rhs)) =>
          val pred = (l: Rep[Record], r: Rep[Record]) => {
            val ll = if (fieldInRecord(mfl, lhs)) l else r
            val rr = if (fieldInRecord(mfl, rhs)) l else r
            lhs.dataType match {
              case FloatType    => compileExpr[Float](lhs, input)(ll) > compileExpr[Float](rhs, input)(rr)
              case DoubleType   => compileExpr[Double](lhs, input)(ll) > compileExpr[Double](rhs, input)(rr)
              case IntegerType  => compileExpr[Int](lhs, input)(ll) > compileExpr[Int](rhs, input)(rr)
              case LongType     => compileExpr[Long](lhs, input)(ll) > compileExpr[Long](rhs, input)(rr)
              case DateType     => compileExpr[Date](lhs, input)(ll) > compileExpr[Date](rhs, input)(rr)
              case StringType   => compileExpr[String](lhs, input)(ll) > compileExpr[String](rhs, input)(rr)
            }
          }
          PredicateJoin(pred)
        case Some(LessThanOrEqual(lhs, rhs)) =>
          val pred = (l: Rep[Record], r: Rep[Record]) => {
            val ll = if (fieldInRecord(mfl, lhs)) l else r
            val rr = if (fieldInRecord(mfl, rhs)) l else r
            lhs.dataType match {
              case FloatType    => compileExpr[Float](lhs, input)(ll) <= compileExpr[Float](rhs, input)(rr)
              case DoubleType   => compileExpr[Double](lhs, input)(ll) <= compileExpr[Double](rhs, input)(rr)
              case IntegerType  => compileExpr[Int](lhs, input)(ll) <= compileExpr[Int](rhs, input)(rr)
              case LongType     => compileExpr[Long](lhs, input)(ll) <= compileExpr[Long](rhs, input)(rr)
              case DateType     => compileExpr[Date](lhs, input)(ll) <= compileExpr[Date](rhs, input)(rr)
              case StringType   => compileExpr[String](lhs, input)(ll) <= compileExpr[String](rhs, input)(rr)
            }
          }
          PredicateJoin(pred)
        case Some(LessThan(lhs, rhs)) =>
          val pred = (l: Rep[Record], r: Rep[Record]) => {
            val ll = if (fieldInRecord(mfl, lhs)) l else r
            val rr = if (fieldInRecord(mfl, rhs)) l else r
            lhs.dataType match {
              case FloatType    => compileExpr[Float](lhs, input)(ll) < compileExpr[Float](rhs, input)(rr)
              case DoubleType   => compileExpr[Double](lhs, input)(ll) < compileExpr[Double](rhs, input)(rr)
              case IntegerType  => compileExpr[Int](lhs, input)(ll) < compileExpr[Int](rhs, input)(rr)
              case LongType     => compileExpr[Long](lhs, input)(ll) < compileExpr[Long](rhs, input)(rr)
              case DateType     => compileExpr[Date](lhs, input)(ll) < compileExpr[Date](rhs, input)(rr)
              case StringType   => compileExpr[String](lhs, input)(ll) < compileExpr[String](rhs, input)(rr)
            }
          }
          PredicateJoin(pred)
        case Some(Not(exp)) =>
          compileCond(Some(exp), mfl, mfr, input, true) match {
            case PredicateJoin(cond) => PredicateJoin((l, r) => !cond(l, r))
          }
        case Some(IsNull(_)) => Skip()
        case Some(exp) => throw new RuntimeException("TODO compileCond: " + exp.getClass)
        case None => // Cartesian product
          CartesianJoin()
      }

      def leftouterjoin[A:Manifest,B:Manifest,K:Manifest,R:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]],k1: (Rep[A]) => Rep[K],k2: (Rep[B]) => Rep[K],result: (Rep[A],Rep[B]) => Rep[R], nullval: Rep[B])(implicit __pos: SourceContext): Rep[Table[R]] = {
        val pos = implicitly[SourceContext]
        val grouped = array_buffer_groupBy(array_buffer_new_imm(table_raw_data(t2), array_length(table_raw_data(t2))), k2)
        self.SelectMany(
          e1 => {
            if (fhashmap_contains(grouped, k1(e1))) {
              val buf = fhashmap_get(grouped, k1(e1))
              Table(array_buffer_result(buf), array_buffer_length(buf)).Select(e2 => result(e1, e2))
            } else {
              Table(array_fromseq(Seq(result(e1, nullval))), unit[Int](1))
            }
          }
        )
      }

      def leftouterjoin_pred[A:Manifest,B:Manifest,K:Manifest,R:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]],k1: (Rep[A]) => Rep[K],k2: (Rep[B]) => Rep[K],result: (Rep[A],Rep[B]) => Rep[R], pred: (Rep[A], Rep[B]) => Rep[Boolean], nullval: Rep[B])(implicit __pos: SourceContext): Rep[Table[R]] = {
        val pos = implicitly[SourceContext]
        val grouped = array_buffer_groupBy(array_buffer_new_imm(table_raw_data(t2), array_length(table_raw_data(t2))), k2)
        self.SelectMany(
          e1 => {
            if (fhashmap_contains(grouped, k1(e1))) {
              val buf = fhashmap_get(grouped, k1(e1))
              val res = Table(array_buffer_result(buf), array_buffer_length(buf)).Where(e2 => pred(e1, e2))
              if (table_size(res) > 0)
                res.Select(e2 => result(e1, e2))
              else
                Table(array_fromseq(Seq(result(e1, nullval))), unit[Int](1))
            } else {
              Table(array_fromseq(Seq(result(e1, nullval))), unit[Int](1))
            }
          }
        )
      }

      def leftsemijoin[A:Manifest,B:Manifest,K:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]],k1: (Rep[A]) => Rep[K],k2: (Rep[B]) => Rep[K])(implicit __pos: SourceContext): Rep[Table[A]] = {
        val pos = implicitly[SourceContext]
        val grouped = array_buffer_groupBy(array_buffer_new_imm(table_raw_data(t2), array_length(table_raw_data(t2))), k2)
        self.Where(e1 => fhashmap_contains(grouped, k1(e1)))
      }

      def leftantijoin[A:Manifest,B:Manifest,K:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]],k1: (Rep[A]) => Rep[K],k2: (Rep[B]) => Rep[K])(implicit __pos: SourceContext): Rep[Table[A]] = {
        val pos = implicitly[SourceContext]
        val grouped = array_buffer_groupBy(array_buffer_new_imm(table_raw_data(t2), array_length(table_raw_data(t2))), k2)
        self.Where(e1 => !fhashmap_contains(grouped, k1(e1)))
      }

      def leftsemijoin_mixed[A:Manifest,B:Manifest,K:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]],k1: (Rep[A]) => Rep[K],k2: (Rep[B]) => Rep[K], pred: (Rep[A], Rep[B]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Table[A]] = {
        val pos = implicitly[SourceContext]
        val grouped = array_buffer_groupBy(array_buffer_new_imm(table_raw_data(t2), array_length(table_raw_data(t2))), k2)
        self.Where(
          e1 => {
            if (fhashmap_contains(grouped, k1(e1))) {
              val buf = fhashmap_get(grouped, k1(e1))
              // TODO shortcut
              val res = Table(array_buffer_result(buf), array_buffer_length(buf)).Count((e2: Rep[B]) => pred(e1, e2))
              res > 0
            } else
              unit[Boolean](false)
          }
        )
      }

      def leftantijoin_mixed[A:Manifest,B:Manifest,K:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]],k1: (Rep[A]) => Rep[K],k2: (Rep[B]) => Rep[K], pred: (Rep[A], Rep[B]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Table[A]] = {
        val pos = implicitly[SourceContext]
        val grouped = array_buffer_groupBy(array_buffer_new_imm(table_raw_data(t2), array_length(table_raw_data(t2))), k2)
        self.Where(
          e1 => {
            if (fhashmap_contains(grouped, k1(e1))) {
              val buf = fhashmap_get(grouped, k1(e1))
              // TODO shortcut
              val res = Table(array_buffer_result(buf), array_buffer_length(buf)).Count((e2: Rep[B]) => pred(e1, e2))
              res == 0
            } else
              unit[Boolean](true)
          }
        )
      }

      def leftsemijoin_pred[A:Manifest,B:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]], pred: (Rep[A], Rep[B]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Table[A]] = {
        val pos = implicitly[SourceContext]
        self.Where(
          e1 => {
              // TODO shortcut
              val res = t2.Count((e2: Rep[B]) => pred(e1, e2))
              res > 0
          }
        )
      }

      def leftantijoin_pred[A:Manifest,B:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]], pred: (Rep[A], Rep[B]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Table[A]] = {
        val pos = implicitly[SourceContext]
        self.Where(
          e1 => {
              // TODO shortcut
              val res = t2.Count((e2: Rep[B]) => pred(e1, e2))
              res == 0
          }
        )
      }

      def join2_imple[A:Manifest,B:Manifest,K:Manifest,R:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]],k1: (Rep[A]) => Rep[K],k2: (Rep[B]) => Rep[K],result: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[Table[R]] = {
        val grouped = array_buffer_groupBy(array_buffer_new_imm(table_raw_data(t2), array_length(table_raw_data(t2))), k2)
        val empty = Table(array_empty_imm[R](unit(0)))
        val sol = self.SelectMany(e1 => {
          if (fhashmap_contains(grouped, k1(e1))) {
            val buf = fhashmap_get(grouped, k1(e1))
            Table(array_buffer_unsafe_result(buf), array_buffer_length(buf)).Select(e2 => result(e1,e2))
          }
          else empty
        })
        sol
      }

      def cartesian_join[A:Manifest,B:Manifest,R:Manifest](self: Rep[Table[A]],t2: Rep[Table[B]],result: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[Table[R]] = {
        val sself = table_size(self)
        val st2 = table_size(t2)
        val res = self.SelectMany(e1 => t2.Select(e2 => result(e1, e2)))
        res
      }

      def infix_+(x: Int, y: Option[Int]): Option[Int] = y match {
        case None => None
        case Some(y) => Some(x + y)
      }

      def recordSize(seq: List[(String, Manifest[_])]): Option[Int] = seq match {
        case (_, t) :: q if t == manifest[Char]           => 1 + recordSize(q)
        case (_, t) :: q if t == manifest[Boolean]        => None
        case (_, t) :: q if t == manifest[Int]            => 4 + recordSize(q)
        case (_, t) :: q if t == manifest[Long]           => 8 + recordSize(q)
        case (_, t) :: q if t == manifest[Double]         => None
        case (_, t) :: q if t == manifest[java.util.Date] => 8 + recordSize(q)
        case (_, t) :: q if t == manifest[String]         => None
        case Nil                                          => Some(0)
      }

      def keySelection(groupingExpr: Seq[Expression])(implicit input: Map[LogicalRelation,Rep[Table[Record]]]): (Manifest[Any], Rep[Record] => Rep[Any]) = groupingExpr match {
        case Seq() => throw new RuntimeException("Nothing to group by")
        case Seq(exp) =>
          val mfk = convertType(exp).asInstanceOf[Manifest[Any]]
          (mfk, compileExpr[Any](exp, input)(_)(mfk))
        case _ =>
          val mfk = ManifestFactory.refinedType[Record](
                manifest[Record],
                groupingExpr.map { p => getName(p) }.toList,
                groupingExpr.map { (p:Expression) =>
                    convertType(p).asInstanceOf[Manifest[_]] }.toList).asInstanceOf[Manifest[Any]]


          val size = recordSize(mfk.asInstanceOf[RefinedManifest[Record]].fields)
          if (size == None || size.get > 8)
            (mfk, (rec: Rep[Record]) => record_new(
               groupingExpr.map {
                 (p:Expression) => (getName(p), false, {(x:Any) => compileExpr[Any](p, input)(rec)(convertType(p).asInstanceOf[Manifest[Any]])})
               }
             )(mfk))
          else
            (manifest[Long].asInstanceOf[Manifest[Any]], (rec: Rep[Record]) => (groupingExpr :\ unit[Long](0L).asInstanceOf[Rep[Long]]) {
              case (exp: Expression, agg: Rep[Long]) => convertType(exp) match {
                case man if (man == manifest[Char]) => (agg << 8) + compileExpr[Char](exp,input)(rec)(manifest[Char]).asInstanceOf[Rep[Long]]
                case man if (man == manifest[Int])  => (agg << 32) + compileExpr[Int](exp,input)(rec)(manifest[Int]).asInstanceOf[Rep[Long]]
              }
            })
      }

      def compile(d: LogicalPlan, input: Map[LogicalRelation,Rep[Table[Record]]]): Rep[Table[Record]] = {
        val sol = d match {
          case Sort(sortingExpr, global, child) =>
            val res = compile(child, input)
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
                            if (compileExpr[Float](child, input)(x) < compileExpr[Float](child, input)(y))
                              unit[Int](-1)
                            else if (compileExpr[Float](child, input)(x) > compileExpr[Float](child, input)(y))
                              unit[Int](1)
                            else
                              unit[Int](0)
                          }
                        else
                          (x:Rep[Record], y:Rep[Record]) => {
                            if (compileExpr[Float](child, input)(x) < compileExpr[Float](child, input)(y))
                              unit[Int](1)
                            else if (compileExpr[Float](child, input)(x) > compileExpr[Float](child, input)(y))
                              unit[Int](-1)
                            else
                              unit[Int](0)
                          }
                      case DoubleType =>
                        if (order == Ascending)
                          (x:Rep[Record], y:Rep[Record]) => {
                            if (compileExpr[Double](child, input)(x) < compileExpr[Double](child, input)(y))
                              unit[Int](-1)
                            else if (compileExpr[Double](child, input)(x) > compileExpr[Double](child, input)(y))
                              unit[Int](1)
                            else
                              unit[Int](0)
                          }
                        else
                          (x:Rep[Record], y:Rep[Record]) => {
                            if (compileExpr[Double](child, input)(x) < compileExpr[Double](child, input)(y))
                              unit[Int](1)
                            else if (compileExpr[Double](child, input)(x) > compileExpr[Double](child, input)(y))
                              unit[Int](-1)
                            else
                              unit[Int](0)
                          }
                      case IntegerType =>
                        if (order == Ascending)
                          (x:Rep[Record], y:Rep[Record]) => {
                            compileExpr[Int](child, input)(x) - compileExpr[Int](child, input)(y)
                          }
                        else
                          (x:Rep[Record], y:Rep[Record]) => {
                            compileExpr[Int](child, input)(y) - compileExpr[Int](child, input)(x)
                          }
                      case LongType =>
                        if (order == Ascending)
                          (x:Rep[Record], y:Rep[Record]) => {
                            (compileExpr[Long](child, input)(x) - compileExpr[Long](child, input)(y)).toInt
                          }
                        else
                          (x:Rep[Record], y:Rep[Record]) => {
                            (compileExpr[Long](child, input)(y) - compileExpr[Long](child, input)(x)).toInt
                          }
                      case DateType =>
                        if (order == Ascending)
                          (x:Rep[Record], y:Rep[Record]) => {
                            (date_value(compileExpr[Date](child, input)(x)) - date_value(compileExpr[Date](child, input)(y))).toInt
                          }
                        else
                          (x:Rep[Record], y:Rep[Record]) => {
                            (date_value(compileExpr[Date](child, input)(y)) - date_value(compileExpr[Date](child, input)(x))).toInt
                          }
                      case StringType =>
                        if (order == Ascending)
                          (x:Rep[Record], y:Rep[Record]) => {
                            if (compileExpr[String](child, input)(x) < compileExpr[String](child, input)(y))
                              unit[Int](-1)
                            else if (compileExpr[String](child, input)(x) > compileExpr[String](child, input)(y))
                              unit[Int](1)
                            else
                              unit[Int](0)
                          }
                        else
                          (x:Rep[Record], y:Rep[Record]) => {
                            if (compileExpr[String](child, input)(x) < compileExpr[String](child, input)(y))
                              unit[Int](1)
                            else if (compileExpr[String](child, input)(x) > compileExpr[String](child, input)(y))
                              unit[Int](-1)
                            else
                              unit[Int](0)
                          }
                    }
                  case _ => throw new RuntimeException("Sorting Expression " + p.getClass + " not supported")
                }
              }
            )(mfa, implicitly[SourceContext])
          case Aggregate(groupingExpr, aggregateExpr, child) =>
            val res = compile(child, input)

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
                      (getName(p), false, (x:Any) => compileExpr[Any](p, input)(res)(mfp))
                    }
                  )(mfo)
                )
              )(mfo, pos, null)
            } else {


              val (mfk, keySelect) = keySelection(groupingExpr)(input)

              val group = table_groupby(
                res,
                keySelect
              )(mfa, mfk, pos)


              val mfg = extractMF(group)
              val tmp = table_select(
                  group,
                  { (coup:Rep[Tup2[Any, Table[Record]]]) =>
                    val key = tup2__1(coup)(mfk, pos)
                    val tab = tup2__2(coup)(res.tp.asInstanceOf[Manifest[Table[Record]]],pos)
                    val tmp = record_new[Record](aggregateExpr.map {
                      (p: Expression) =>
                        val mfp = convertType(p).asInstanceOf[Manifest[Any]]
                        p match {
                          case AttributeReference(_, _, _, _) | Alias(AttributeReference(_,_,_,_), _) =>
                            (getName(p), false, {(x:Any) => if (groupingExpr.length == 1) { key } else {
                              compileExpr(p, input)(table_first(tab)(mfo, pos))(mfp)
                              }})
                          case _ =>
                            (getName(p), false, {(x:Any) => compileExpr[Any](p, input)(tab)(mfp)})
                        }
                    })(mfo)
                    tmp
                  }
                 )(mfg, mfo, pos)
              tmp
            }

          case Project(projectList, child) =>
            val res = compile(child, input)

            // TODO handle distinc select

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
                    (getName(p), false, (x:Any) => compileExpr[Any](p, input)(rec)(mfp))
                  }
                )(mfa)
              }
            )(mfb, mfa, implicitly[SourceContext])
          case Filter(condition, child) =>
            val res = compile(child, input)
            filterUseless(condition) match {
              case Some (condition) =>
                val (rcond, _) = reorderString(condition)
                System.out.println("Filter removed (" + rcond + ")")
                val mf = extractMF(res)
                table_where(res, { (rec:Rep[Record]) =>
                  compileExpr[Boolean](rcond, input)(rec)
                })(mf, implicitly[SourceContext])
              case None => // System.out.println("Filter removed (" + condition + ")")
                res
            }
          case Limit(value, child) =>
            val res = compile(child, input)
            res
          case a@LogicalRelation(relation, _, _) =>
            relation match {
              case relation: CsvRelation =>
                if (preloadData) input(a) else {
                  trait TYPE
                  implicit val mf: Manifest[TYPE] = convertAttribRefsType(a.output).asInstanceOf[Manifest[TYPE]]
                  Table.fromFile[TYPE](relation.location, escapeDelim(relation.delimiter)).asInstanceOf[Rep[Table[Record]]]
                }
              case relation if relation.getClass.getName == "org.apache.spark.sql.execution.datasources.HadoopFsRelation" =>//HadoopFsRelation(_, location, _, _, _, _, options) =>
                val locfld = relation.getClass.getDeclaredFields.filter(_.getName == "location").head
                locfld.setAccessible(true)
                val optfld = relation.getClass.getDeclaredFields.filter(_.getName == "options").head
                optfld.setAccessible(true)
                if (preloadData) input(a) else {
                  trait TYPE
                  implicit val mf: Manifest[TYPE] = convertAttribRefsType(a.output).asInstanceOf[Manifest[TYPE]]
                  Table.fromFile[TYPE](locfld.get(relation).asInstanceOf[ListingFileCatalog].paths.head.toString.split(":")(1), escapeDelim((optfld.get(relation).asInstanceOf[Map[String,String]] apply "delimiter").charAt(0))).asInstanceOf[Rep[Table[Record]]]
                }
              case _ => throw new RuntimeException("Relation type missing: " + relation.getClass.getName)
            }
          case Join(left, right, tpe, cond) =>
            val resl = compile(left, input)
            val resr = compile(right, input)

            val mfl = extractMF(resl)
            val mfr = extractMF(resr)
            val mfl_rec = mfl.asInstanceOf[RefinedManifest[Record]]
            val mfr_rec = mfr.asInstanceOf[RefinedManifest[Record]]

            val res = compileCond(cond, mfl_rec, mfr_rec, input) match {
              case EquiJoin(lkey, rkey, mfk) =>
                tpe match {
                  case Inner =>
                    val mfo = appendMan(mfl_rec, mfr_rec)
                    val reskey =
                      (l: Rep[Record], r: Rep[Record]) => {
                        record_new[Record](
                          mfl_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](l, name))
                          }
                          ++
                          mfr_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](r, name))
                          }
                        )(mfo)
                      }

                    join2_imple(resl, resr, lkey, rkey, reskey)(mfl, mfr, mfk, mfo, implicitly[SourceContext])
                  case LeftOuter =>
                    val mfo = appendMan(mfl_rec, mfr_rec)
                    val nullval = nullrec(mfr_rec)
                    val reskey =
                      (l: Rep[Record], r: Rep[Record]) => {
                        record_new[Record](
                          mfl_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](l, name))
                          }
                          ++
                          mfr_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](r, name))
                          }
                        )(mfo)
                      }
                    val pos = implicitly[SourceContext]
                    leftouterjoin(resl, resr, lkey, rkey, reskey, nullval)(mfl, mfr, mfk, mfo, pos)
                  case LeftSemi =>
                    leftsemijoin(resl, resr, lkey, rkey)(mfl, mfr, mfk, implicitly[SourceContext])
                  case LeftAnti =>
                    leftantijoin(resl, resr, lkey, rkey)(mfl, mfr, mfk, implicitly[SourceContext])
                  case _ => throw new RuntimeException(tpe.toString + " joins is not supported")
                }
              case PredicateJoin(pred) =>
                tpe match {
                  case Inner =>
                    val mfo = appendMan(mfl_rec, mfr_rec)
                    val reskey =
                      (l: Rep[Record], r: Rep[Record]) => {
                        record_new[Record](
                          mfl_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](l, name))
                          }
                          ++
                          mfr_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](r, name))
                          }
                        )(mfo)
                      }
                    val pos = implicitly[SourceContext]
                    table_selectmany(
                      resl,
                      {(l: Rep[Record]) =>
                        table_select(
                          table_where(
                            resr,
                            {(r: Rep[Record]) => pred(l, r)}
                          )(mfr, pos),
                          {(r: Rep[Record]) => reskey(l, r)}
                        )(mfr, mfo, pos)
                      }
                    )(mfl, mfo, pos)
                  case LeftSemi => leftsemijoin_pred(resl, resr, pred)(mfl, mfr, implicitly[SourceContext])
                  case LeftAnti => leftantijoin_pred(resl, resr, pred)(mfl, mfr, implicitly[SourceContext])
                }
              case MixedJoin(lkey, rkey, mfk, pred) =>
                tpe match {
                  case Inner =>
                    val mfo = appendMan(mfl_rec, mfr_rec)
                    val reskey =
                      (l: Rep[Record], r: Rep[Record]) => {
                        record_new[Record](
                          mfl_rec.fields.map {
                            case (name, _) =>
                              (name, false, (x:Rep[Record]) => field[Any](l, name))
                          }
                          ++
                          mfr_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](r, name))
                          }
                        )(mfo)
                      }

                    val pos = implicitly[SourceContext]
                    table_where(
                      join2_imple(resl, resr, lkey, rkey, reskey)(mfl, mfr, mfk, mfo, pos),
                      (rec:Rep[Record]) => pred(rec, rec)
                    )(mfo, pos)
                  case LeftOuter =>
                    val mfo = appendMan(mfl_rec, mfr_rec)
                    val nullval = nullrec(mfr_rec)
                    val reskey =
                      (l: Rep[Record], r: Rep[Record]) => {
                        record_new[Record](
                          mfl_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](l, name))
                          }
                          ++
                          mfr_rec.fields.map {
                            case (name, _) => (name, false, (x:Rep[Record]) => field[Any](r, name))
                          }
                        )(mfo)
                      }
                    leftouterjoin_pred(resl, resr, lkey, rkey, reskey, pred, nullval)(mfl, mfr, mfk, mfo, implicitly[SourceContext])
                  case LeftSemi =>
                    leftsemijoin_mixed(resl, resr, lkey, rkey, pred)(mfl, mfr, mfk, implicitly[SourceContext])
                  case LeftAnti =>
                    leftantijoin_mixed(resl, resr, lkey, rkey, pred)(mfl, mfr, mfk, implicitly[SourceContext])
                  case _ => throw new RuntimeException(tpe.toString + " joins is not supported")
                }
              case CartesianJoin() =>
                val mfo = appendMan(mfl_rec, mfr_rec)
                val reskey =
                  (l: Rep[Record], r: Rep[Record]) => {
                    record_new[Record](
                      mfl_rec.fields.map {
                        case (name, _) => (name, false, (x:Rep[Record]) => field[Any](l, name))
                      }
                      ++
                      mfr_rec.fields.map {
                        case (name, _) => (name, false, (x:Rep[Record]) => field[Any](r, name))
                      }
                    )(mfo)
                  }
                cartesian_join(resl, resr, reskey)(mfl, mfr, mfo, implicitly[SourceContext])
            }
            res
          case a if a.getClass.getName == expcl =>
            val flp = a.getClass.getDeclaredFields.filter(_.getName == "projections").head
            flp.setAccessible(true)
            val projections = flp.get(a).asInstanceOf[Seq[Seq[Expression]]]
            val flo = a.getClass.getDeclaredFields.filter(_.getName == "output").head
            flo.setAccessible(true)
            val output = flo.get(a).asInstanceOf[Seq[Expression]]
            val flc = a.getClass.getDeclaredFields.filter(_.getName == "child").head
            flc.setAccessible(true)
            val child = flc.get(a).asInstanceOf[LogicalPlan]
            val res = compile(child, input)

            val mfa = extractMF(res)
            val mfo = ManifestFactory.refinedType[Record](
                    manifest[Record],
                    output.map {p => getName(p)}.toList,
                    output.toList.map { (p:Expression) =>
                        convertType(p)}.toList ).asInstanceOf[Manifest[Any]]

            val pos = implicitly[SourceContext]
            val tres = table_selectmany(
              res,
              {(rec: Rep[Record]) =>
                table_object_apply(
                  projections.map {
                    case (proj: Seq[Expression]) =>
                      record_new(
                        proj.zip(output).map {
                          case (p:Expression, q: Expression) => {
                            val mfp = convertType(p).asInstanceOf[Manifest[Any]]
                            (getName(q), false, (x:Any) => compileExpr[Any](p, input)(rec)(mfp))
                          }
                        }
                      )(mfo)
                  }.toSeq
                )(mfo, pos, new Overload24)
             }
            )(mfa, mfo, pos)
            tres.asInstanceOf[Rep[Table[Record]]]
          case _ => throw new RuntimeException("unknown query operator: " + d.getClass)
        }
        sol
      }

      def preload(d: LogicalPlan): Map[LogicalRelation,Rep[Table[Record]]] = d match {
        case Sort(sortingExpr, global, child) =>
          preload(child)
        case Aggregate(groupingExpr, aggregateExpr, child) =>
          preload(child)
        case Project(projectList, child) =>
          preload(child)
        case Filter(condition, child) =>
          preload(child)
        case Limit(value, child) =>
          preload(child)
        case a@LogicalRelation(relation, _, _) =>
          relation match {
            case relation: CsvRelation =>
              trait TYPE
              implicit val mf: Manifest[TYPE] = convertAttribRefsType(a.output).asInstanceOf[Manifest[TYPE]]
              Map(a -> Table.fromFile[TYPE](relation.location, escapeDelim(relation.delimiter)).asInstanceOf[Rep[Table[Record]]])
            case relation if relation.getClass.getName == "org.apache.spark.sql.execution.datasources.HadoopFsRelation" =>//HadoopFsRelation(_, location, _, _, _, _, options) =>
              val locfld = relation.getClass.getDeclaredFields.filter(_.getName == "location").head
              locfld.setAccessible(true)
              val optfld = relation.getClass.getDeclaredFields.filter(_.getName == "options").head
              optfld.setAccessible(true)
              trait TYPE
              implicit val mf: Manifest[TYPE] = convertAttribRefsType(a.output).asInstanceOf[Manifest[TYPE]]
              Map(a -> Table.fromFile[TYPE](locfld.get(relation).asInstanceOf[ListingFileCatalog].paths.head.toString.split(":")(1), escapeDelim((optfld.get(relation).asInstanceOf[Map[String,String]] apply "delimiter").charAt(0))).asInstanceOf[Rep[Table[Record]]])
          }
        case Join(left, right, tpe, cond) =>
          preload(left) ++ preload(right)
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
          preload(child)
        case _ => throw new RuntimeException("unknown query operator: " + d.getClass)
      }

      private val tol = 0.001 // tolerance (for convergence)
      private val k = 4 // num clusters

      private def tableToMatrix[T:RefinedManifest](tab:Rep[Table[T]]): Rep[DenseMatrix[Double]] = {

        val a = tab.toArray
        val numCols = implicitly[RefinedManifest[T]].fields filter { case (_, man) => man != manifest[String] } length
        val elems = a flatMap { line =>
          array_fromseq(implicitly[RefinedManifest[T]].fields filter {
          case (_, man) => man != manifest[String] } map { case (name, _) => field[Double](line, name) } toSeq
          )
        }

        densematrix_fromarray(elems, tab.size, numCols)
      }

      var udfMap: scala.collection.immutable.Map[Any,FlareUDF] = Map()

      val schema = org.apache.spark.sql.types.StructType(Seq(
        StructField("name", StringType, nullable = false),
        StructField("cluster", IntegerType, nullable = false),
        StructField("murder", DoubleType, nullable = false),
        StructField("assault", IntegerType, nullable = false),
        StructField("population", IntegerType, nullable = false),
        StructField("rape", DoubleType, nullable = false)))

      override def main() = {
        val data = (spark.read
          .option("delimiter", ",")
          .option("header", "true") // use first line of all files as header
          .option("inferschema", "false") // automatically infer data types
          .schema(schema)
          .csv(file))
        data.createOrReplaceTempView("data")

        // val data = Table.fromFile[Data](args(0), sep)
        // val q = data Select(g => new Record {
        //   val murder = g.murder
        //   val assault = g.assault
        //   val pop = g.pop
        //   val rape = g.rape
        // })

        // implicit val man = extractMF(q).asInstanceOf[RefinedManifest[Record]]

        val df = spark.sql("select murder, assault, population, rape from data")
        System.out.println(df.queryExecution.optimizedPlan)
        val tab = compile(df.queryExecution.optimizedPlan, Map())

        val mat = tableToMatrix(tab)(extractMF(tab).asInstanceOf[RefinedManifest[Record]])
        val x = DenseTrainingSet(mat, DenseVector[Double]()) // no labels
        val m = x.numSamples
        val n = x.numFeatures
        val mu = (0::k, *) { i => x(randomInt(m)) }

        println("m:"+m+",n:"+n+",numClusters:"+k+",mu.numRows:"+mu.numRows)

        def findNearestCluster(x_i: Rep[DenseVector[Double]], mu: Rep[DenseMatrix[Double]]): Rep[Int] = {
          (mu mapRowsToVector { row => dist(x_i, row, SQUARE) }).minIndex
        }

        tic(mu)

        val newMu = untilconverged_withdiff(mu, tol){ (mu, iter) =>
          val c = (0::m) { e => findNearestCluster(x(e), mu) }

          val allWP = (0::m).groupByReduce(i => c(i), i => x(i).Clone, (a: Rep[DenseVector[Double]], b: Rep[DenseVector[Double]]) => a + b)
          val allP = (0::m).groupByReduce(i => c(i), i => 1, (a: Rep[Int], b: Rep[Int]) => a+b)

          (0::k,*) { j =>
            val weightedpoints = fhashmap_get(allWP, j)
            val points = fhashmap_get(allP, j)
            val d = if (points == 0) 1 else points
            weightedpoints / d
          }
        }((x, y) => dist(x, y, SQUARE)) // use SQUARE instead of the default EUC distance

        toc(newMu)
        newMu.pprint

        val mockFunc = (x: Double, y: Int, z: Int, t: Double) => 1
        spark.udf.register("classifier", mockFunc)

        val realFunction = (x: Rep[Double], y: Rep[Int], z: Rep[Int], t: Rep[Double]) => {
          val vec = DenseVector(x, y.toDouble, z.toDouble, t)

          findNearestCluster(vec, newMu)
        }

        udfMap = Map(mockFunc -> InternalUDF(realFunction))

        // val test = data Select { line => new Record {
        //     val cluster = line.cluster
        //     val classification = findNearestCluster(DenseVector(line.murder, line.assault.toDouble, line.pop.toDouble, line.rape), newMu)
        //   }
        // } GroupBy(_.cluster) Select { group => new Record {
        //     val cluster = group._1
        //     val avg1 = group._2.Average(l => if (l.classification == 0) 1.0 else 0.0)
        //     val avg2 = group._2.Average(l => if (l.classification == 1) 1.0 else 0.0)
        //     val avg3 = group._2.Average(l => if (l.classification == 2) 1.0 else 0.0)
        //     val avg4 = group._2.Average(l => if (l.classification == 3) 1.0 else 0.0)
        //   }
        // }

        // Avergae use DecimalType which seems to behave differently...
        val dfResult = spark.sql(
          """
          |select
          |   cluster,
          |   sum(case when classification = 0 then 1 else 0 end) as class1,
          |   sum(case when classification = 1 then 1 else 0 end) as class2,
          |   sum(case when classification = 2 then 1 else 0 end) as class3,
          |   sum(case when classification = 3 then 1 else 0 end) as class4
          |from (
          |   select
          |     cluster,
          |     classifier(murder, assault, population, rape) as classification
          |   from
          |     data
          |  )
          |group by
          |   cluster
          """.stripMargin
        )
        val result = compile(dfResult.queryExecution.optimizedPlan, Map())

        result.printAsTable()

      }
    }
    DeliteRunner.compileAndTest(DeliteQuery)
  }
}
