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

  def main(args: Array[String]) = {
    val msg1 = "Index first '%s' in cmdline arguments: %d"
    println(msg1.format("foo", findFirst(args, _ == "foo")))
  }
}
