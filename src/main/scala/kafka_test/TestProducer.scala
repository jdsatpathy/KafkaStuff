package kafka_test
import java.util._

import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

object TestProducer {
def main (args : Array[String] ) : Unit = {
  val envProp = ConfigFactory.load().getConfig(args(0))
  val prop = new Properties()
  prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,envProp.getString("bootstrap.server"))
  prop.put(ProducerConfig.CLIENT_ID_CONFIG,"Kafka Test Program")
  prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer")
  prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[String, String](prop)
  var record = new ProducerRecord[String, String]("newTest","MyKey1","MyValue5")
  producer.send(record)
  producer.close()
  }
}
