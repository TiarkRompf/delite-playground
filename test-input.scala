// test -- this can be run from the repl

val folder = sys.env("DELITE_PLAY") + "/data/"
// val file = folder + "tpch_2_17_0/dbgen/lineitem.tbl"
val file_part = folder + "part.tbl"
val file_supplier = folder + "supplier.tbl"
val file_partsupp = folder + "partsupp.tbl"
val file_customer = folder + "customer.tbl"
val file_orders = folder + "orders.tbl"
val file_lineitem = folder + "lineitem.tbl"
val file_nation = folder + "nation.tbl"
val file_region = folder + "region.tbl"

import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

val schema_part = StructType(Seq(
  StructField("p_partkey", IntegerType, true),
  StructField("p_name", StringType, true),
  StructField("p_mfgr", StringType, true),
  StructField("p_brand", StringType, true),
  StructField("p_type", StringType, true),
  StructField("p_size", IntegerType, true),
  StructField("p_container", StringType, true),
  StructField("p_retailprice", DoubleType, true),
  StructField("p_comment", StringType, true)))

val schema_supplier = StructType(Seq(
  StructField("s_suppkey", IntegerType, true),
  StructField("s_name", StringType, true),
  StructField("s_address", StringType, true),
  StructField("s_nationkey", IntegerType, true),
  StructField("s_phone", StringType, true),
  StructField("s_acctbal", DoubleType, true),
  StructField("s_comment", StringType, true)))

val schema_partsupp = StructType(Seq(
  StructField("ps_partkey", IntegerType, true),
  StructField("ps_suppkey", IntegerType, true),
  StructField("ps_availqty", IntegerType, true),
  StructField("ps_supplycost", DoubleType, true),
  StructField("ps_comment", StringType, true)))

val schema_customer = StructType(Seq(
  StructField("c_custkey", IntegerType, true),
  StructField("c_name", StringType, true),
  StructField("c_address", StringType, true),
  StructField("c_nationkey", IntegerType, true),
  StructField("c_phone", StringType, true),
  StructField("c_acctbal", DoubleType, true),
  StructField("c_mktsegment", StringType, true),
  StructField("c_comment", StringType, true)))

val schema_orders = StructType(Seq(
  StructField("o_orderkey", IntegerType, true),
  StructField("o_custkey", IntegerType, true),
  StructField("o_orderstatus", StringType, true),
  StructField("o_totalprice", DoubleType, true),
  StructField("o_orderdate", DateType, true),
  StructField("o_orderpriority", StringType, true),
  StructField("o_clerk", StringType, true),
  StructField("o_shippriority", IntegerType, true),
  StructField("o_comment", StringType, true)))

val schema_lineitem = StructType(Seq(
  StructField("l_orderkey", IntegerType, true),
  StructField("l_partkey", IntegerType, true),
  StructField("l_suppkey", IntegerType, true),
  StructField("l_linenumber", IntegerType, true),
  StructField("l_quantity", DoubleType, true),
  StructField("l_extendedprice", DoubleType, true),
  StructField("l_discount", DoubleType, true),
  StructField("l_tax", DoubleType, true),
  StructField("l_returnflag", StringType, true), // Char
  StructField("l_linestatus", StringType, true),
  StructField("l_shipdate", DateType, true),
  StructField("l_commitdate", DateType, true),
  StructField("l_receiptdate", DateType, true),
  StructField("l_shipinstruct", StringType, true),
  StructField("l_shipmode", StringType, true),
  StructField("l_comment", StringType, true)))

val schema_nation = StructType(Seq(
  StructField("n_nationkey", IntegerType, true),
  StructField("n_name", StringType, true),
  StructField("n_regionkey", IntegerType, true),
  StructField("n_comment", StringType, true)))

val schema_region = StructType(Seq(
  StructField("r_regionkey", IntegerType, true),
  StructField("r_name", StringType, true),
  StructField("r_comment", StringType, true)))

import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.catalyst.plans._
import org.apache.spark.sql.execution.datasources.LogicalRelation
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.DataFrame
import com.databricks.spark.csv.CsvRelation
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.expressions.aggregate._

val lgr = "org.apache.spark.sql.execution.datasources.LogicalRelation"
val aggexp = "org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression"
val expcl = "org.apache.spark.sql.catalyst.plans.logical.Expand"

