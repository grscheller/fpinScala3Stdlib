package fpinscala3stdlib.test.gettingstarted

import org.scalatest.Assertions.assert

//* No test style, just assertions */
object javaTests {
  def testJavaInts() = {
    val myValue: Int = 42
    val onLeft: Int = 7
    // val onRight: Int = 7
    val onRight: Int = 13

    assert(myValue == myValue)
    assert(onLeft == onRight)
  }

  @main def testJava() = {
    testJavaInts()
  }

}

object scalaTests {

  def testScalaLists() = {
    assert(List.empty.size == 0, "An empty List should have size 0")
  }

  @main def testScala() = {
    testScalaLists()
  }

}
