package believe.royatlies

//import com.holdenkarau.spark.testing.{DatasetSuiteBase, SharedSparkContext, SparkSessionProvider}
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.scalatest.FlatSpec


class CheckTest extends FlatSpec { //with SharedSparkContext with DatasetSuiteBase {

    //see https://github.com/holdenk/spark-testing-base/issues/148


    "Price and quantity" should "not be both negative" in {

        assert(true)

    }


}
