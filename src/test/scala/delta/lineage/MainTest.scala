package delta.lineage

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.delta.storage.LocalLogStore

object MainTest {

    def main(args: Array[String]): Unit = {
         val spark = SparkSession.builder()
             .master("local[*]")
             .config("spark.sql.extensions", "io.delta.sql.DeltaSparkSessionExtension")
             .config("spark.sql.catalog.spark_catalog", "org.apache.spark.sql.delta.catalog.DeltaCatalog").getOrCreate()
        Lineage.init(spark)
        spark.read.format("csv").option("inferSchema", "true").option("header", "true").option("sep", ",").load("./src/test/resources/test.csv")
             .write.format("delta").mode("overwrite").save("./src/test/resources/result/test.delta")
        //spark.read.format("delta").load("./src/test/resources/result/test.delta").createOrReplaceTempView("tmp_view")
        //spark.sql("drop table if exists test")
        //spark.sql("create table test ( as select * from tmp_view)")
        spark.sql("DESCRIBE HISTORY delta.`/Users/quentin/project/delta-lineage/src/test/resources/result/test.delta`").show()

    }

}