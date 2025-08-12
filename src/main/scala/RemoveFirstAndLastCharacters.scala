/*
https://www.codewars.com/kata/56bc28ad5bdaeb48760009b0/train/scala
Remove First and Last Character

Task

Your goal is to write a function that removes the first and last characters of a string. You're given one parameter, the original string.

Important: Your function should handle strings of any length ≥ 2 characters. For strings with exactly 2 characters, return an empty string.

Examples

'eloquent' --> 'loquen'
'country'  --> 'ountr'
'person'   --> 'erso'
'ab'       --> '' (empty string)
'xyz'      --> 'y'
Requirements

The input string will always have at least 2 characters
For strings with exactly 2 characters, return an empty string
For strings with 3 or more characters, remove the first and last character
The function should handle strings containing letters, numbers, and special characters
Test Cases

Your solution will be tested against:

Basic functionality with common words
Edge cases with 2-character and 3-character strings
Strings containing numbers and special characters
Random test cases of varying lengths
 */

//object RemoveFirstAndLastCharacters extends App {
//  def removeChars(s: String): String = {
//    s match
//      case x if (x.length > 2) => x.substring(1,x.length-1)
//      case x if (x.length == 2) => ""
//      case _ => throw new IllegalArgumentException("Input string must have length >= 2")
//  }
//
//  println(removeChars("ss"))
//}
// above is verbose and overstructured for a 1-line transformation

// refactor
//object RemoveFirstAndLastCharacters extends App {
//  def removeChars(s: String): String = {
//    if s.length <= 2 then "" else s.substring(1, s.length-1)
//  }
//}

// refactor
object RemoveFirstAndLastCharacters extends App {
  def removeChars(s: String): String = {
    s.drop(1).dropRight(1)
  }

  println(removeChars("abc"))
}
