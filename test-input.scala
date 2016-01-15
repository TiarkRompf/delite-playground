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
val aggexp= "org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression"

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
  case Count(_) => manifest[Int]
  case Alias(Count(_), _) => manifest[Int]
  case _ => convertDataType(e.dataType)
}

def getType(e: Option[Expression]) : Manifest[_] = e match {
  case Some(EqualTo(left, right)) => convertType(left)
  case _ => manifest[Any]
}

def escapeDelim(c: Char) = if (c == '|') "\\|" else c.toString

def runDelite(d: DataFrame): Any = {

  object DeliteQuery extends OptiQLApplicationCompiler with TPCHQ1Trait with DeliteTestRunner {
    def compareFloat(d: SortDirection, x: Rep[Float], y: Rep[Float]) : Rep[Int] = {
      if (x < y)
        return if (d == Ascending) unit(-1) else unit(1)
      if (x > y)
        return if (d == Ascending) unit(1) else unit(-1)

      unit(0)
    }

    def compareDouble(d: SortDirection, x: Rep[Double], y: Rep[Double]) : Rep[Int] = {
      if (x < y)
        return if (d == Ascending) unit(-1) else unit(1)
      if (x > y)
        return if (d == Ascending) unit(1) else unit(-1)

      unit(0)
    }

    def compareInt(d: SortDirection, x: Rep[Int], y: Rep[Int]) : Rep[Int] = {
      if (x < y)
        return if (d == Ascending) unit(-1) else unit(1)
      if (x > y)
        return if (d == Ascending) unit(1) else unit(-1)

      unit(0)
    }

    def compareLong(d: SortDirection, x: Rep[Long], y: Rep[Long]) : Rep[Int] = {
      if (x < y)
        return if (d == Ascending) unit(-1) else unit(1)
      if (x > y)
        return if (d == Ascending) unit(1) else unit(-1)

      unit(0)
    }
    def compareString(d: SortDirection, x: Rep[String], y: Rep[String]) : Rep[Int] = {
      if (x < y)
        return if (d == Ascending) unit(-1) else unit(1)
      if (x > y)
        return if (d == Ascending) unit(1) else unit(-1)

      unit(0)
    }
    def compareDate(d: SortDirection, x: Rep[Date], y: Rep[Date]) : Rep[Int] = {
      if (x < y)
        return if (d == Ascending) unit(-1) else unit(1)
      if (x > y)
        return if (d == Ascending) unit(1) else unit(-1)

      unit(0)
    }

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

    def compileAggExpr[T:Manifest](d: AggregateFunction)(rec: Rep[_]): Rep[T] = d match {
      case Sum(child) =>
        val res = child.dataType match {
          case FloatType  =>
            rec.asInstanceOf[Rep[Table[Record]]].Sum(l => compileExpr[Float](child)(l))
          case DoubleType  =>
            rec.asInstanceOf[Rep[Table[Record]]].Sum(l => compileExpr[Double](child)(l))
          case IntegerType =>
            rec.asInstanceOf[Rep[Table[Record]]].Sum(l => compileExpr[Int](child)(l))
          case LongType =>
            rec.asInstanceOf[Rep[Table[Record]]].Sum(l => compileExpr[Long](child)(l))
        }
        res.asInstanceOf[Rep[T]]
      case Average(child) =>
        val res = child.dataType match {
          case FloatType  =>
            rec.asInstanceOf[Rep[Table[Record]]].Average(l => compileExpr[Float](child)(l))
          case DoubleType  =>
            rec.asInstanceOf[Rep[Table[Record]]].Average(l => compileExpr[Double](child)(l))
          //case IntegerType =>
          //  rec.asInstanceOf[Rep[Table[Record]]].Average(l => compileExpr[Fractional[Int]](child)(l))
          //case LongType =>
          //  rec.asInstanceOf[Rep[Table[Record]]].Average(l => compileExpr[Fractional[Long]](child)(l))
          case _ => throw new RuntimeException("Average, " + child.dataType)
        }
        res.asInstanceOf[Rep[T]]
      case Count(child) =>
        val res = rec.asInstanceOf[Rep[Table[Record]]].Sum(l => unit[Long](1))
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
        compileExpr[T](child)(rec)
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
            compileExpr[Double](left)(rec) / compileExpr[Double](right)(rec)
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
      case Year(exp) =>
        primitive_forge_int_shift_right_unsigned(date_value(compileExpr[Date](exp)(rec)), unit[Int](9)).asInstanceOf[Rep[T]]

      case a : Expression if a.getClass.getName == aggexp =>
        System.out.println("Here")
        // class AggregateExpression is private, so we use reflection
        // to get around access control
        val fld = a.getClass.getDeclaredFields.filter(_.getName == "aggregateFunction").head
        fld.setAccessible(true)
        val children = fld.get(a).asInstanceOf[AggregateFunction]
        compileAggExpr[T](children)(rec)
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
      case None =>
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
                    (x:Rep[Record], y:Rep[Record]) => {
                      compareFloat(order, compileExpr[Float](child)(x), compileExpr[Float](child)(y))
                    }
                  case DoubleType =>
                    (x:Rep[Record], y:Rep[Record]) => {
                      compareDouble(order, compileExpr[Double](child)(x), compileExpr[Double](child)(y))
                    }
                  case IntegerType =>
                    (x:Rep[Record], y:Rep[Record]) => {
                      compareInt(order, compileExpr[Int](child)(x), compileExpr[Int](child)(y))
                    }
                  case LongType =>
                    (x:Rep[Record], y:Rep[Record]) => {
                      compareLong(order, compileExpr[Long](child)(x), compileExpr[Long](child)(y))
                    }
                  case DateType =>
                    (x:Rep[Record], y:Rep[Record]) => {
                      compareDate(order, compileExpr[Date](child)(x), compileExpr[Date](child)(y))
                    }
                  case StringType =>
                    (x:Rep[Record], y:Rep[Record]) => {
                      compareString(order, compileExpr[String](child)(x), compileExpr[String](child)(y))
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
          table_select(
              group,
              { (coup:Rep[Tup2[Any, Table[Record]]]) =>
                System.out.println("A")
                val key = tup2__1(coup)(mfk, pos)
                val tab = tup2__2(coup)(res.tp.asInstanceOf[Manifest[Table[Record]]],pos)
                System.out.println("B")
                System.out.println(extractMF(tab))
                record_new[Record](aggregateExpr.map {
                  (p:NamedExpression) =>
                  System.out.println(p.getClass.getName)
                  val mfp = convertType(p).asInstanceOf[Manifest[Any]]
                  System.out.println(mfp)
                  val tmp = p match {
                    case AttributeReference(_, _, _, _) =>
                      (getName(p), false, {(x:Any) => compileExpr[Any](p)(key)(mfp)})
                    case _ =>
                      (getName(p), false, {(x:Any) => compileExpr[Any](p)(tab)(mfp)})
                  }
                  tmp
                })(mfo)
              }
             )(mfg, mfo, pos)
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
        val mfo = appendMan(mfl.asInstanceOf[RefinedManifest[Record]], mfr.asInstanceOf[RefinedManifest[Record]])

        tpe match {
          case Inner =>
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
          case _ => throw new RuntimeException(tpe.toString + " joins is not supported")
        }
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
    |     and r_name = 'EUROPE'" +
    |   )
    |order by
    | s_acctbal desc,
    | n_name,
    | s_name,
    | p_partkey""".stripMargin

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
      | o_orderdate >= to_date('1993-07-01')
      | and o_orderdate < to_date('1993-10-01')
      | and exists (
      |   select
      |     *
      |   from
      |     lineitem
      |   where
      |     l_orderkey = o_orderkey
      |     and l_commitdate < l_receiptdate
      |   )
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
    | and l_suppkey = s_suppkey
    | and c_nationkey = s_nationkey
    | and s_nationkey = n_nationkey
    | and n_regionkey = r_regionkey
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
    | l_year, sum(volume) as revenue
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
    |   when nation = 'BRAZIL'
    |   then volume
    | else 0
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



def testSQL(s: String) = {
  val res = sqlContext.sql(s)

  System.out.println(res.queryExecution.optimizedPlan)

  runDelite(res)

  res.show()
}
