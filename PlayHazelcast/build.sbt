name := "playHazelcast"

libraryDependencies ++= Seq(
    // Add your project dependencies here,
    "com.hazelcast" % "hazelcast" % "3.2.3",
    "com.hazelcast" % "hazelcast-cloud" % "3.2.3"
)

play.Project.playScalaSettings

scalacOptions ++= Seq("-deprecation","-feature")