import optiql.compiler._
import optiql.library._
import optiql.shared._
import scala.reflect.{Manifest,SourceContext,ManifestFactory,RefinedManifest}
import scala.virtualization.lms.common.{Record, TupleOps}
import scala.math.Ordering
import playground._
import java.util.{Date, Calendar}
import java.text._

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

def runDelite(d: DataFrame): Any = {

  object DeliteQuery extends OptiQLApplicationCompiler with TPCHQ1Trait with DeliteTestRunner {

    def extractMF[T](x: Rep[Table[T]]): Manifest[T] = {
     //  println(x.tp.typeArguments)
      x.tp.typeArguments.head.asInstanceOf[Manifest[T]]
    }

    def println(x: Any) = System.out.println(x)

    def conv_date(days: Int): Rep[Date] = {
      val c = Calendar.getInstance();
      c.setTime(new java.util.Date(0)); // set origin 1970-01-01.
      c.add(Calendar.DAY_OF_YEAR, days + 1); // Adding the number of days
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
        System.out.println("Alias " + name)
        val res = compileExpr[T](child)(rec)
        System.out.println(res)
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
        System.out.println(left.dataType + " : " + right.dataType)
        val res = left.dataType match {
          case FloatType  =>
            compileExpr[Float](left)(rec) / compileExpr[Float](right)(rec)
          case DoubleType  =>
            System.out.println(">>> AAA")
            val ll = compileExpr[Double](left)(rec)
            System.out.println(">>> BBB")
            val rr = compileExpr[Double](right)(rec)
            ll / rr
          case IntegerType =>
            compileExpr[Int](left)(rec) / compileExpr[Int](right)(rec)
          case LongType =>
            compileExpr[Long](left)(rec) / compileExpr[Long](right)(rec)
        }
        System.out.println(">>> CCC " + res.toString)
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
        System.out.println("left " + left.toString)
        System.out.println("left " + left.getClass.getName)
        System.out.println("right " + right.toString)
        System.out.println("right " + right.getClass.getName)

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
        System.out.println("AggregateFunction: " + children.getClass.getName)
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
        System.out.println("Sort")
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
        System.out.println("Aggregate")
        System.out.println(groupingExpr)
        System.out.println(aggregateExpr)

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

          System.out.println("A")
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

          System.out.println("B")

          val mfg = extractMF(group)
          val tmp = table_select(
              group,
              { (coup:Rep[Tup2[Any, Table[Record]]]) =>
                val key = tup2__1(coup)(mfk, pos)
                val tab = tup2__2(coup)(res.tp.asInstanceOf[Manifest[Table[Record]]],pos)
                val tmp = record_new[Record](aggregateExpr.map {
                  (p:NamedExpression) =>
                    val mfp = convertType(p).asInstanceOf[Manifest[Any]]
                    System.out.println("<<< " + p.getClass.getName)
                    p match {
                      case AttributeReference(_, _, _, _) =>
                        (getName(p), false, {(x:Any) => compileExpr[Any](p)(key)(mfp)})
                      case _ =>
                        (getName(p), false, {(x:Any) => compileExpr[Any](p)(tab)(mfp)})
                    }
                })(mfo)
                System.out.println("C " + tmp.toString)
                tmp
              }
             )(mfg, mfo, pos)
          System.out.println("D")
          tmp
        }

      case Project(projectList, child) =>
        val res = compile(child)
        System.out.println("Project")
        System.out.println(projectList)

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
        System.out.println("Filter")
        val mf = extractMF(res)
        table_where(res, { (rec:Rep[Record]) =>
          compileExpr[Boolean](condition)(rec)
        })(mf, implicitly[SourceContext])
      case Limit(value, child) =>
        val res = compile(child)
        System.out.println("Value: " + value)
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
        System.out.println("Join")

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
        System.out.println("Expand")
        System.out.println(projections)
        System.out.println(output)
        System.out.println(child)
        compile(child)
      case _ => throw new RuntimeException("unknown query operator: " + d.getClass)
    }

    override def main() {
      println("TPC-H ")
      tpchDataPath = unit(folder)
      val res = compile(d.queryExecution.optimizedPlan)
      val mf = extractMF(res)
      System.out.println("OK")
      infix_printAsTable(res)(mf, implicitly[SourceContext])
    }
  }
  DeliteRunner.compileAndTest(DeliteQuery)
}

def deliteSQL(s: String) = runDelite(sqlContext.sql(s))

