name := "playHazelcast"

version := "3.2.1"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.file("Local repo", file(System.getProperty("user.home") + "/.ivy2/local"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
    // Add your project dependencies here,
    "com.hazelcast" % "hazelcast" % "3.2.1",
    "com.hazelcast" % "hazelcast-cloud" % "3.2.1"
)

play.Project.playScalaSettings



scalacOptions ++= Seq("-deprecation","-feature")

