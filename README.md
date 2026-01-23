# Mag
Common relational database utilities and abstractions in Scala provided as a library.

The general idea here is the following. We have:
* [fa-db](https://github.com/AbsaOSS/fa-db), for representing DB functions in relational SQL and easier work with them within Scala
* [balta](https://github.com/AbsaOSS/balta), as a unit-testing library written in Scala for usage in Scala, with which you easily test such functions against a database with a nice set of additional capabilities to also write preconditions / postconditions for individual test cases
* [ultet](https://github.com/AbsaOSS/ultet/), a database migration tool, written in Scala, but embed-able in any CI/CD in the future
* and now, some, if not all of these above will use common DB abstractions in Scala - definition of table, column, SQL expression, etc. This library `mag` is serving as a common stable layer, meaning that `mag` has very little dependencies in itself, but other libraries in our ecosystem are depending on it. We are not only trying to avoid circular dependency problem, but also do not wish to import one (or more) of these libraries into another unnecessarily, and want to have a relatively simple stable layer as a base of our relational DB abstraction.
