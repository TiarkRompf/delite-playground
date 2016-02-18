// Nation table
val nation = sqlContext.read.format("com.databricks.spark.csv").option("header", "false").schema(schema_nation).load(file_nation)
val nation_filtered = nation.where($"n_name" === "GERMANY")
val nation_fprojected = nation_filtered.select($"n_nationkey")

// Supplier table
val supplier = sqlContext.read.format("com.databricks.spark.csv").option("header", "false").schema(schema_supplier).load(file_supplier)
val supplier_projected = supplier.select($"s_suppkey", $"s_nationkey")

// Join nation supplier
val nation_supplier = nation_fprojected.join(supplier_projected, $"n_nationkey" === $"s_nationkey")
val nation_supplier_projected = nation_supplier.select($"s_suppkey")

// Partsupp table
val partsupp = sqlContext.read.format("com.databricks.spark.csv").option("header", "false").schema(schema_partsupp).load(file_partsupp)
val partsupp_projeted = partsupp.select($"ps_partkey", $"ps_availqty", $"ps_suppkey", $"ps_supplycost")

// Join nation supplier, partsupp
val nation_supplier_partsupp = partsupp_projeted.join(nation_supplier_projected, $"ps_suppkey" === $"s_suppkey")
val nation_supplier_partsupp_projected = nation_supplier_partsupp.select($"ps_partkey", $"ps_supplycost", $"ps_availqty")
val nation_supplier_partsupp_projected2 = nation_supplier_partsupp.select($"ps_supplycost", $"ps_availqty")

//
val subquery = nation_supplier_partsupp_projected2.select(sum($"ps_supplycost" * $"ps_availqty") * 0.0001 as "V")

val query = nation_supplier_partsupp_projected.groupBy($"ps_partkey").agg(sum($"ps_supplycost" * $"ps_availqty") as "value")



val nex = query.filter($"value" > max(subquery("V")))

