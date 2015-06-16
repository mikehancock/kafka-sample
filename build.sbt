name := "kafkaSample"

version := "1.0"

lazy val `kafkasample` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc , anorm , cache , ws,
  "org.apache.kafka" % "kafka_2.11" % "0.8.2.1",
  "org.scalatest" % "scalatest_2.11" % "2.2.5" % "test"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  