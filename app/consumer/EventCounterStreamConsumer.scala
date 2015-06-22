package consumer

import models.Event.Event
import play.api.libs.json.{JsError, JsSuccess, Json}

/**
 * Created by mike on 22/06/15.
 */
object EventCounterStreamConsumer {
  def main(args: Array[String]): Unit = {
    val topicNames = if(args.length == 0) {
      "kafka.testTopic"
    } else {
      args.head
    }

    val consumer = SingleTopicConsumer(topicNames)
    implicit val reads = Json.reads[Event]

    consumer.read().foreach {
      message =>
        val json = Json.parse(message)

        json.validate[Event] match {
          case JsSuccess(event, _) => println("Got an event: " + event)
          case JsError(errors)    => println("Errors! " + errors.mkString)
        }
    }
  }
}