// Tables
val customer = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_customer)
  .load(file_customer))

val orders = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_orders)
  .load(file_orders))

val lineitem = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_lineitem)
  .load(file_lineitem))

val part = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_part)
  .load(file_part))

val supplier = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_supplier)
  .load(file_supplier))

val partsupp = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_partsupp)
  .load(file_partsupp))

val nation = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_nation)
  .load(file_nation))

val region = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_region)
  .load(file_region))

customer.registerTempTable("customer")
orders.registerTempTable("orders")
lineitem.registerTempTable("lineitem")
part.registerTempTable("part")
supplier.registerTempTable("supplier")
partsupp.registerTempTable("partsupp")
nation.registerTempTable("nation")
region.registerTempTable("region")


// TPCH - 1
val tpch1 =
  """select
    | l_returnflag,
    | l_linestatus,
    | sum(l_quantity) as sum_qty,
    | sum(l_extendedprice) as sum_base_price,
    | sum(l_extendedprice * (1 - l_discount)) as sum_disc_price,
    | sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge,
    | avg(l_quantity) as avg_qty,
    | avg(l_extendedprice) as avg_price,
    | avg(l_discount) as avg_disc,
    | count(*) as count_order
    |from
    | lineitem
    |where
    | l_shipdate <= to_date('1998-09-02')
    |group by
    | l_returnflag,
    | l_linestatus
    |order by
    | l_returnflag,
    | l_linestatus""".stripMargin

// TPCH - 2
val tpch2 =
  """select
    | s_acctbal,
    | s_name,
    | n_name,
    | p_partkey,
    | p_mfgr,
    | s_address,
    | s_phone,
    | s_comment
    |from
    | part,
    | supplier,
    | partsupp,
    | nation,
    | region
    |where
    | p_partkey = ps_partkey
    | and s_suppkey = ps_suppkey
    | and p_size = 15
    | and p_type like '%BRASS'
    | and s_nationkey = n_nationkey
    | and n_regionkey = r_regionkey
    | and r_name = 'EUROPE'
    | and ps_supplycost = (
    |   select
    |     min(ps_supplycost)
    |   from
    |     partsupp, supplier,
    |     nation, region
    |   where
    |     p_partkey = ps_partkey
    |     and s_suppkey = ps_suppkey
    |     and s_nationkey = n_nationkey
    |     and n_regionkey = r_regionkey
    |     and r_name = 'EUROPE'
    |   )
    |order by
    | s_acctbal desc,
    | n_name,
    | s_name,
    | p_partkey""".stripMargin

val tpch2nosub =
  """select
    |        s_acctbal,
    |        s_name,
    |        n_name,
    |        p_partkey,
    |        p_mfgr,
    |        s_address,
    |        s_phone,
    |        s_comment
    |from
    |        part,
    |        supplier,
    |        partsupp,
    |        nation,
    |        region,
    |        (select ps_partkey as t_ps_partkey, min(ps_supplycost) as t_min_ps_supplycost
    |        from part, partsupp, supplier, nation, region
    |        where p_partkey = ps_partkey
    |              and s_suppkey = ps_suppkey
    |              and s_nationkey = n_nationkey
    |              and n_regionkey = r_regionkey
    |              and r_name = 'EUROPE'
    |              and p_size = 15
    |              and p_type like '%BRASS'
    |        group by ps_partkey
    |        ) as T
    |where
    |        p_partkey = ps_partkey
    |        and s_suppkey = ps_suppkey
    |        and p_size = 15
    |        and p_type like '%BRASS'
    |        and s_nationkey = n_nationkey
    |        and n_regionkey = r_regionkey
    |        and r_name = 'EUROPE'
    |        and p_partkey = t_ps_partkey
    |        and ps_supplycost = t_min_ps_supplycost
    |order by
    |        s_acctbal desc,
    |        n_name,
    |        s_name,
    |        p_partkey
    |limit 100""".stripMargin

// TPCH - 3
val tpch3 =
  """select
    | l_orderkey,
    | sum(l_extendedprice*(1-l_discount)) as revenue,
    | o_orderdate,
    | o_shippriority
    |from
    | customer,
    | orders,
    | lineitem
    |where
    | c_mktsegment = 'BUILDING'
    | and c_custkey = o_custkey
    | and l_orderkey = o_orderkey
    | and o_orderdate < to_date('1995-03-15')
    | and l_shipdate > to_date('1995-03-15')
    |group by
    | l_orderkey,
    | o_orderdate,
    | o_shippriority
    |order by
    | revenue desc,
    | o_orderdate""".stripMargin

