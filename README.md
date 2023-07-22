# Functional Programing in Scala Using Scala3 via Scala3 Std Libraries

## Description

Leverage the Scala3 standard libraries to work through the path laid
out in Functional Programming in Scala by Chiusana & Bjarnason. Guided
by ShapelessCat/fpinscala3 Scala3 version of the books exercises.

## Purpose

Unlike the book exercises, the purpose is not to recreate an entire FP
infrastructure from scratch. The purpose is to leverage the Scala
Standard libraries and selected external libraries to give *efficient*
examples of functional programming. By *functional* I do not necessarily
mean *pure*; I am willing to push *imperative* code to innermost or
outermost scopes.

## Development log:

### 2023-07-22:

Beginning the test suite for the gettingstarted package, leveraging
ScalaTest. So far just testing Java & Scala language constructs using
assertions, no testing style, no property based testing.

### 2023-07-20:

Updated scalaOptions in build.sbt
    
* added "-Wunused:all" to warn about various unused symbols
* commented out "-Xfatal-warnings"
  * maybe more suitable for automated testing situations
* added flag "-Ykind-projector"
  * enables support for `*-based type lambdas`
  * without enabling `underscore type lambdas`

### 2023-07-04:

Started the grscheller/fpinscala3stdlib GitHub repo.

### 2023-07-04:

Previously got through Chapter 9, Parsor Combinators, on my own. I last
worked on it Jul 17, 2021 when I updated for use with Scala 3. The last
version of this is contained in the exercises branch of this repo. Its
development history is contained in my grscheller/scheller-linux-archive
repo. I intially started work on it on Apr 10, 2016.
