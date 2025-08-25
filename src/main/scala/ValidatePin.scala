/*
https://www.codewars.com/kata/55f8a9c06c018a0d6e000132/scala
ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.

If the function is passed a valid PIN string, return true, else return false.

Examples (Input --> Output)

"1234"   -->  true
"12345"  -->  false
"a234"   -->  false
 */

//object ValidatePin extends App {
//
//  def validatePin(pin: String): Boolean = {
//    if (pin.length == 4 || pin.length == 6) && pin.forall(Character.isDigit) then true
//    else false
//  }
//
//  println(validatePin("a111"))
//}

// replace pin.forall(Character.isDigit) to pin.forall(_.isDigit)
//object ValidatePin extends App {
//
//  def validatePin(pin: String): Boolean = {
//    if (pin.length == 4 || pin.length == 6) && pin.forall(_.isDigit) then true
//    else false
//  }
//
//  println(validatePin("a111"))
//}


//object ValidatePin extends App {

//  def validatePin(pin: String): Boolean = {
//    val pinRegex = "\\d{4}|\\d{6}".r
//    pinRegex.matches(pin)
//  }
//
//  println(validatePin("1111"))
//}

object ValidatePin extends App {

  private val pinRegex = raw"""\d{4}|\d{6}""".r

  def validatePin(pin: String): Boolean = pinRegex.matches(pin)

  println(validatePin("1111"))
}