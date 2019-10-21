name := "KafkaStuff"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "1.0.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.2"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.2"
libraryDependencies += "com.typesafe" % "config" % "1.2.1"