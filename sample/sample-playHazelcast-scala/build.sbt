name := "sample-playHazelcast-scala"

version := "1.0-SNAPSHOT"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.sonatypeRepo("releases")

resolvers += "bintray" at "http://dl.bintray.com/fmasion/maven"

libraryDependencies ++= Seq(
    // Add your project dependencies here,
    "playhazelcast"  % "playhazelcast_2.10" % "3.2.3-play2.2",
    "playhazelcastclient"  % "playhazelcastclient_2.10" % "3.2.3-play2.2"
)

play.Project.playScalaSettings

scalacOptions ++= Seq("-deprecation","-feature")

