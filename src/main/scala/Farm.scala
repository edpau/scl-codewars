/*
https://www.codewars.com/kata/54edbc7200b811e956000556/scala
Consider an array/list of sheep where some sheep may be missing from their place. We need a function that counts the number of sheep present in the array (true means present).

For example,

Array(
  true,  true,  true,  false,
  true,  true,  true,  true,
  true,  false, true,  false,
  true,  false, false, true,
  true,  true,  true,  true,
  false, false, true,  true
)
The correct answer would be 17.

Hint: Don't forget to check for bad values like null/undefined
 */

//object Farm extends App {
//  def countSheep(sheep: Array[Boolean]): Int = {
//
//    sheep.count(_ == true)
//
//  }
//
//  println(countSheep(Array(true, true)))
//  println(countSheep(Array(false, false)))
//}

// improve code slightly cleaner idiom
//object Farm extends App {
//  def countSheep(sheep: Array[Boolean]): Int = {
//// or sheep.count(b => b)
//    sheep.count(identity)
//  }
//
//  println(countSheep(Array(true, true)))
//  println(countSheep(Array(false, false)))
//}

/** Counts `Some(true)`; ignores `Some(false)` and `None`.
 *  @note `sheep` must not be null. Use `Option` to represent missing values. */

// model “maybe present” explicitly
object Farm extends App {
  def countSheepOpt(sheep: IterableOnce[Option[Boolean]]): Int = {
    sheep.iterator.count(_.contains(true))
  }

//  println(countSheepOpt(Array(Some(true), None, Some(false))))
//  println(countSheepOpt(List(Some(true), None, Some(false))))
//  println(countSheepOpt(Vector.fill(1000)(Some(true))))
//  println(countSheepOpt(Iterator(Some(true), None, Some(false))))
//  println(countSheepOpt(Seq(Some(true), Some(false))))
//  println(countSheepOpt(LazyList(Some(true), None)))
}

