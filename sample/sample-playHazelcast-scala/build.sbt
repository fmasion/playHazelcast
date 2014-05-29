name := "sample-playHazelcast-scala"

//organization := "com.intelligent-es"

version := "1.0-SNAPSHOT"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.file("Local repo", file(System.getProperty("user.home") + "/.ivy2/local"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
    // Add your project dependencies here,
    "playhazelcast"  % "playhazelcast_2.10" % "3.2.1",
    "playhazelcastclient"  % "playhazelcastclient_2.10" % "3.2.1"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalacOptions ++= Seq("-deprecation","-feature")
