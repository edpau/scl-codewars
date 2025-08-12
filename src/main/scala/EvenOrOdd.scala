/*
https://www.codewars.com/kata/53da3dbb4a5168369a0000fe/train/scala
Create a function that takes an integer as an argument and returns "Even" for even numbers or "Odd" for odd numbers.
 */

object EvenOrOdd extends App {
  enum Parity(val label: String):
    case Even extends Parity("Even")
    case Odd extends Parity("Odd")

  def evenOrOdd(number: Int): Parity = if number % 2 == 0 then Parity.Even else Parity.Odd

  println(evenOrOdd(12))
}
