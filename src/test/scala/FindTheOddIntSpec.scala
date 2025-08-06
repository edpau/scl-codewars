import org.scalatest.*, funsuite.*, matchers.should.*
import org.scalatestplus.scalacheck.*, org.scalacheck.{Arbitrary, Gen, Shrink}, scala.util.Random
import FindTheOddInt.findTheOddInt

class FindTheOddIntSpec extends AnyFunSuite with ScalaCheckPropertyChecks with Matchers {
  test("Fixed tests") {
    val fixedTests = Table[Seq[Int], Int](
      ("xs", "expected"),
      (List(20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5), 5),
      (List(1,1,2,-2,5,2,4,4,-1,-2,5), -1),
      (List(20,1,1,2,2,3,3,5,5,4,20,4,5), 5),
      (List(10), 10),
      (List(1,1,1,1,1,1,10,1,1,1,1), 10),
      (List(5,4,3,2,1,5,4,3,2,10,10), 1),
    )
    forAll(fixedTests) { findTheOddInt(_) shouldBe _ }
  }

  test("Random tests") {
    given Shrink[List[Int]] = Shrink.shrinkAny
    val gen: Gen[List[Int]] = for {
      even <- Gen.zip(Arbitrary.arbitrary[Int], Gen.choose(1, 3).map(_ * 2 - 1))
      odds <- Gen.listOf(Gen.zip(Arbitrary.arbitrary[Int], Gen.choose(1, 3).map(_ * 2)))
      seed <- Arbitrary.arbitrary[Int]
    } yield new Random(seed).shuffle(
      (even :: odds).flatMap{ case (x, f) => List.fill(f)(x) }
    )
    forAll((gen, "xs"), minSuccessful(100)) { xs =>
      val y = findTheOddInt(xs)
      withClue(s"returned $y; count % 2:") { xs.count(_ == y) % 2 shouldBe 1 }
    }
  }
}