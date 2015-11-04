// test -- this can be run from the repl

val folder = "/home/greg/Research/delite-playground/"
val file = folder + "lineitem.csv"

import org.apache.spark.sql.types._

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

val res = df.filter("l_quantity > 49").select("l_partkey").agg(sum("l_partkey"))


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
import scala.reflect.{Manifest,SourceContext,ManifestFactory}
import scala.virtualization.lms.common.Record
import playground._


def convertType(e: DataType): Manifest[_] = e match {
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
    ManifestFactory.refinedType[Int](manifest[Record], names.toList, elems.toList)
}

def escapeDelim(c: Char) = if (c == '|') "\\|" else c.toString

def runDelite(d: DataFrame): Any = {

  object DeliteQuery extends OptiQLApplicationCompiler with TPCHQ1Trait with DeliteTestRunner {

    def extractMF[T](x: Rep[Table[T]]): Manifest[T] = {
      x.tp.typeArguments.head.asInstanceOf[Manifest[T]]
    }

    def println(x: Any) = System.out.println(x)

    def compileExpr[T:Manifest](d: Expression)(rec: Rep[Any]): Rep[T] = d match {
      case AttributeReference(name, _, _, _) =>
        field[T](rec, name)
      case Literal(value: T, _) => unit[T](value)
      case GreaterThan(a,b) =>
        val bo = a.dataType match {
          case DoubleType => compileExpr[Double](a)(rec) > compileExpr[Double](b)(rec)
        }
        bo.asInstanceOf[Rep[T]]
      case Alias(child, _) => compileExpr[T](child)(rec)
      case Sum(child) =>
        println("sum")
        Table[Int](rec.asInstanceOf[Rep[Table[Int]]].Sum(l => compileExpr[Int](child)(l)), 1).asInstanceOf[Rep[T]]
      case Cast(child, dataType) =>
        println("cast")
        compileExpr[T](child)(rec)
      case _ =>
        println("TODO: " + getName(d))
        rec.asInstanceOf[Rep[T]]
    }

    def getName(p: Expression): String = p match {
      case AttributeReference(name, _, _, _) => name
      case Alias(child, _) => getName(child)
      case _ => p.getClass().getName()
    }

    def compile(d: LogicalPlan): Rep[Table[_]] = d match {
      case Aggregate(groupingExpr, aggregateExpr, child) =>
        // println(aggregateExpr.map(p => getName(p)))
        val res = compile(child)
        compileExpr[Table[_]](aggregateExpr.head)(res)
      case Project(projectList, child) =>
        println(projectList)
        // println(projectList.map(p => getName(p)))
        val res = compile(child).asInstanceOf[Rep[Table[Any]]]
        implicit val mf = extractMF(res)
        table_select(res, { (rec:Rep[Any]) =>
          record_new(projectList.map { (p:NamedExpression) =>
            val mfp = convertType(p.dataType).asInstanceOf[Manifest[Any]]
            (getName(p), false, (x:Any) => compileExpr[Any](p)(rec)(mfp))
        })}) // (mf, implicitly[SourceContext])})
      case Filter(condition, child) =>
        val res = compile(child).asInstanceOf[Rep[Table[Any]]]
        val mf = extractMF(res)
        table_where(res,{ (rec:Rep[Any]) =>
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
            println("schema:")
            println(relation.schema)
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

            Table.fromFile[TYPE](relation.location, escapeDelim(relation.delimiter))

            //case _ =>
            //println("unknown base relation: " + relation + "/" + relation.getClass)
        }
        //case _ =>
        //println("unknown query operator: " + d.getClass)
    }

    override def main() {
      println("TPC-H ")
      tpchDataPath = unit(folder)
      val res = compile(d.queryExecution.optimizedPlan).asInstanceOf[Rep[Table[Any]]]
      val mf = extractMF(res)
      infix_printAsTable(res)(mf, implicitly[SourceContext])
    }
  }
  DeliteRunner.compileAndTest(DeliteQuery)
}

runDelite(res)
res.show()

// test sql

df.registerTempTable("lineitem")

def deliteSQL(s: String) = runDelite(sqlContext.sql(s))

deliteSQL("select l_quantity from lineitem where l_quantity > 45")

