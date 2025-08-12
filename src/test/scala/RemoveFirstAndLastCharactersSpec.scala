import org.scalatest.*, funsuite.*, matchers.should.*, org.scalatestplus.scalacheck.*, org.scalacheck.Shrink

class RemoveFirstAndLastCharactersSpec extends AnyFunSuite with ScalaCheckPropertyChecks with Matchers {

  import RemoveFirstAndLastCharacters.removeChars

  val fixedTests = Table[String, String](
    ("s", "expected"),
    ("eloquent", "loquen"),
    ("country", "ountr"),
    ("person", "erso"),
    ("place", "lac"),
    ("ok", "")
  )

  test("Fixed tests") { forAll(fixedTests) { removeChars(_) shouldBe _ } }

  test("Random tests") {
    def refImpl(s: String): String = s.init.tail
    given Shrink[String] = Shrink.shrinkAny
    forAll("s") { (s: String) =>
      whenever(s.length >= 2) {
        removeChars(s) shouldBe refImpl(s)
      }
    }
  }
}