/*
 * Copyright 2026 ABSA Group Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import Dependencies.*

// Scala versions
lazy val scala211 = "2.11.12"
lazy val scala212 = "2.12.21"
lazy val scala213 = "2.13.18"

// Build-wide settings
ThisBuild / scalaVersion := scala212
ThisBuild / crossScalaVersions := Seq(scala212, scala213)
ThisBuild / versionScheme := Some("early-semver")

// Common compiler options
lazy val commonJavacOptions = Seq("-source", "1.8", "-target", "1.8", "-Xlint")
lazy val commonScalacOptions = Seq("-unchecked", "-deprecation", "-feature", "-Xfatal-warnings")

// Custom task for printing Scala version
lazy val printScalaVersion = taskKey[Unit]("Print Scala versions Mag is being built for.")
ThisBuild / printScalaVersion := {
  val log = streams.value.log
  log.info(s"Building Mag with Scala ${scalaVersion.value}")
}

// Main module
lazy val mag = (project in file("mag"))
  .settings(
    name := "mag",
    libraryDependencies ++= magDependencies,
    javacOptions ++= commonJavacOptions,
    scalacOptions ++= commonScalacOptions,
    (Compile / compile) := ((Compile / compile) dependsOn printScalaVersion).value
  )
  .enablePlugins(FilteredJacocoAgentPlugin)

// Root project (aggregates all modules) - a good and common practice even if there is a single module
// (besides, we might add more later)
lazy val root = (project in file("."))
  .aggregate(mag)
  .settings(
    name := "mag-root",
    publish / skip := true
  )