// TPCH - 4
val tpch4 =
    """select
      | o_orderpriority,
      | count(*) as order_count
      |from
      | orders
      |where
      | exists (
      |   select
      |     *
      |   from
      |     lineitem
      |   where
      |     lineitem.l_orderkey = orders.o_orderkey
      |     and lineitem.l_commitdate < lineitem.l_receiptdate
      | )
      |group by
      | o_orderpriority
      |order by
      | o_orderpriority""".stripMargin

val tpch4nosub =
    """select
      | o_orderpriority,
      | count(*) as order_count
      |from
      | orders join (
      |   select
      |     distinct l_orderkey
      |   from
      |     lineitem
      |   where
      |     lineitem.l_commitdate < lineitem.l_receiptdate
      | ) as L
      |on
      | L.l_orderkey = o_orderkey
      |where
      | o_orderdate >= to_date('1993-07-01')
      | and o_orderdate < to_date('1993-10-01')
      |group by
      | o_orderpriority
      |order by
      | o_orderpriority""".stripMargin

// TPCH - 5
val tpch5 =
  """select
    | n_name,
    | sum(l_extendedprice * (1 - l_discount)) as revenue
    |from
    | customer,
    | orders,
    | lineitem,
    | supplier,
    | nation,
    | region
    |where
    | c_custkey = o_custkey
    | and l_orderkey = o_orderkey
    | and c_nationkey = s_nationkey
    | and s_nationkey = n_nationkey
    | and n_regionkey = r_regionkey
    | and l_suppkey = s_suppkey
    | and r_name = 'ASIA'
    | and o_orderdate >= to_date('1994-01-01')
    | and o_orderdate < to_date('1995-01-01')
    |group by
    | n_name
    |order by
    | revenue desc""".stripMargin

// TPCH - 6
// val tpch6res = lineitem.where(lineitem("l_shipdate") >= to_date(lit("1994-01-01")) && lineitem("l_shipdate") < to_date(lit("1995-01-01")) && lineitem("l_discount") >= 0.05 && lineitem("l_discount") <= 0.07 && lineitem("l_quantity") < 24).agg(sum(lineitem("l_extendedprice") * lineitem("l_discount")) as ("revenue"))
val tpch6 =
  """select
    | sum(l_extendedprice*l_discount) as revenue
    |from
    | lineitem
    |where
    | l_shipdate >= to_date('1994-01-01')
    | and l_shipdate < to_date('1995-01-01')
    | and l_discount between 0.05 and 0.07
    | and l_quantity < 24""".stripMargin

// TPCH - 7
val tpch7 =
  """select
    | supp_nation,
    | cust_nation,
    | l_year,
    | sum(volume) as revenue
    |from (
    | select
    |   n1.n_name as supp_nation,
    |   n2.n_name as cust_nation,
    |   year(l_shipdate) as l_year,
    |   l_extendedprice * (1 - l_discount) as volume
    | from
    |   supplier,
    |   lineitem,
    |   orders,
    |   customer,
    |   nation n1,
    |   nation n2
    | where
    |   s_suppkey = l_suppkey
    |   and o_orderkey = l_orderkey
    |   and c_custkey = o_custkey
    |   and s_nationkey = n1.n_nationkey
    |   and c_nationkey = n2.n_nationkey
    |   and (
    |     (n1.n_name = 'FRANCE' and n2.n_name = 'GERMANY')
    |     or (n1.n_name = 'GERMANY' and n2.n_name = 'FRANCE')
    |   )
    |   and l_shipdate between to_date('1995-01-01') and to_date('1996-12-31')
    | ) as shipping
    |group by
    | supp_nation,
    | cust_nation,
    | l_year
    |order by
    | supp_nation,
    | cust_nation,
    | l_year""".stripMargin

