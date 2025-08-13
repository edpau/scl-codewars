/*
https://www.codewars.com/kata/546e2562b03326a88e000020/scala
Welcome. In this kata, you are asked to square every digit of a number and concatenate them.

For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1. (81-1-1-81)

Example #2: An input of 765 will/should return 493625 because 72 is 49, 62 is 36, and 52 is 25. (49-36-25)

Note: The function accepts an integer and returns an integer.
 */


//object SquareDigits extends App {
//  def squareDigits(n: Int): Int = {
//    n.toString.map(x => ((x.asDigit) * (x.asDigit)).toString).mkString.toInt
//  }
//
//  println(squareDigits(9))
//}

// refactor
// add a helper function
// handle negative number
// Switch to BigInt for overflow safety
//object SquareDigits extends App {
//
//  def squareCharDigit(c: Char): String = {
//    val d = c.asDigit
//    (d * d).toString
//  }
//
//  def squareDigits(n: Int): BigInt = {
//    require(n >= 0, "Input must be non-negative")
//    BigInt(n.toString.map(squareCharDigit).mkString)
//  }
//
//  println(squareDigits(91))
//}

// refactor using .foldLeft
// .foldLeft is better when we want to avoid creating an intermediate collection
// (like a Seq[String]) and just build the result directly.
// It’s more memory-efficient and functional,
// since it accumulates the final result step by step in a single pass.

object SquareDigits extends App {

  def squareCharDigit(c: Char): String = {
    val d = c.asDigit
    (d * d).toString
  }

  def squareDigits(n: Int): BigInt = {
    require(n >= 0, "Input must be non-negative")
    val resultString = n.toString.foldLeft("") { (acc, c) =>
      acc + squareCharDigit(c)
    }

    BigInt(resultString)
  }

  println(squareDigits(91))
}
