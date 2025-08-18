/*
// https://www.codewars.com/kata/5390bac347d09b7da40006f6/train/scala
Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013). Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known for almost always capitalizing every word. For simplicity, you'll have to capitalize each word, check out how contractions are expected to be in the example below.

Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.

Example:

Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 */

// capitalize leaves the rest of the characters unchanged (it doesn’t force them to lowercase).
//object JadenCasing extends App {
//  implicit class StringExtensions(s: String) {
//    def toJadenCase = {
//      s.split(" ").map(_.capitalize).mkString(" ")
//    }
//  }
//
//  println("cHaNge cAP iN thE miDDle".toJadenCase)
//}

//after split .head with empty string with crash
//object JadenCasing extends App {
//  implicit class StringExtensions(s: String) {
//    def toJadenCase = {
//      if (s.isEmpty) s
//      else
//        s.split(" ")
//          .map(x => x.head.toUpper + x.tail.toLowerCase)
//          .mkString(" ")
//    }
//  }
//
//  println("".toJadenCase)
//  println(" s bvv".toJadenCase) //after split .head with empty string with crash
//  println("a b c".toJadenCase)
//  println("cHaNge cAP iN thE miDDle".toJadenCase)
//  println("123 ab2c".toJadenCase)
//
//}

// Use a whitespace regex to avoid empty tokens: split("\\s+").
// still cant guard empty string from the start of string
// need .filter(_nonEmpty)
//object JadenCasing extends App {
//  implicit class StringExtensions(s: String) {
//    def toJadenCase = {
//      if (s.isEmpty) s
//      else
//        s.split("\\s+")
//          .filter(_.nonEmpty)
//          .map(x => x.head.toUpper + x.tail.toLowerCase)
//          .mkString(" ")
//    }
//  }
//
//  println("".toJadenCase)
//  println(" s bvv".toJadenCase)
//  println("a b c".toJadenCase)
//  println("cHaNge cAP iN thE miDDle".toJadenCase)
//  println("123 ab2c".toJadenCase)
//
//}

// Even safer (no head on empty, preserves inner empties if you want)
//object JadenCasing extends App {
//  implicit class StringExtensions(s: String) {
//    def toJadenCase = {
//      s.split(" ").map {
//        case "" => ""
//        case w => w.head.toUpper + w.tail.toLowerCase
//      }.mkString(" ")
//    }
//  }
//
//  println("".toJadenCase)
//  println("  s bvv".toJadenCase)
//  println("a b c".toJadenCase)
//  println("cHaNge cAP iN thE miDDle".toJadenCase)
//  println("123 ab2c".toJadenCase)
//}

object JadenCasing extends App {
  implicit class StringExtensions(s: String) {
    def toJadenCase: String = {
      s.split(" ").map { w =>
        w.headOption match {
          case None         => ""
          case Some(first)  => first.toUpper + w.tail.toLowerCase
        }
      }.mkString(" ")
    }
  }

  println("".toJadenCase)
  println("  s bvv".toJadenCase)
  println("a b c".toJadenCase)
  println("cHaNge cAP iN thE miDDle".toJadenCase)
  println("123 ab2c".toJadenCase)
}


// Extra
// Use Locale.ROOT when changing case to avoid surprises (e.g., Turkish i).
//Hyphenated words: "jaden-smith" → currently "Jaden-smith" (is that desired?).