// TPCH - 8
val tpch8 =
  """select
    | o_year,
    | sum(case
    |   when all_nations.nation = 'BRAZIL'
    |   then volume
    |   else 0
    | end) / sum(volume) as mkt_share
    |from (
    | select
    |   year(o_orderdate) as o_year,
    |   l_extendedprice * (1-l_discount) as volume,
    |   n2.n_name as nation
    | from
    |   part,
    |   supplier,
    |   lineitem,
    |   orders,
    |   customer,
    |   nation n1,
    |   nation n2,
    |   region
    | where
    |   p_partkey = l_partkey
    |   and s_suppkey = l_suppkey
    |   and l_orderkey = o_orderkey
    |   and o_custkey = c_custkey
    |   and c_nationkey = n1.n_nationkey
    |   and n1.n_regionkey = r_regionkey
    |   and r_name = 'AMERICA'
    |   and s_nationkey = n2.n_nationkey
    |   and o_orderdate between to_date('1995-01-01') and to_date('1996-12-31')
    |   and p_type = 'ECONOMY ANODIZED STEEL'
    | ) as all_nations
    |group by
    | o_year
    |order by
    | o_year""".stripMargin

// TPCH - 9
val tpch9 =
  """select
    | nation,
    | o_year,
    | sum(amount) as sum_profit
    |from (
    | select
    |   n_name as nation,
    |   year(o_orderdate) as o_year,
    |   l_extendedprice * (1 - l_discount) - ps_supplycost * l_quantity as amount
    | from
    |   part,
    |   supplier,
    |   lineitem,
    |   partsupp,
    |   orders,
    |   nation
    | where
    |   s_suppkey = l_suppkey
    |   and ps_suppkey = l_suppkey
    |   and ps_partkey = l_partkey
    |   and p_partkey = l_partkey
    |   and o_orderkey = l_orderkey
    |   and s_nationkey = n_nationkey
    |   and p_name like '%green%'
    | ) as profit
    |group by
    | nation,
    | o_year
    |order by
    | nation,
    | o_year desc""".stripMargin

// TPCH - 10
val tpch10 =
  """select
    | c_custkey,
    | c_name,
    | sum(l_extendedprice * (1 - l_discount)) as revenue,
    | c_acctbal,
    | n_name,
    | c_address,
    | c_phone,
    | c_comment
    |from
    | customer,
    | orders,
    | lineitem,
    | nation
    |where
    | c_custkey = o_custkey
    | and l_orderkey = o_orderkey
    | and o_orderdate >= to_date('1993-10-01')
    | and o_orderdate < to_date('1994-01-01')
    | and l_returnflag = 'R'
    | and c_nationkey = n_nationkey
    |group by
    | c_custkey,
    | c_name,
    | c_acctbal,
    | c_phone,
    | n_name,
    | c_address,
    | c_comment
    |order by
    | revenue desc""".stripMargin

val tpch11 =
  """select
    | ps_partkey,
    | sum(ps_supplycost * ps_availqty) as value
    | from
    | partsupp,
    | supplier,
    | nation
    |where
    | ps_suppkey = s_suppkey
    | and s_nationkey = n_nationkey
    | and n_name = 'GERMANY'
    |group by
    | ps_partkey having
    | sum(ps_supplycost * ps_availqty) > (
    |   select
    |     sum(ps_supplycost * ps_availqty) * 0.0001
    |   from
    |     partsupp,
    |     supplier,
    |     nation
    |   where
    |     ps_suppkey = s_suppkey
    |     and s_nationkey = n_nationkey
    |     and n_name = 'GERMANY'
    |   )
    |order by
    | value desc""".stripMargin

val tpch11nosub =
  """with c as (
    |   select
    |     sum(ps_supplycost * ps_availqty) * 0.0001 as cost
    |   from
    |     partsupp,
    |     supplier,
    |     nation
    |   where
    |     ps_suppkey = s_suppkey
    |     and s_nationkey = n_nationkey
    |     and n_name = 'GERMANY'
    |)
    |select
    | ps_partkey,
    | sum(ps_supplycost * ps_availqty) as value
    | from
    | partsupp,
    | supplier,
    | nation,
    | c
    |where
    | ps_suppkey = s_suppkey
    | and s_nationkey = n_nationkey
    | and n_name = 'GERMANY'
    |group by
    | ps_partkey having value > cost
    |order by
    | value desc""".stripMargin

