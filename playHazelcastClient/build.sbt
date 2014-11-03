name := "playHazelcastClient"

libraryDependencies ++= Seq(
    "com.hazelcast" % "hazelcast-client" % "3.2.3",
    "com.hazelcast" % "hazelcast-cloud" % "3.2.3"
)

scalacOptions ++= Seq("-deprecation","-feature")

