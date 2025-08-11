/*
https://www.codewars.com/kata/58f8a3a27a5c28d92e000144/train/scala
Your task is to find the first element of an array that is not consecutive.

By not consecutive we mean not exactly 1 larger than the previous element of the array.

E.g. If we have an array [1,2,3,4,6,7,8] then 1 then 2 then 3 then 4 are all consecutive but 6 is not, so that's the first non-consecutive number.

If the whole array is consecutive then return null2.

The array will always have at least 2 elements1 and all elements will be numbers. The numbers will also all be unique and in ascending order. The numbers could be positive or negative and the first non-consecutive could be either too!

1 Can you write a solution that will return null2 for both [] and [ x ] though? (This is an empty array and one with a single number and is not tested for, but you can write your own example test. )

2

Swift, Ruby and Crystal: nil
Haskell: Nothing
Python, Rust, Scala, Lambda Calculus: None
Julia: nothing
Nim: none(int) (See options)
C++: std::nullopt
 */

// Non local returns are no longer supported; use boundary and boundary.break in scala.util instead
// return Some(values(i)) inside a for loop causes this error in Scala 3:
// Scala 3 disallows "non-local returns" inside closures (like lambdas or for)
// That return tries to jump out of the enclosing method, not just the for loop
// Scala wants you to use structured expressions or the new boundary escape tool
//object FirstNonConsecutive extends App {
//  def firstNonConsecutive(values: Seq[Int]): Option[Int] = {
//    for (i <- 1 until values.length) {
//      if(values(i) != values(i-1) + 1) then return Some(values(i))
//    }
//    None
//  }
//
//  println(firstNonConsecutive(List(1,2,4)))
//}

// refactor to while loop
//object FirstNonConsecutive extends App {
//  def firstNonConsecutive(values: Seq[Int]): Option[Int] = {
//    var i = 1
//    while (i < values.length) {
//      if values(i) != values(i-1) + 1 then return Some(values(i))
//      i += 1
//    }
//    None
//  }
//
//  println(firstNonConsecutive(List(1,3)))
//}

// refactor to functional programing
object FirstNonConsecutive extends App {
  def firstNonConsecutive(values: Seq[Int]): Option[Int] = {
    values.sliding(2).find{ case Seq(v1, v2)=> v1 != v2 -1}.map(_.last)
  }
  println(firstNonConsecutive(List(1,3)))
}