package task

import org.apache.samza.system.IncomingMessageEnvelope
import org.apache.samza.task.{TaskCoordinator, MessageCollector, StreamTask}
/**
 * Created by mike on 17/06/15.
 */
class EventCounterStreamTask extends StreamTask {

  override def process(envelope: IncomingMessageEnvelope, collector: MessageCollector, coordinator: TaskCoordinator): Unit = {
    val message = envelope.getMessage

    // need to deserialse the message and then output something

    System.out.println(message);

  }
}
