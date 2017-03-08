name := """exercises week09"""

version := "1.0"

scalaVersion := "2.12.1"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// Need to pull this in for reflective capabilities.
libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-agent" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-camel" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-metrics" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-sharding" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-tools" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-contrib" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-multi-node-testkit" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-osgi" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-persistence-tck" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-stream-testkit" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-distributed-data-experimental" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-typed-experimental" % "2.4.17"
libraryDependencies += "com.typesafe.akka" %% "akka-persistence-query-experimental" % "2.4.17"

// Exclude some folders associated with IntelliJ
ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"