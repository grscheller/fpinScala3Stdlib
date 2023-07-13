package fpinscala3stdlib.gettingstarted

/** A very simple "module" called MyObject */
object MyObject {
  def abs(n: Int): Int =
    if n < 0
    then -n
    else n

  private def formatAbs(x: Int): String = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  // Not "pure" because this method has a side effect,
  // it will change the state of your monitor.
  @main def printAbsNeg42() =
    println(formatAbs(-42))
}

/** Refactored version of MyObject */
object MyObjectRefactored {

  import MyObject.*

  /** Returns the factorial of the absolute value of Int argument */
  def factorial(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, acc: Int): Int =
      if n == 0
      then  acc
      else loop(n-1, n*acc)

    loop(abs(n), 1)
  }

  def fibonacci(n: Int) = {
    @annotation.tailrec
    def fib(n: Int, curr: Int, next: Int): Int =
      if n < 1
      then next
      else fib(n - 1, next, curr + next)

    // Start with the -1st & 0th Fibonacci numbers
    fib(n, 1, 0)
  }

  private def colorFormat(name: String, n: Int, f: Int => Int, color: String): fansi.Str = {
    val msg = "The %s %d is %d"
    val msg_formatted = msg.format(name, n, f(n))
    color match {
      case "Yellow" => fansi.Color.Yellow(msg_formatted);
      case "Blue"   => fansi.Color.Blue(msg_formatted);
      case "Green"  => fansi.Color.Green(msg_formatted);
      case _        => fansi.Color.Red(msg_formatted);
    }
  }

  def main(args: Array[String]) = {
    println(colorFormat("absolute value of", -42, abs, "Green"))
    println(colorFormat("factorial of", 5, factorial, "Yellow"))
    println(colorFormat("factorial of", 11, factorial, "Yellow"))
    println(colorFormat("fibonacci element", 0, fibonacci, "Blue"))
    println(colorFormat("fibonacci element", 1, fibonacci, "Blue"))
    println(colorFormat("fibonacci element", 6, fibonacci, "Blue"))
    println(colorFormat("fibonacci element", 42, fibonacci, "Blue"))
  }
}

object ArrayStuff {

  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if n < as.length
      then
        if p(as(n))
        then n
        else loop(n + 1)
      else -1

    loop(0)
  }
  
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean =
      if n < as.length
      then
        if ordered(as(n - 1), as(n))
        then loop(n + 1)
        else false
      else true

    loop(1)
  }

  def main(args: Array[String]) = {
    val msg1 = "Index first '%s' in cmdline arguments: %d"
    val msg2 = "Index first '%s' in Array(\"baz\", \"bar\", \"foo\", \"foo\", \"buzz\"): %d"
    println(msg1.format("foo", findFirst(args, _ == "foo")))
    println(msg2.format("foo", findFirst(Array("baz", "bar", "foo", "foo", "buzz"), _ == "foo")))
    println(msg2.format("bar", findFirst(Array("baz", "bar", "foo", "foo", "buzz"), _ == "bar")))
    val sorted_int_array = Array(1,2,42)
    val notsorted_int_array = Array(1,3,2,7)
    val sorted_str_array = Array("foobar", "foo", "a", "")
    val notsorted_str_array = Array("woo", "foofo", "foobar", "zoo")
    val msg = "%s %s sorted"
    if isSorted(sorted_int_array, _ <= _)
    then println(msg.format("Sorted int array is", "low to high"))
    else println(msg.format("Sorted int array is not", "low to high"))
    if isSorted(notsorted_int_array, _ <= _)
    then println(msg.format("Not sorted int array is", "low to high"))
    else println(msg.format("Not sorted int array is not", "low to high"))
    if isSorted(sorted_str_array, _ > _)
    then println(msg.format("Sorted string array is", "strictly decreasingly"))
    else println(msg.format("Sorted string array is not", "strictly decreasingly"))
    if isSorted(notsorted_str_array, _ > _)
    then println(msg.format("Not sorted string array is", "strictly decreasing"))
    else println(msg.format("Not sorted string array is not", "strictly decreasing"))
  }
}
