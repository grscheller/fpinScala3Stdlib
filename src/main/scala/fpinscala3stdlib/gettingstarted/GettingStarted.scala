package fpinscala3stdlib.gettingstarted

/** A very simple module called MyModule */
object MyModule {
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

/** Refactored version of MyModule */
object MyModuleRefactored {

  import MyModule.*

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

  private def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s %d is %d"
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]) = {
    println(formatResult("absolute value of", -42, abs))
    println(formatResult("factorial of", 5, factorial))
    println(formatResult("factorial of", 11, factorial))
    println(formatResult("fibonacci element", 0, fibonacci))
    println(formatResult("fibonacci element", 1, fibonacci))
    println(formatResult("fibonacci element", 6, fibonacci))
    println(formatResult("fibonacci element", 42, fibonacci))
  }
}
