/*
https://www.codewars.com/kata/57eadb7ecd143f4c9c0000a3/scala

Write a function to convert a name into initials. This kata strictly takes two words with one space in between them.

The output should be two capital letters with a dot separating them.

It should look like this:

Sam Harris => S.H

patrick feeney => P.F

 */

//object AbbrevName extends App {
//  def abbrevName(name: String): String ={
//    if (name == null || name.trim.split(" ").length !=2)
//      throw new IllegalArgumentException("Name must contain exactly two words")
//    val list = name.split(" ")
//    val firstName = list(0)
//    val lastName = list(1)
//
//    s"${firstName.head.toUpper} . ${lastName.head.toUpper}"
//  }
//
//  println(abbrevName("Peter Pan"))
//}

// Refactor
object AbbrevName extends App {
  def abbrevName(name: String): String ={
    name.split(" ").map(_.head.toUpper).mkString(".")
  }

  println(abbrevName(""))
}