val tpch12 =
  """select
    | l_shipmode,
    | sum(case
    |   when o_orderpriority ='1-URGENT'
    |   or o_orderpriority ='2-HIGH'
    |   then 1
    | else 0
    | end) as high_line_count,
    | sum(case
    |   when o_orderpriority <> '1-URGENT'
    |   and o_orderpriority <> '2-HIGH'
    |   then 1
    | else 0
    | end) as low_line_count
    |from
    | orders,
    | lineitem
    |where
    | o_orderkey = l_orderkey
    | and l_shipmode in ('MAIL', 'SHIP')
    | and l_commitdate < l_receiptdate
    | and l_shipdate < l_commitdate
    | and l_receiptdate >= to_date('1994-01-01')
    | and l_receiptdate < to_date('1995-01-01')
    |group by
    | l_shipmode
    |order by
    | l_shipmode""".stripMargin

val tpch13 =
  """select
    | c_count, count(*) as custdist
    |from (
    |   select
    |     c_custkey,
    |     count(o_orderkey)
    |   from
    |     customer left outer join orders on
    |     c_custkey = o_custkey
    |     and o_comment not like '%special%requests%'
    |   group by
    |     c_custkey
    |   ) as c_orders (c_custkey, c_count)
    |group by
    | c_count
    |order by
    | custdist desc,
    | c_count desc""".stripMargin

val tpch14 =
  """select
    | 100.00 * sum(case
    |   when p_type like 'PROMO%'
    |   then l_extendedprice * (1 - l_discount)
    |   else 0
    | end) / sum(l_extendedprice * (1 - l_discount)) as promo_revenue
    |from
    | lineitem,
    | part
    |where
    | l_partkey = p_partkey
    | and l_shipdate >= to_date('1995-09-01')
    | and l_shipdate < to_date('1995-10-02')""".stripMargin

val tpch15 =
  """with revenue as (
    | select
    |   l_suppkey as supplier_no,
    |   sum(l_extendedprice * (1 - l_discount)) as total_revenue
    | from
    |   lineitem
    | where
    |   l_shipdate >= to_date('1996-01-01')
    |   and l_shipdate < to_date('1996-04-01')
    | group by
    |   l_suppkey
    |)
    |select
    | s_suppkey,
    | s_name,
    | s_address,
    | s_phone,
    | total_revenue
    |from
    | supplier,
    | revenue
    |where
    | s_suppkey = supplier_no
    | and total_revenue = (
    |  select
    |   max(total_revenue)
    |  from
    |   revenue
    | )
    |order by
    | s_suppkey""".stripMargin

val tpch15nosub =
  """with revenue as (
    |    select
    |        l_suppkey as supplier_no,
    |        sum(l_extendedprice * (1 - l_discount)) as total_revenue
    |    from
    |        lineitem
    |    where
    |        l_shipdate >= to_date('1996-01-01')
    |        and l_shipdate < to_date('1996-04-01')
    |    group by
    |        l_suppkey)
    |select
    |    s_suppkey,
    |    s_name,
    |    s_address,
    |    s_phone,
    |    total_revenue
    |from
    |    supplier,
    |    revenue,
    |     (
    |        select
    |            max(total_revenue) as total_rev
    |        from
    |            revenue
    |    )as T
    |where
    |    s_suppkey = supplier_no
    |    and total_revenue = T.total_rev
    |order by
    |    s_suppkey""".stripMargin

val tpch16 =
  """select
    | p_brand,
    | p_type,
    | p_size,
    | count(distinct ps_suppkey) as supplier_cnt
    |from
    | partsupp,
    | part
    |where
    | p_partkey = ps_partkey
    | and p_brand <> 'Brand#45'
    | and p_type not like 'MEDIUM POLISHED%'
    | and p_size in (42, 14, 23, 45, 19, 3, 36, 9)
    | and ps_suppkey not in (
    |   select
    |   s_suppkey
    |   from
    |   supplier
    |   where
    |   s_comment like '%Customer%Complaints%'
    | )
    |group by
    | p_brand,
    | p_type,
    | p_size
    |order by
    | supplier_cnt desc,
    | p_brand,
    | p_type,
    | p_size""".stripMargin

val tpch16nosub =
  """select
    | p_brand,
    | p_type,
    | p_size,
    | count(distinct ps_suppkey) as supplier_cnt
    |from
    | partsupp,
    | part,
    | supplier
    |where
    | p_partkey = ps_partkey
    | and p_brand <> 'Brand#45'
    | and p_type not like 'MEDIUM POLISHED%'
    | and p_size in (49, 14, 23, 45, 19, 3, 36, 9)
    | and ps_suppkey = s_suppkey
    | and s_comment not like '%Customer%Complaints%'
    |group by
    | p_brand,
    | p_type,
    | p_size
    |order by
    | supplier_cnt desc,
    | p_brand,
    | p_type,
    | p_size""".stripMargin

