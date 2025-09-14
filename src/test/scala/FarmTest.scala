import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.concurrent.TimeLimits
import org.scalatest.time.SpanSugar._

class FarmTest extends AnyFunSuite
  with Matchers
  with TableDrivenPropertyChecks {

  test("returns 0 when input is empty") {
    Farm.countSheepOpt(List.empty[Option[Boolean]]) shouldBe 0
  }

  test("returns 0 when all are Some(false)") {
    Farm.countSheepOpt(List(Some(false), Some(false))) shouldBe 0
  }

  test("returns 0 when all are None") {
    Farm.countSheepOpt(List(None, None)) shouldBe 0
  }

  test("returns 0 for mixed input with no trues") {
    Farm.countSheepOpt(List(None, Some(false), None)) shouldBe 0
  }

  test("returns 1 when input has a single true") {
    Farm.countSheepOpt(List(Some(true))) shouldBe 1
  }

  test("returns 3 when input has three trues (mixed)") {
    Farm.countSheepOpt(List(Some(true), Some(false), Some(true), None, Some(true))) shouldBe 3
  }

  test("handles different IterableOnce sources") {
    val inputs = Table(
      ("label", "input"),
      ("List", List(Some(true)): IterableOnce[Option[Boolean]]),
      ("Array", Array(Some(true)): IterableOnce[Option[Boolean]]),
      ("Vector", Vector(Some(true)): IterableOnce[Option[Boolean]]),
      ("Iterator", Iterator(Some(true)): IterableOnce[Option[Boolean]]),
      ("LazyList", LazyList(Some(true)): IterableOnce[Option[Boolean]])
    )

    forAll(inputs) { (label, in) =>
      withClue(s"$label: ") {
        Farm.countSheepOpt(in) shouldBe 1
      }
    }
  }

  test("returns correct count for different input scenarios") {
    val inputs = Table(
      ("label", "input", "expected"),
      ("List one true", List(Some(true)), 1),
      ("List all false", List(Some(false)), 0),
      ("List mixed", List(Some(true), None, Some(true)), 2)
    )

    forAll(inputs) { (label, in, expected) =>
      withClue(s"$label: ") {
        Farm.countSheepOpt(in) shouldBe expected
      }
    }
  }

  test("consumes iterator (IterableOnce one-shot)") {
    val it = Iterator(Some(true), None, Some(true))
    Farm.countSheepOpt(it) shouldBe 2
    Farm.countSheepOpt(it) shouldBe 0 // already consumed
  }

  class FarmPerfTest extends AnyFunSuite with Matchers with TimeLimits {

    test("handles 100k elements in reasonable time (no materialization") {
      val bigVec = Vector.fill(100000)(Some(true))
      failAfter(500.millis) {
        Farm.countSheepOpt(bigVec) shouldBe bigVec.size
      }

      val bigInter = Iterator.fill(100000)(Some(true))
      failAfter(500.millis){
        Farm.countSheepOpt(bigInter) shouldBe 100000
      }

    }

  }

}
