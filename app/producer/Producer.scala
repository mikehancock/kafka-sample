package producer

import java.util.Properties
import kafka.producer.{KeyedMessage, ProducerConfig, Producer => KafkaProducer}
import utils.KafkaConfig

/**
 * Created by mike on 16/06/15.
 */
case class Producer[A](topic: String) {
  protected val config = new ProducerConfig(KafkaConfig())
  private lazy val producer = new KafkaProducer[A, Array[Byte]](config)

  def send(message: Array[Byte]) = sendMessage(producer, keyedMessage(topic, message))

  private def keyedMessage(topic: String, message: Array[Byte]): KeyedMessage[A, Array[Byte]] = new KeyedMessage[A, Array[Byte]](topic, message)
  private def sendMessage(producer: KafkaProducer[A, Array[Byte]], message: KeyedMessage[A, Array[Byte]]) = producer.send(message)
}


object Producer {
  def apply[T](topic: String, props: Properties) = new Producer[T](topic) {
    override val config = new ProducerConfig(props)
  }
}
