package models

import play.api.libs.json.Json

/**
 * Created by mike on 16/06/15.
 */
object Event {
  case class Event(sourceId: Long, name: String, lat: Double, long: Double)

  implicit val eventWrites = Json.writes[Event]
  implicit val eventReads = Json.reads[Event]
}
