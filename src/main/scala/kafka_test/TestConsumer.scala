package kafka_test

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecords, KafkaConsumer}
import java.util.{Collections, Properties}
import scala.collection.JavaConversions._
import com.typesafe.config.ConfigFactory

object TestConsumer {
  def main(args: Array[String]): Unit = {
    val envProp = ConfigFactory.load().getConfig("dev")
    val prop = new Properties()
    prop.put(ConsumerConfig.CLIENT_ID_CONFIG,"Kafka Test Consumer")
    prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,envProp.getString("bootstrap.server"))
    prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
    prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
    prop.put(ConsumerConfig.GROUP_ID_CONFIG,"1")
    val consumer = new KafkaConsumer[String,String](prop)
    consumer.subscribe(Collections.singletonList("newTest"))
    while (true)
      {
        val records : ConsumerRecords[String, String] = consumer.poll(500)
        for (reco <- records.iterator())
          println(s"Message Received : ( Key : ${reco.key()} , Value : ${reco.value()} , Offset : ${reco.offset()} , " +
            s" Timestamp : ${reco.timestamp()} )")
      }

  }

}
