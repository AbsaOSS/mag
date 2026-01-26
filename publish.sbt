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

ThisBuild / organization := "za.co.absa.mag"
ThisBuild / organizationName := "ABSA Group Limited"
ThisBuild / organizationHomepage := Some(url("https://www.absa.africa"))

publish / skip := true //skipping publishing of the root of the project, publishing only some submodules

ThisBuild / scmInfo := Some(
  ScmInfo(
    browseUrl = url("https://github.com/AbsaOSS/mag/tree/master"),
    connection = "scm:git:git://github.com/AbsaOSS/mag.git",
    devConnection = "scm:git:ssh://github.com/AbsaOSS/mag.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id = "lsulak",
    name = "Ladislav Sulak",
    email = "ladislav.sulak@absa.africa",
    url = url("https://github.com/lsulak")
  ),
  Developer(
    id = "salamonpavel",
    name = "Pavel Salamon",
    email = "pavel.salamon@absa.africa",
    url = url("https://github.com/salamonpavel")
  ),
  Developer(
    id = "benedeki",
    name = "David Benedeki",
    email = "david.benedeki@absa.africa",
    url = url("https://github.com/benedeki")
  )
)

ThisBuild / description := "Common relational database utilities and abstractions in Scala provided as a library"
ThisBuild / startYear := Some(2026)
ThisBuild / licenses += "Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt")
ThisBuild / homepage := Some(url("https://github.com/AbsaOSS/mag"))
