name := "playHazelcastClient"

version := "3.2.1"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
    "com.hazelcast" % "hazelcast-client" % "3.2.1",
    "com.hazelcast" % "hazelcast-cloud" % "3.2.1"
)

play.Project.playScalaSettings



scalacOptions ++= Seq("-deprecation","-feature")

