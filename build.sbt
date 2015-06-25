name := "kafkaSample"

version := "1.0"

lazy val `kafkasample` = (project in file(".")).enablePlugins(PlayScala, DockerPlugin)

scalaVersion := "2.10.5"

val samzaVersion = "0.9.0"

libraryDependencies ++= Seq(
  jdbc , anorm , cache , ws,
  "org.apache.kafka" %% "kafka" % "0.8.2.1",
  "org.apache.samza" % "samza-api" % samzaVersion,
  "org.apache.samza" %% "samza-core" % samzaVersion,
  "org.apache.samza" %% "samza-kafka" % samzaVersion,
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

maintainer in Docker := "Michael Hancock"

dockerBaseImage := "java:8"

dockerExposedPorts := Seq(9000)