val tpch17 =
  """select
    | sum(l_extendedprice) / 7.0 as avg_yearly
    |from
    | lineitem,
    | part
    |where
    | p_partkey = l_partkey
    | and p_brand = 'Brand#23'
    | and p_container = 'MED BOX'
    | and l_quantity < (
    |   select
    |     avg(0.2 * l_quantity)
    |   from
    |     lineitem
    |   where
    |     l_partkey = p_partkey
    | )""".stripMargin

val tpch17nosub =
  """select
    |        sum(l_extendedprice) / 7.0 as avg_yearly
    |from
    |        lineitem,
    |        part,
    |        (select l_partkey as t_l_partkey, 0.2 * avg(l_quantity) as avg_l_quantity
    |         from lineitem
    |         where l_partkey = p_partkey
    |         group by l_partkey
    |        ) as T
    |where
    |        p_partkey = l_partkey
    |        and p_partkey = T.t_l_partkey
    |        and p_brand = 'Brand#23'
    |        and p_container = 'MED BOX'
    |        and l_quantity < T.avg_l_quantity""".stripMargin


val tpch18 =
  """select
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice,
    | sum(l_quantity)
    |from
    | customer,
    | orders,
    | lineitem
    |where
    | o_orderkey in (
    |   select
    |     l_orderkey
    |   from
    |     lineitem
    |   group by
    |     l_orderkey having
    |     sum(l_quantity) > 300
    | )
    | and c_custkey = o_custkey
    | and o_orderkey = l_orderkey
    |group by
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice
    |order by
    | o_totalprice desc,
    | o_orderdate""".stripMargin

val tpch18nosub =
  """select
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice,
    | sum(l_quantity)
    |from
    | customer,
    | orders,
    | lineitem
    |where
    | c_custkey = o_custkey
    | and o_orderkey = l_orderkey
    |group by
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice
    |having
    | sum(l_quantity) > 300
    |order by
    | o_totalprice desc,
    | o_orderdate
    |limit 100""".stripMargin

val tpch19 =
  """select
    | sum(l_extendedprice * (1 - l_discount) ) as revenue
    |from
    | lineitem,
    |part
    | where
    | (
    |   p_partkey = l_partkey
    |   and p_brand = 'Brand#12'
    |   and p_container in ( 'SM CASE', 'SM BOX', 'SM PACK', 'SM PKG')
    |   and l_quantity >= 1 and l_quantity <= 11
    |   and p_size between 1 and 5
    |   and l_shipmode in ('AIR', 'AIR REG')
    |   and l_shipinstruct = 'DELIVER IN PERSON'
    | )
    | or
    | (
    |   p_partkey = l_partkey
    |   and p_brand = 'Brand#23'
    |   and p_container in ('MED BAG', 'MED BOX', 'MED PKG', 'MED PACK')
    |   and l_quantity >= 10 and l_quantity <= 20
    |   and p_size between 1 and 10
    |   and l_shipmode in ('AIR', 'AIR REG')
    |   and l_shipinstruct = 'DELIVER IN PERSON'
    | )
    | or
    | (
    |   p_partkey = l_partkey
    |   and p_brand = 'Brand#34'
    |   and p_container in ( 'LG CASE', 'LG BOX', 'LG PACK', 'LG PKG')
    |   and l_quantity >= 20 and l_quantity <= 30
    |   and p_size between 1 and 15
    |   and l_shipmode in ('AIR', 'AIR REG')
    |   and l_shipinstruct = 'DELIVER IN PERSON'
    | )""".stripMargin

val tpch20 =
  """select
    | s_name,
    | s_address
    |from
    | supplier, nation
    |where
    | s_suppkey in (
    |   select
    |     ps_suppkey
    |   from
    |     partsupp
    |   where
    |     ps_partkey in (
    |       select
    |         p_partkey
    |       from
    |         part
    |       where
    |       p_name like 'forest%'
    |     )
    |     and ps_availqty > (
    |       select
    |         0.5 * sum(l_quantity)
    |       from
    |         lineitem
    |       where
    |         l_partkey = ps_partkey
    |         and l_suppkey = ps_suppkey
    |         and l_shipdate >= to_date('1994-01-01')
    |         and l_shipdate < to_date('1995-01-01')
    |     )
    | )
    | and s_nationkey = n_nationkey
    | and n_name = 'CANADA'
    |order by
    | s_name""".stripMargin

