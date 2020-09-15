package delta.lineage

import java.sql.Timestamp

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.apache.spark.scheduler.{SparkListener, SparkListenerApplicationEnd, SparkListenerApplicationStart, SparkListenerEvent, SparkListenerJobEnd}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.SparkPlanInfo
import org.apache.spark.sql.execution.ui.{SparkListenerSQLExecutionEnd, SparkListenerSQLExecutionStart}

import scala.collection.mutable.ArrayBuffer

object Lineage {

    case class DataSource(format: String, location: String)
    case class Lineage(sources: List[DataSource])

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    var existingMetadata = ""

    private def analyzeExecution(planInfo: SparkPlanInfo, acc: ArrayBuffer[DataSource]): Unit = {
        if(planInfo.children.isEmpty){
            val format = planInfo.metadata.get("Format")
            val location = planInfo.metadata.get("Location")
            if(format.isDefined || location.isDefined){
                acc += DataSource(format.getOrElse("Err: unknown format"), location.getOrElse("Err: unknown location"))
            }
        } else {
            planInfo.children.foreach(analyzeExecution(_, acc))
        }
    }


    def init(spark: SparkSession): Unit = {
        spark.sparkContext.addSparkListener(new SparkListener() {
            override def onOtherEvent(event: SparkListenerEvent): Unit = {
                event match {
                    case event: SparkListenerSQLExecutionStart => {
                        val dataSources = new ArrayBuffer[DataSource]()
                        analyzeExecution(event.sparkPlanInfo, dataSources)
                        val sources = mapper.writeValueAsString(Lineage(dataSources.toList))
                        println(event.physicalPlanDescription)
                        if(!dataSources.isEmpty){
                            existingMetadata = spark.conf.get("spark.databricks.delta.commitInfo.userMetadata", "")
                            val metadata = s"${if (existingMetadata.size > 0) existingMetadata+" " else ""}__LINEAGE $sources LINEAGE__"
                            spark.conf.set("spark.databricks.delta.commitInfo.userMetadata", metadata)
                        }
                    }
                    case _ =>
                }
            }
            override def onJobEnd(applicationEnd: SparkListenerJobEnd) {
                //Revert metadata to original value
                spark.conf.set("spark.databricks.delta.commitInfo.userMetadata", existingMetadata)
            }
        })

    }

}