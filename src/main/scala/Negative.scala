/*
https://www.codewars.com/kata/55685cd7ad70877c23000102/scala
In this simple assignment you are given a number and have to make it negative. But maybe the number is already negative?

Examples

Negative.makeNegative(1)  // return -1
Negative.makeNegative(-5) // return -5
Negative.makeNegative(0)  // return 0
Notes

The number can be negative already, in which case no change is required.
Zero (0) is not checked for any specific sign. Negative zeros make no mathematical sense.
 */

object Negative extends App {

  //  def makeNegative(n: Int): Int = {
  //    n match
  //      case x if x > 0 => -x
  //      case x => x
  //  }

  // refactor
//  def makeNegative(n: Int): Int = n match {
//    case x if x > 0 => -x
//    case x => x
//  }

  // above pattern matching adds verbosity for a binary decision
  // Doesn’t give me extra power here
  // below is simple
  
  def makeNegative(n: Int): Int = if (n > 0) -n else n 
  println(makeNegative(12))
}
