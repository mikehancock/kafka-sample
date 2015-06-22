package controllers

import models.Event._
import play.api.libs.json._
import play.api.mvc._
import producer.Producer
import serialisation.EventEncoder

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def saveEvent = Action(BodyParsers.parse.json) { request =>
    val b = request.body.validate[Event]
    b.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
      },
      event => {
        val kafkaProducer = Producer[String]("kafka.testTopic")

        implicit val writes = Json.writes[Event]

        kafkaProducer.send(Json.toJson(event).toString)
        Ok(Json.obj("status" -> "OK"))
      }
    )
  }

}