val tpch20nosub =
  """select
    |        distinct s_name,
    |        s_address
    |from
    |        supplier,
    |        nation,
    |        (select
    |               distinct ps_suppkey
    |         from
    |               partsupp,
    |               (select
    |                   0.5 * sum(l_quantity) as sum_l_quantity
    |               from
    |                 lineitem
    |               where l_partkey = ps_partkey
    |                 and l_suppkey = ps_suppkey
    |                 and l_shipdate >= to_date('1994-01-01')
    |                 and l_shipdate < to_date('1995-01-01')
    |               ) as T1,
    |               (select
    |                 p_partkey
    |               from
    |                 part
    |               where
    |                 p_name like 'forest%'
    |               ) as T2
    |        where
    |                ps_partkey = T2.p_partkey
    |                and ps_availqty > T1.sum_l_quantity
    |        ) as T3
    |where
    |        s_suppkey = T3.ps_suppkey
    |        and s_nationkey = n_nationkey
    |        and n_name = 'CANADA'
    |order by
    |        s_name""".stripMargin


val tpch21 =
  """select
    | s_name,
    | count(*) as numwait
    |from
    | supplier,
    | lineitem l1,
    | orders,
    | nation
    |where
    | s_suppkey = l1.l_suppkey
    | and o_orderkey = l1.l_orderkey
    | and o_orderstatus = 'F'
    | and l1.l_receiptdate > l1.l_commitdate
    | and exists (
    |   select
    |     *
    |   from
    |     lineitem l2
    |   where
    |     l2.l_orderkey = l1.l_orderkey
    |     and l2.l_suppkey <> l1.l_suppkey
    | )
    | and not exists (
    |   select
    |     *
    |   from
    |     lineitem l3
    |   where
    |     l3.l_orderkey = l1.l_orderkey
    |     and l3.l_suppkey <> l1.l_suppkey
    |     and l3.l_receiptdate > l3.l_commitdate
    | )
    | and s_nationkey = n_nationkey
    | and n_name = 'SAUDI ARABIA'
    |group by
    | s_name
    |order by
    | numwait desc,
    | s_name""".stripMargin

val tpch22 =
  """select
    | cntrycode,
    | count(*) as numcust,
    | sum(c_acctbal) as totacctbal
    |from (
    | select
    |   substring(c_phone from 1 for 2) as cntrycode,
    |   c_acctbal
    | from
    |   customer
    | where
    |   substring(c_phone from 1 for 2) in
    |     ('13','31','23','29','30','18','17')
    |   and c_acctbal > (
    |     select
    |       avg(c_acctbal)
    |     from
    |       customer
    |     where
    |       c_acctbal > 0.00
    |     and substring (c_phone from 1 for 2) in
    |       ('13','31','23','29','30','18','17')
    |   )
    |   and not exists (
    |     select
    |       *
    |     from
    |       orders
    |     where
    |     o_custkey = c_custkey
    |   )
    | ) as custsale
    |group by
    | cntrycode
    |order by
    | cntrycode""".stripMargin

val tpch22nosub =
  """select
    |        cntrycode,
    |        count(*) as numcust,
    |        sum(c_acctbal) as totacctbal
    |from
    |     (
    |          select
    |              substring(c_phone, 1, 2) as cntrycode,
    |            c_acctbal
    |          from
    |              customer left outer join orders on o_custkey = c_custkey ,
    |              (
    |              select avg(c_acctbal) as avg_c_acctbal
    |              from customer
    |              where
    |                   c_acctbal > 0.00
    |                    and substring(c_phone, 1, 2) in ('13', '31', '23', '29', '30', '18', '17')) as T
    |          where
    |                substring(c_phone, 1, 2) in ('13', '31', '23', '29', '30', '18', '17')
    |          and o_custkey is NULL
    |          and c_acctbal > T.avg_c_acctbal
    |        ) as custsale
    |group by
    |        cntrycode
    |order by
    |        cntrycode""".stripMargin

def testSpark(s: String) = {
  val res = sqlContext.sql(s)

  System.out.println(res.queryExecution.optimizedPlan)

  res.show()
}

def testDelite(s: String) = {
  val res = sqlContext.sql(s)

  System.out.println(res.queryExecution.optimizedPlan)

  runDelite(res)
}
