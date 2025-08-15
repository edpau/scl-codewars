/*
https://www.codewars.com/kata/558fc85d8fd1938afb000014/scala
Create a function that returns the sum of the two lowest positive numbers given an array of minimum 4 positive integers. No floats or non-positive integers will be passed.

For example, when an array is passed like [19, 5, 42, 2, 77], the output should be 7.

[10, 343445353, 3453445, 3453545353453] should return 3453455.
 */

//object SumTwoSmallest extends App {
//  def sumTwoSmallest(xs: Seq[Int]): Int = {
//    xs.sorted.take(2).sum
//  }
//
//  println(sumTwoSmallest(List(4,6,2,7,1)))
//}

// refactor to improve time performance to O(n)
// but has bug
//object SumTwoSmallest extends App {
//  def sumTwoSmallest(xs: Seq[Int]): Int = {
//    val (min1, min2) = xs.foldLeft((Int.MaxValue, Int.MaxValue)){ case ((smallest, secondSmallest), current) =>
//      if(current < smallest) then (current, secondSmallest) // here is the bug I replace the smallest and throw away the new secondSmallest
//      else if (current < secondSmallest) then (smallest, current)
//      else (smallest, secondSmallest)
//    }
//
//    min1 + min2
//  }
//
//  println(sumTwoSmallest(List(4,6,2,7,1))) //7
//}

//debug and refactor
//object SumTwoSmallest extends App {
//  def sumTwoSmallest(xs: Seq[Int]): Int = {
//    val result =
//      xs.foldLeft((Int.MaxValue, Int.MaxValue)) {
//        case (acc @ (smallest, secondSmallest), current) =>
//          println(s"[in]  current=$current, acc=$acc")
//
//          val out =
//            if (current < smallest) (current, smallest)
//            else if (current < secondSmallest) (smallest, current)
//            else acc
//
//          println(s"[out] newAcc=$out\n")
//          out
//      }
//
//    println(s"final=$result")
//
//    val (min1, min2) = result
//    min1 + min2
//  }
//
//    println(sumTwoSmallest(List(4,6,2,7,1)))
//}

// refactor to handle illegal argument using either
//object SumTwoSmallest extends App {
//  def sumTwoSmallest(xs: Seq[Int]): Either[String, Int] = {
//
//    if (xs.length < 2) then Left("Input must contain at least 2 integers")
//    else {
//      val (min1, min2) = xs.foldLeft((Int.MaxValue, Int.MaxValue)) { case ((smallest, secondSmallest), current) =>
//        if (current < smallest) (current, smallest)
//        else if (current < secondSmallest) (smallest, current)
//        else (smallest, secondSmallest)
//      }
//
//      val sum = BigInt(min1) + min2
//      if (sum.isValidInt) Right(sum.toInt) else Left("Overflow")
//    }
//  }
//
//  // Usage example
//  // A) Pattern Match
//  sumTwoSmallest(List(2147483647, 2, 2147483647)) match {
//    case Right(n) => println(s"sum = $n")
//    case Left(err) => println(s"error: ${err}")
//  }
//
//  // B) fold to one string
//  val msg = sumTwoSmallest(List(4)).fold(
//    err => s"Error: ${err}",
//    n => s"Sum: $n"
//  )
//  println(msg)
//
//  // C) Provide a default
//  val valueOr0: Int = sumTwoSmallest(List(1)).getOrElse(0)
//  println(valueOr0)
//
//}


//Define Typed Errors
sealed trait InputError {
  def message: String
}

case object TooShort extends InputError {
  val message = "Input must contain at least 2 integers."
}

case object NegativeNumberFound extends InputError {
  val message = "All numbers must be positive integers."
}

case object Overflow extends InputError {
  val message = "Sum exceeds Int maximum value."
}

object SumTwoSmallest extends App {

  def sumTwoSmallest(xs: Seq[Int]): Either[InputError, Int] = {
    if (xs.length < 2) Left(TooShort)
    else if (xs.exists(_ <= 0)) Left(NegativeNumberFound)
    else {
      val (min1, min2) = xs.foldLeft((Int.MaxValue, Int.MaxValue)) {
        case ((smallest, secondSmallest), current) =>
          if (current < smallest) (current, smallest)
          else if (current < secondSmallest) (smallest, current)
          else (smallest, secondSmallest)
      }

      val sum = BigInt(min1) + min2
      if (sum.isValidInt) Right(sum.toInt)
      else Left(Overflow)
    }
  }

  val result = sumTwoSmallest(List(1, 2, 3))
  result match {
    case Right(n) => println(s"Sum = $n")
    case Left(error) => println(s"Error: ${error.message}")
  }

  val result1 = sumTwoSmallest(List(1))
  result1 match {
    case Right(n) => println(s"Sum = $n")
    case Left(error) => println(s"Error: ${error.message}")
  }

  println(sumTwoSmallest(List(-3, 1)).left.map(_.message))
  println(sumTwoSmallest(List(1)).left.map(_.message))
  println(sumTwoSmallest(List(Int.MaxValue, Int.MaxValue)).left.map(_.message))
}



//// SumTwoSmallest.scala
//object SumTwoSmallest extends App {
//
//  // 1) Domain error type instead of String
//  sealed trait SumError { def message: String }
//  object SumError {
//    final case class TooFewElements(actual: Int) extends SumError {
//      def message: String = s"Need at least 2 elements, got $actual"
//    }
//  }
//
//  // 2) O(n) time, O(1) extra memory, no intermediate tuples per element
//  def sumTwoSmallest(xs: IterableOnce[Int]): Either[SumError, Int] = {
//    val it = xs.iterator
//    if (!it.hasNext) return Left(SumError.TooFewElements(0))
//    val a = it.next()
//    if (!it.hasNext) return Left(SumError.TooFewElements(1))
//    var b = it.next()
//
//    // ensure smallest <= secondSmallest
//    var smallest = math.min(a, b)
//    var secondSmallest = math.max(a, b)
//
//    while (it.hasNext) {
//      val current = it.next()
//      if (current < smallest) {
//        secondSmallest = smallest
//        smallest = current
//      } else if (current < secondSmallest) {
//        secondSmallest = current
//      }
//    }
//
//    Right(smallest + secondSmallest)
//  }
//
//  // --- Usage examples ---
//
//  // A) Pattern match
//  sumTwoSmallest(List(4, 6, 2, 7, 1)) match {
//    case Right(n)   => println(s"sum = $n")           // sum = 3
//    case Left(err)  => println(s"error: ${err.message}")
//  }
//
//  // B) fold to one string
//  val msg = sumTwoSmallest(List(1)).fold(
//    err => s"Error: ${err.message}",
//    n   => s"Sum: $n"
//  )
//  println(msg)
//
//  // C) Provide a default
//  val valueOr0: Int = sumTwoSmallest(List(1)).getOrElse(0)
//  println(valueOr0)
//}