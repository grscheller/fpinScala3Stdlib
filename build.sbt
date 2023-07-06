// Modified from the version used by ShapelessCat

ThisBuild / scalaVersion := "3.3.0"  // Latest LTS release as of 2023/07/04 

ThisBuild / scalacOptions ++= Seq(
  "-encoding", "utf-8",  // Specify character encoding used by source files.
  "-deprecation",
  "-feature",
  "-explain",            // Explain errors in more detail.
  "-explain-types",      // Explain type errors in more detail.
  "-unchecked",          // Enable additional warnings where generated code depends on assumptions.
  "-Xfatal-warnings",    // Fail the compilation if there are any warnings.
  "-new-syntax",         // Require `then` and `do` in control expressions.
  "-rewrite",
  "-Ykind-projector:underscores",
//  "-Ykind-projector",
  "-source:future-migration",
)

ThisBuild / javacOptions := Seq(
  "-source", "17",       // Latest LTS release of Java as of 2023/07/04
  "-Xlint:unchecked",
  "-Xlint:deprecation"
)

ThisBuild / libraryDependencies ++= Seq(
  "com.lihaoyi" % "fansi_2.13" % "0.4.0"
)

lazy val root = (project in file("."))
  .settings(
    name := "fpinscala3stdlib"
  )
