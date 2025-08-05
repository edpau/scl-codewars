/*
To complete this Kata you need to make a function multiplyAll/multiply_all which takes an array of integers as an argument. This function must return another function, which takes a single integer as an argument and returns a new array.

The returned array should consist of each of the elements from the first array multiplied by the integer.

Example:

  multiplyAll(Seq(1, 2, 3))(2); // => Seq(2, 4, 6)
You must not mutate the original array.

  Here's a nice Youtube video about currying, which might help you if this is new to you.
  https://www.youtube.com/watch?v=iZLP4qOwY8I
*/

object MultiplyAll extends App {
  
  //  def multiplyAll(a: Seq[Int])(b: Int): Seq[Int] = a.map(x => x * b)

  // refactor
  // xs = a sequence of x’s, “a collection of elements of type x”
  def multiplyAll(xs: Seq[Int])(factor: Int): Seq[Int] =
    xs.map(_ * factor)

  val xs = Seq(1, 2, 3)
  val factor = 2

  //Inline
  println(multiplyAll(xs)(factor)) // List(2, 4, 6)

  // Partial application
  val multiplyBy2 = multiplyAll(xs) // f: Int => Seq[Int]
  println(multiplyBy2(factor)) // List(2, 4, 6)

  // pass empty Seq
  println(multiplyAll(Seq())(2)) // List()
}

