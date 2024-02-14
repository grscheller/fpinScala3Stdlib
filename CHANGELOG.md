## Development CHANGELOG:

#### 2024-02-14:

Have not had much time to work on this lately. Did verify that Scala
Metals is still working properly.

#### 2023-07-23:

Implemented gettingstarted.higherOrder object. Also added some iteration
methods. Tested out on Scala console.

#### 2023-07-22:

Beginning the test suite for the gettingstarted package, leveraging
ScalaTest. So far just testing Java & Scala language constructs using
assertions, no testing style, no property based testing.

#### 2023-07-20:

Updated scalaOptions in build.sbt
    
* added "-Wunused:all" to warn about various unused symbols
* commented out "-Xfatal-warnings"
  * maybe more suitable for automated testing situations
* added flag "-Ykind-projector"
  * enables support for `*-based type lambdas`
  * without enabling `underscore type lambdas`

#### 2023-07-04:

Started the grscheller/fpinscala3stdlib GitHub repo.

#### 2023-07-04:

Previously got through Chapter 9, Parsor Combinators, on my own. I last
worked on this material Jul 17, 2021 when I updated it for use with
Scala 3. The last version of this is contained in the exercises branch
of this repo. Its development history is contained in the GIT history of
my grscheller/scheller-linux-archive repo. I intially started work on it
Apr 10, 2016.
