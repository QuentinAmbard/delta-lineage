object Test {

    def main(args: Array[String]): Unit = {
        buildEvent(null)
    }

    case class Metadata(var source: String, var source_id: String, var timestamp: java.lang.Long, var version: String, var instance_type: String)
    case class Status(var id: java.lang.Integer, var comment: String, var metadata: Metadata)
    case class Addon(var name: String, var id: String, var `type`: String, var price_category_id: String, var price: BigDecimal, var currency_rate: BigDecimal, var currency: String)
    case class Dsp(var campaign_id: java.lang.Integer, var creative_id:  java.lang.Integer, var lineitem_id: java.lang.Integer, var deal_id: String = null, var campaign_hid: java.lang.Integer, var application_id: String, var media_buying_agency: java.lang.Integer, var advertiser_id: java.lang.Integer, var client_id: java.lang.Integer, var medium_id: java.lang.Integer, var geopoint_id: java.lang.Integer = null, var area_id: String = null, var addons: Seq[Addon], var geo_hash: String = null, var consent_status: String = null, var consent_source: String = null, var win_price: BigDecimal, var currency_rate: BigDecimal, var currency: String)
    case class Fusio(var client_id: String, var agency_id: String, var advertiser_id: String, var order_id: String, var line_id: String, var tactic_id: String, var ad_id: String)
    case class DisplayPlacement(var height: java.lang.Integer, var width: java.lang.Integer, var ctype: java.lang.Integer = null, var mimes: Seq[String] = null, var api: java.lang.Integer = null)
    case class VideoPlacement(var height: java.lang.Integer, var width: java.lang.Integer, var delay: java.lang.Integer = null, var mimes: Seq[String] = null, var linearity: java.lang.Integer = null, var api: java.lang.Integer = null, var ctype: Seq[Int] = null)
    case class AudioPlacement(var mimes: Seq[String] = null, var ctype: Seq[Int] = null, var delay: java.lang.Integer = null, var api: java.lang.Integer = null, var length_min: java.lang.Integer = null, var length_max: java.lang.Integer = null)
    case class Placement(var tag_id: String = null, var secure: java.lang.Boolean, var instl: java.lang.Boolean = false, var display: DisplayPlacement = null, var video: VideoPlacement = null, var audio: AudioPlacement = null)
    case class Metric(var `type`: String, var value: java.lang.Float, var vendor: String)
    case class Deal(var id: String, var floor: String = null, var floor_currency: String = "USD")
    case class Item(var id: String, var quantity: java.lang.Integer = 1, var floor: BigDecimal, var floor_currency: String = "USD", var at: java.lang.Integer, var deal: Seq[Deal], var metric: Seq[Metric], var placement: Placement)
    case class Source(var tid: String, var timestamp: java.lang.Long, var signature: String, var signature_map: Map[String, String], var certificate: String)
    case class Regulation(var coppa: java.lang.Integer, var gdpr: java.lang.Integer)
    case class Restriction(var badv: Seq[String], var bcat: Seq[String], var battr: Seq[String])
    case class App(var domain: String = null, var bundle: String = null, var store_url: String = null, var categories: Seq[String] = null)
    case class Site(var domain: String = null, var categories: Seq[String] = null)
    case class Dooh(var venue: java.lang.Integer = null, var etime: java.lang.Integer = null, var fixed_location: java.lang.Integer = null)
    case class Publisher(var id: String = null, var name: String = null, var domain: String = null, var categories: Seq[String] = null)
    case class Content(var id: String = null, var title: String = null, var url: String = null, var categories: Seq[String] = null, var context: String = null, var language: String = null, var length: java.lang.Integer = null)
    case class DistributionChannel(var id: String = null, var `type`: String = null, var name: String = null, var publisher: Publisher = null, var content: Content = null, var app: App = null, var site: Site = null, var dooh: Dooh = null)
    case class Geo(var country: String = null, var region: String = null, var zip: String = null, var city: String = null, var latitude: java.lang.Float = null, var longitude: java.lang.Float = null, var `type`: java.lang.Integer = null)
    case class User(var age: java.lang.Integer = null, var gender: String = null, var consent: String = null, var dnt: java.lang.Boolean = null, var geo: Geo = null)
    case class Device(var carrier: String = null, var language: String = null, var os: String = null, var os_version: String = null, var model: String = null, var connection_type: java.lang.Integer = null, var `type`: java.lang.Integer = null, var ip: String = null, var user_agent: String = null, var ifa: String = null, var geo: Geo = null)
    case class Context(var distribution_channel: DistributionChannel, var user: User = null, var device: Device = null, var regulations: Regulation = null, var retrictions: Restriction = null)
    case class Request(var id: String, var test: java.lang.Integer = 0, var at: java.lang.Integer = 2, var accepted_currency: Seq[String] = Seq("USD"), var source: Source, var context: Context, var item: Seq[Item])
    case class Macro(var key: String, var value: String)
    case class Display(var height: java.lang.Integer, var width: java.lang.Integer, var mimes: Seq[String] = null, var api: java.lang.Integer = null)
    case class Video(var mimes: Seq[String] = null, var api: java.lang.Integer = null, var ctype: java.lang.Integer = null, var length: java.lang.Integer = null)
    case class Audio(var mimes: Seq[String] = null, var ctype: java.lang.Integer = null, var length: java.lang.Integer = null)
    case class Ad(var id: String, var categories: Seq[String] = null, var language: String = null, var display: Display = null, var video: Video = null, var audio: Audio = null)
    case class Bid(var id: String, var item_id: String, var deal_id: String, var campaign_id: String, var price: BigDecimal, var ad: Ad, var tactic_id: String, var macros: Seq[Macro])
    case class SeatBid(var id: String, var package$: java.lang.Integer = 0, var bids: Seq[Bid])
    case class Response(var id: String, var bid_id: String, var currency: String = "USD", var seatbids: Seq[SeatBid])
    case class Bidder(var metadata: Metadata, var request: Request, var response:  Response)
    case class SeerContext(var optimized: java.lang.Boolean = true, var seer_bidding_arms: Seq[String] = null, var seer_service_version: String, var geo_accuracy: java.lang.Double = null)
    case class Dts(var metadata: Metadata, var uplift_kpi: String = null, var ifa_attribution_ref: String = null, var poi: String = null, var ifa: String = null, var footfall_measurer: String = null)

    case class Event(
                        var timestamp: java.lang.Long,
                        var id: String,
                        var `type`: String,
                        var transaction_id: String,
                        var metadata: Seq[Metadata],
                        var status_flags: Seq[Status],
                        var bidder: Bidder = null,
                        //    var tracker: Tracker = null,
                        //    var leet: Leet = null,
                        var fusio: Fusio = null,
                        var dsp: Dsp = null,
                        var seer_context: SeerContext = null,
                        var dts: Dts = null
                        //    var billing: Billing = null
                    )


    import org.apache.spark.sql.Row
    import java.util.UUID
    import org.apache.spark.sql.Row
    import scala.util.Random
    import org.apache.spark.sql.functions._

    def get[T](fieldName: String, r: Row): T = {
        r.getAs[T](r.fieldIndex(fieldName))
    }

    def withMetadata(r: Row) : Metadata = {
        Metadata(
            "databricks",
            "source_id",
            get[Long]("event_time", r),
            UUID.randomUUID().toString,
            "com.databricks.zeppelin.poc"
        )
    }

    def withStatus(r: Row) : Status = {
        val id = if(get[Boolean]("suspicious_bool", r)) 1 else 0
        Status(
            id, "Based on suspicious bool", withMetadata(r)
        )
    }

    def withFusio(r: Row) : Fusio = {
        Fusio(
            get[String]("client_id", r),
            get[String]("agency_id", r),
            get[String]("advertiser_id", r),
            get[String]("order_id", r),
            get[String]("line_id", r),
            get[String]("tactic_id", r),
            get[String]("ad_id", r)
        )
    }

    def withSource(r: Row) : Source = {
        Source(
            get[String]("tx_id", r),
            get[Long]("brq_timestamp", r),
            "signature",
            Map[String, String](),
            "certificate"
        )
    }

    def withDisplayPlacement(r: Row) : DisplayPlacement = {
        DisplayPlacement(
            get[Int]("imp_height_size", r),
            get[Int]("imp_width_size", r),
            1,
            get[Seq[String]]("imp_banner_mimes", r),
            get[Int]("imp_banner_api", r)
        )
    }

    def withPlacement(r: Row) : Placement = {
        Placement(
            get[String]("imp_id", r),
            true,
            get[Boolean]("imp_is_instl", r),
            withDisplayPlacement(r),
            null,
            null
        )
    }

    def withItem(r: Row) : Item = {
        val floor: BigDecimal = if(r.isNullAt(r.fieldIndex("bid_floor"))) null else get[java.math.BigDecimal]("bid_floor", r)

        Item(
            get[String]("imp_id", r),
            1,
            floor,
            get[String]("order_currency", r),
            if(r.isNullAt(r.fieldIndex("at"))) 2 else get[Int]("at", r),
            Seq(Deal(get[String]("deal_id", r), null)),
            null,
            withPlacement(r)
        )
    }

    def withDspForUpliftAll(r: Row) : Dsp = {
        Dsp(
            0,
            null,
            get[Int]("dsp_lineitem_id", r),
            null,
            //NOT PRESENT campaign_hid
            0,
            null,
            get[Int]("dsp_mba_id", r),
            get[Int]("dsp_advertiser_id", r),
            get[Int]("dsp_client_id", r),
            //NOT PRESENT medium_id
            0,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            get[String]("order_currency", r)
        )
    }

    def withDspForCg(r: Row) : Dsp = {
        Dsp(
            get[Int]("dsp_campaign_id", r),
            null,
            get[Int]("dsp_lineitem_id", r),
            get[String]("deal_id", r),
            //NOT PRESENT campaign_hid
            Random.nextInt(),
            null,
            get[Int]("dsp_mba_id", r),
            get[Int]("dsp_advertiser_id", r),
            get[Int]("dsp_client_id", r),
            //NOT PRESENT medium_id
            Random.nextInt(),
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            get[String]("order_currency", r)
        )
    }

    def withDsp(r: Row) : Dsp = {
        val winPrice: BigDecimal = if(r.isNullAt(r.fieldIndex("win_price"))) null else get[java.math.BigDecimal]("win_price", r)
        val currencyRate: BigDecimal = if(r.isNullAt(r.fieldIndex("currency_rate"))) null else new java.math.BigDecimal(get[Float]("currency_rate", r))

        Dsp(
            get[Int]("dsp_campaign_id", r),
            get[Int]("dsp_creative_id", r),
            get[Int]("dsp_lineitem_id", r),
            get[String]("deal_id", r),
            //NOT PRESENT campaign_hid
            666,
            get[String]("support_id", r),
            get[Int]("dsp_mba_id", r),
            get[Int]("dsp_advertiser_id", r),
            get[Int]("dsp_client_id", r),
            //NOT PRESENT medium_id
            666,
            //NOT PRESENT geopoint_id
            null,
            if(r.isNullAt(r.fieldIndex("area_id"))) null else String.valueOf(get[Long]("area_id", r)),
            //NOT PRESENT addons
            null,
            get[String]("device_geo_hash", r),
            get[String]("consent_status", r),
            //NOT PRESENT consent_source
            "consent_source",
            winPrice,
            currencyRate,
            get[String]("order_currency", r)
        )
    }

    def withPublisher(r: Row) : Publisher = {
        Publisher(
            get[String]("publisher_id", r),
            get[String]("publisher_name", r),
            null,
            get[Seq[String]]("support_categories", r)
        )
    }

    def withContent(r: Row) : Content = {
        Content(
            null, null, null, null, null, null, null
        )
    }

    def withApp(r: Row) : App = {
        App(
            get[String]("support_domain", r),
            get[String]("support_app_bundle", r),
            get[String]("support_appstoreurl", r),
            get[Seq[String]]("support_categories", r)
        )
    }

    def withDistributionChannel(r: Row) : DistributionChannel = {
        DistributionChannel(
            UUID.randomUUID().toString,
            get[String]("support_type", r),
            "Michael",
            withPublisher(r),
            withContent(r),
            withApp(r),
            null,
            null
        )
    }

    def withGeo(r: Row) : Geo = {
        Geo(
            get[String]("device_geo_country", r),
            get[String]("device_geo_region", r),
            get[String]("device_geo_zip", r),
            get[String]("device_geo_city", r),
            null, null,
            if(r.isNullAt(r.fieldIndex("device_geo_type"))) null else get[Int]("device_geo_type", r)
        )
    }

    def withDeviceForCg(r: Row) : Device = {
        Device(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            get[String]("device_ifa", r),
            null
        )
    }

    def withDevice(r: Row) : Device = {
        Device(
            get[String]("device_carrier", r),
            get[String]("device_language", r),
            get[String]("device_os", r),
            get[String]("device_os_version", r),
            get[String]("device_model", r),
            if(r.isNullAt(r.fieldIndex("device_connection_type"))) null else get[Int]("device_connection_type", r),
            if(r.isNullAt(r.fieldIndex("device_type"))) null else get[Int]("device_type", r),
            get[String]("device_ip", r),
            get[String]("device_useragent", r),
            get[String]("device_ifa", r),
            withGeo(r)
        )
    }

    def withUser(r: Row) : User = {
        User(
            if(r.isNullAt(r.fieldIndex("user_age"))) null else get[Int]("user_age", r),
            get[String]("user_gender", r),
            get[String]("user_consent",r),
            get[Boolean]("user_donottrack", r),
            null
        )
    }

    def withContextForCg(r: Row) : Context = {
        Context(
            null,
            null,
            withDeviceForCg(r),
            null,
            null
        )
    }


    def withContext(r: Row) : Context = {
        Context(
            withDistributionChannel(r),
            withUser(r),
            withDevice(r),
            null,
            null
        )
    }

    def withRequestForCg(r:Row) : Request = {
        Request(
            null,
            0,
            2,
            Nil,
            null,
            withContextForCg(r),
            Nil
        )
    }

    def withRequest(r:Row) : Request = {
        Request(
            get[String]("brq_id", r),
            0,
            get[Int]("at", r),
            Nil,
            withSource(r),
            withContext(r),
            Seq(withItem(r))
        )
    }

    def withResponse(r: Row) : Response = {
        Response(
            get[String]("brq_id", r),
            get[String]("imp_id", r),
            get[String]("order_currency", r),
            null //array<SeatBid>
        )
    }

    def withBidderForCg(r: Row) : Bidder = {
        Bidder(
            withMetadata(r),
            withRequestForCg(r),
            null
        )
    }

    def withBidder(r: Row) : Bidder = {
        Bidder(
            withMetadata(r),
            withRequest(r),
            withResponse(r)
        )
    }

    def withDtsForUpliftAll(r: Row) : Dts = {
        Dts(
            withMetadata(r),
            null,
            get[String]("ifa_attribution_ref", r),
            get[String]("poi", r),
            get[String]("device_ifa", r),
            null
        )
    }


    def withDtsForCg(r: Row) : Dts = {
        Dts(
            withMetadata(r),
            null,
            get[String]("ifa_attribution_ref", r),
            null,
            get[String]("device_ifa", r),
            null
        )
    }

    def withDts(r: Row) : Dts = {
        Dts(
            withMetadata(r),
            if(get[String]("ifa_attribution_ref", r) != null) "isv" else null,
            get[String]("ifa_attribution_ref", r),
            get[String]("poi", r),
            get[String]("device_ifa", r),
            "footfall_adsquare"
        )
    }

    def withSeerContext(r: Row) : SeerContext = {
        SeerContext(
            true,
            get[Seq[String]]("seer_bidding_arms", r),
            null,
            get[Double]("seer_geoaccuracy", r)
        )
    }

    def buildEvent(r: Row) : Event = {
        val event:String = get[String]("event_name", r)

        event match {
            //-- Todo : withDspForUpliftAll
            case "uplift_all" => Event(get[Long]("event_time", r), java.util.UUID.randomUUID.toString, get[String]("event_name", r), null, Nil, Nil, null, null, withDspForUpliftAll(r), null, withDtsForUpliftAll(r))
            case "cg" => Event(
                get[Long]("event_time", r),
                java.util.UUID.randomUUID.toString,
                get[String]("event_name", r),
                null,
                Nil,
                Nil,
                withBidderForCg(r),
                null,
                withDspForCg(r),
                null,
                withDtsForCg(r)
            )
            case _ => Event(
                get[Long]("event_time", r),
                java.util.UUID.randomUUID.toString,
                get[String]("event_name", r),
                get[String]("tx_id", r),
                Seq(withMetadata(r)),
                Seq(withStatus(r)),
                withBidder(r),
                withFusio(r),
                withDsp(r),
                withSeerContext(r),
                withDts(r)
            )
        }
    }

    val ev = Seq("bid", "win", "impression", "fully_rendered_impression", "click", "net_of_fraud_click", "cg", "uplift_all", "_isv")

  


}