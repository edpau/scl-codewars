/*
https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/train/scala
This time no story, no theory. The examples below show you how to write function accum:

Examples:

accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"
The parameter of accum is a string which includes only letters from a..z and A..Z.
 */

// learn .zipWithIndex on https://stackoverflow.com/questions/2213323/how-can-i-use-map-and-receive-an-index-as-well-in-scala
//object Mumbling extends App {
//  def accum(s: String): String = {
//    s.split("").zipWithIndex.map { case (element, index) =>
//      val temp = element.toUpperCase
//      val temp2 = (1 to index).map(_ => element.toLowerCase).mkString("")
//      temp + temp2
//    }.mkString("-")
//  }
//
//  println(accum("ab")) //A-Bb
//}

// Replaced s.split("") with s.toList (avoids leading empty string).
//object Mumbling extends App {
//  def accum(s: String): String = {
//    s.toList.zipWithIndex.map { case (element, index) =>
//      val temp = element.toUpper
//      val temp2 = (0 until index).map(_ => element.toLower).mkString("")
//      temp + temp2
//    }.mkString("-")
//  }
//
//  println(accum("abCD")) //A-Bb
//  println(accum(""))
//  println(accum("  a")) //  -  -Aaa need to improve??
//  println(accum("abb"))
//  // any more edge case?
//}

// no need s.split("") or s.toList
// replace val temp2 = (0 until index).map(_ => element.toLower).mkString("") to val tail = c.toLower.toString.repeat(i)
object Mumbling extends App {
  def accum(s: String): String = {
    s.zipWithIndex.map { case (c, i) =>
      val upper = c.toUpper.toString
      val repeatedLower = c.toLower.toString.repeat(i)
      upper + repeatedLower
    }.mkString("-")
  }
}