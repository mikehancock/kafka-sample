package producer

import java.util.Properties
import kafka.producer.{KeyedMessage, ProducerConfig, Producer => KafkaProducer}
import utils.KafkaConfig

/**
 * Created by mike on 16/06/15.
 */
case class Producer[A](topic: String) {
  protected val config = new ProducerConfig(KafkaConfig())
  private lazy val producer = new KafkaProducer[A, A](config)

  def send(message: A) = sendMessage(producer, keyedMessage(topic, message))

  private def keyedMessage(topic: String, message: A): KeyedMessage[A, A] = new KeyedMessage[A, A](topic, message)
  private def sendMessage(producer: KafkaProducer[A, A], message: KeyedMessage[A, A]) = producer.send(message)
}

object Producer {
  def apply[T](topic: String, props: Properties) = new Producer[T](topic) {
    override val config = new ProducerConfig(props)
  }
}
