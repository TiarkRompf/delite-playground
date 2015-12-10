// test -- this can be run from the repl

val folder = sys.env("DELITE_PLAY") + "/data/"
// val file = folder + "tpch_2_17_0/dbgen/lineitem.tbl"
val file = folder + "lineitem.csv"

import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

val schema = StructType(Seq(
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

val df = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // Use first line of all files as header
  .option("inferSchema", "false") // Automatically infer data types
  .schema(schema)
  .load(file))

val dffilt = df.filter("l_quantity > 49")
val res = dffilt.agg(sum(dffilt("l_quantity") + dffilt("l_linenumber") - dffilt("l_orderkey")))

import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.execution.datasources.LogicalRelation
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.DataFrame
import com.databricks.spark.csv.CsvRelation
import org.apache.spark.sql.catalyst.expressions._

val lgr = "org.apache.spark.sql.execution.datasources.LogicalRelation"

import optiql.compiler._
import optiql.library._
import optiql.shared._
import scala.reflect.{Manifest,SourceContext,ManifestFactory,RefinedManifest}
import scala.virtualization.lms.common.Record
import playground._
// import org.joda.time.DateTime
import java.util._
import java.text._


def convertType(e: DataType): Manifest[_] = e match {
  case ByteType => manifest[Char]
  case IntegerType => manifest[Int]
  case DoubleType => manifest[Double]
  case DateType => manifest[java.util.Date]
  case StringType => manifest[String]
  case StructType(fields) =>
    val names = fields map {
      case StructField(name,tpe,nullable,metadata) => name
    }
    val elems = fields map {
      case StructField(name,tpe,nullable,metadata) => convertType(tpe)
    }
    ManifestFactory.refinedType[Record](manifest[Record], names.toList, elems.toList)
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

    def compileExpr[T:Manifest](d: Expression)(rec: Rep[_]): Rep[T] = d match {
      case AttributeReference(name, _, _, _) =>
        field[T](rec, name)
      case Literal(value, DateType) =>
        conv_date(value.asInstanceOf[Int]).asInstanceOf[Rep[T]]
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
      case Alias(child, name) =>
        compileExpr[T](child)(rec)
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
      case Cast(child, dataType) =>
        compileExpr[T](child)(rec)
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

      case _ =>
        println("TODO: " + getName(d))
        println("TODO: " + d.dataType)
        rec.asInstanceOf[Rep[T]]
    }

    def getName(p: Expression): String = p match {
      case AttributeReference(name, _, _, _) => name
      case Alias(_, name) => name
      case _ => "TODO " + p.getClass().getName()
    }


    def compile(d: LogicalPlan): Rep[Table[Record]] = d match {
      case Aggregate(groupingExpr, aggregateExpr, child) =>
        val res = compile(child)
        val mfa = extractMF(res)
        val pos = implicitly[SourceContext]
        val mfo = ManifestFactory.refinedType[Record](
                manifest[Record],
                aggregateExpr.map {p => getName(p)}.toList,
                aggregateExpr.map { (p:Expression) =>
                    convertType(p.dataType)}.toList )

        if (groupingExpr.length == 0) {
          table_object_apply(
            Seq(
              record_new[Record](
                aggregateExpr.map { (p:Expression) =>
                  val mfp = convertType(p.dataType).asInstanceOf[Manifest[Any]]
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
                      convertType(p.dataType).asInstanceOf[Manifest[_]]}.toList).asInstanceOf[Manifest[Any]]


          val group = table_groupby(
            res,
            {(rec:Rep[Record]) =>
            record_new(
              groupingExpr.map {
                (p:Expression) =>
                  val mfp = convertType(p.dataType).asInstanceOf[Manifest[Any]]
                  (getName(p), false, {(x:Any) =>
                    compileExpr[Any](p)(rec)(mfp)
                    }
                  )
              }
            )(mfk)
            }
          )(mfa, mfk, pos)

          val mfg = extractMF(group)
          val arr = table_select(
              group,
              { (coup:Rep[Tup2[Any, Table[Record]]]) =>
                val mkt = m_Tup2(mfk,res.tp)
                val key = tup2__1(coup)(mfk, pos)
                val tab = tup2__2(coup)(res.tp.asInstanceOf[Manifest[Table[Record]]],pos)
                record_new[Record](aggregateExpr.map {
                  (p:NamedExpression) =>
                  val mfp = convertType(p.dataType).asInstanceOf[Manifest[Any]]
                  p match {
                    case AttributeReference(_, _, _, _) =>
                      (getName(p), false, {(x:Any) => compileExpr[Any](p)(key)(mfp)})
                    case _ =>
                      (getName(p), false, {(x:Any) => compileExpr[Any](p)(tab)(mfp)})
                  }
                })(mfo)
              }
             )(mfg, mfo, pos)
          arr
        }

      case Project(projectList, child) =>
        val res = compile(child)
        val mfb = extractMF(res)
        val mfa = ManifestFactory.refinedType[Record](
                manifest[Record],
                projectList.map {p => getName(p)}.toList,
                projectList.map { (p:NamedExpression) =>
                    convertType(p.dataType)}.toList )
        table_select(
          res,
          { (rec:Rep[Record]) =>
            record_new[Record](projectList.map {
              (p:NamedExpression) => val mfp = convertType(p.dataType).asInstanceOf[Manifest[Any]]
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
            implicit val mf: Manifest[TYPE] = convertType(relation.schema).asInstanceOf[Manifest[TYPE]]

            Table.fromFile[TYPE](relation.location, escapeDelim(relation.delimiter)).asInstanceOf[Rep[Table[Record]]]

            //case _ =>
            //println("unknown base relation: " + relation + "/" + relation.getClass)
        }
        case _ =>
           println("unknown query operator: " + d.getClass)
           d.asInstanceOf[Rep[Table[Record]]]
    }

    override def main() {
      println("TPC-H ")
      tpchDataPath = unit(folder)
      val res = compile(d.queryExecution.optimizedPlan)
      val mf = extractMF(res)
      infix_printAsTable(res)(mf, implicitly[SourceContext])
    }
  }
  DeliteRunner.compileAndTest(DeliteQuery)
}

//runDelite(res)
// res.show()

// test sql

//df.registerTempTable("lineitem")

def deliteSQL(s: String) = runDelite(sqlContext.sql(s))

// deliteSQL("select l_quantity from lineitem where l_quantity > 45")

//val q = lineItems Where(_.l_shipdate <= Date("1998-12-01")) GroupBy(l => pack(l.l_returnflag,l.l_linestatus)) Select(g => new Record {
//  val returnFlag = g.key._1
//  val lineStatus = g.key._2
//  val sumQty = g.values.Sum(_.l_quantity)
//  val sumBasePrice = g.values.Sum(_.l_extendedprice)
//  val sumDiscountedPrice = g.values.Sum(l => l.l_extendedprice * (1.0 - l.l_discount))
//  val sumCharge = g.values.Sum(l => l.l_extendedprice * (1.0 - l.l_discount) * infix_+(1.0, l.l_tax)) //FIXME: infix_+ fails to resolve automatically
//  val avgQty = g.values.Average(_.l_quantity)
//  val avgPrice = g.values.Average(_.l_extendedprice)
//  val avgDiscount = g.values.Average(_.l_discount)
//  val countOrder = g.values.Count
//}) OrderBy(asc(_.returnFlag), asc(_.lineStatus))

// TPCH - 1
def tpch1() = {
val tpch1df = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema)
  .load(file))

val tpch1res = tpch1df.where(tpch1df("l_shipdate") <= to_date(lit("1998-12-01"))).groupBy("l_returnflag", "l_linestatus").agg(sum("l_quantity") as "l_quantity_sum", sum("l_extendedprice") as "l_extendedprice_sum")

  runDelite(tpch1res)

  val start = System.currentTimeMillis();
  tpch1res.show()
  val stop = System.currentTimeMillis();

  println(">> " + (stop - start))
}
// TPCH - 6
def tpch6() = {
  val tpch6df = (sqlContext.read
    .format("com.databricks.spark.csv")
    .option("delimiter", "|")
    .option("header", "false") // use first line of all files as header
    .option("inferschema", "false") // automatically infer data types
    .schema(schema)
    .load(file))

  val tpch6res = tpch6df.where(tpch6df("l_shipdate") >= to_date(lit("1994-01-01")) && tpch6df("l_shipdate") < to_date(lit("1995-01-01")) && tpch6df("l_discount") >= 0.05 && tpch6df("l_discount") <= 0.07 && tpch6df("l_quantity") < 24).agg(sum(tpch6df("l_extendedprice") * tpch6df("l_discount")) as ("revenue"))

  runDelite(tpch6res)

  val start = System.currentTimeMillis();
  tpch6res.show()
  val stop = System.currentTimeMillis();

  println(">> " + (stop - start))
}

