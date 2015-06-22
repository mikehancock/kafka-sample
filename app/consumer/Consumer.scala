package consumer

import kafka.consumer.{ Consumer => KafkaConsumer }
import kafka.consumer._
import utils.KafkaConfig
/**
 * Created by mike on 22/06/15.
 */
abstract class Consumer(topics: List[String]) {

  protected val kafkaConfig = KafkaConfig()
  protected val config = new ConsumerConfig(kafkaConfig)

  def read(): Iterable[String]
}
