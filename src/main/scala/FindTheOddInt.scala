/*
Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.

Examples

[7] should return 7, because it occurs 1 time (which is odd).
[0] should return 0, because it occurs 1 time (which is odd).
[1,1,2] should return 2, because it occurs 1 time (which is odd).
[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).

 */

//  imperative solution
//object FindTheOddInt extends App {
//  def findTheOddInt(xs: Seq[Int]): Int = {
//    val sorted = xs.sorted.toVector
//
//    var i = 0
//
//    while (i < sorted.length) {
//      val current = sorted(i)
//      var count = 0
//
//      while (i < sorted.length && sorted(i) == current) {
//        count += 1
//        i += 1
//      }
//
//      if (count % 2 != 0) return current
//
//    }
//
//    throw new IllegalArgumentException("No odd-count element found")
//  }
//
//  println(findTheOddInt(Seq(1, 2, 1)))
//}

// Functional Version
object FindTheOddInt extends App {
  def findTheOddInt(xs: Seq[Int]): Int = {
    xs.groupBy(identity)
      .collectFirst{case (num, list) if (list.size % 2 != 0) => num }
      .getOrElse(throw new IllegalArgumentException("No odd-count element"))
  }

  println(findTheOddInt(Seq(1, 2, 1)))
}
