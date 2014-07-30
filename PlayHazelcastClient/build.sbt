name := "playHazelcastClient"

version := "3.2.3-play2.2"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
    "com.hazelcast" % "hazelcast-client" % "3.2.3",
    "com.hazelcast" % "hazelcast-cloud" % "3.2.3"
)

play.Project.playScalaSettings



scalacOptions ++= Seq("-deprecation","-feature")

