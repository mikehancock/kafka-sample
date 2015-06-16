package serialisation

import java.io.{ObjectOutputStream, ByteArrayOutputStream}

import kafka.message.Message
import kafka.serializer.Encoder
import kafka.utils.VerifiableProperties
import models.Event.Event

/**
 * Created by mike on 16/06/15.
 */
object EventEncoder {
  def toBytes(event: Event): Array[Byte] = {
    val baos = new ByteArrayOutputStream()
    val oos = new ObjectOutputStream(baos)
    oos.writeObject(event)
    oos.close()
    baos.toByteArray()
  }
}

// for soem reason kafka can't find this class when specified as the custom encoder
class EventEncoder(verifiableProperties: VerifiableProperties) extends Encoder[Event] {

  override def toBytes(event: Event): Array[Byte] = {
    val baos = new ByteArrayOutputStream()
    val oos = new ObjectOutputStream(baos)
    oos.writeObject(event)
    oos.close()
    baos.toByteArray()
  }

  //override def toMessage(event: Event):Message = new Message(toBytes(event))
}
