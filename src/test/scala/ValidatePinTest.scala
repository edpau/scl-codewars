import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ValidatePinTest extends AnyFunSuite
  with Matchers
  with ScalaCheckDrivenPropertyChecks {

  test("accepts exactly 4 or 6 digits") {
    ValidatePin.validatePin("1234") shouldBe true
  }

  test("reject pins with length other than 4 or 6") {
    val cases = List(
      "1",
      "12",
      "123",
      "12345",
      "1234567",
      "00000000"
    )

    cases.foreach { pin =>
      withClue(s"\nInput\n pin = \"$pin\"") {
        ValidatePin.validatePin(pin) shouldBe false
      }
    }
  }

  test("reject empty and whitespace-only strings") {
    val cases = List("", " ", "   ", "\t", "\n")
    cases.foreach { pin =>
      withClue(s"pin='$pin'") {
        ValidatePin.validatePin(pin) shouldBe false
      }
    }
  }

  test("reject pins containing non-digit") {
    val cases = List("123x", "x123", "12.4", "12-4", " 234", "@123", "123\n")
    cases.foreach { pin =>
      withClue(s"pin='$pin'") {
        ValidatePin.validatePin(pin) shouldBe false
      }
    }
  }

  test("any 4 or 6 ASCII digits pass; others fail") {
    val four = Gen.listOfN(4, Gen.numChar).map(_.mkString)
    val six = Gen.listOfN(6, Gen.numChar).map(_.mkString)
    val bad = Gen.asciiStr.suchThat(s => s.length != 4 && s.length != 6)

    forAll(Gen.oneOf(four, six)) { pin =>
      withClue(s"pin='$pin'") {
        ValidatePin.validatePin(pin) shouldBe true
      }
    }
    forAll(bad) { s =>
      withClue(s"s='$s'") {
        ValidatePin.validatePin(s) shouldBe false
      }
    }
  }

}
