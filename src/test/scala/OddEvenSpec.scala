import org.scalatest.flatspec.AnyFlatSpec
import OddOrEven.oddOrEven

class OddEvenSpec extends AnyFlatSpec {
  "oddOrEven" should "pass basic tests" in {
    val testCases = Seq(
      (Seq(0, 1, 2), "odd"),
      (Seq(0, 1, 3), "even"),
      (Seq(1023, 1, 2), "even")
    )

    testCases.foreach {
      (xs, expected) =>
        assertResult(expected, s"\nInput:\n xs = $xs")(oddOrEven(xs))
    }
  }

  it should "pass random tests" in {
    import scala.util.Random

    def makeTestCase: (Seq[Int], String) =
      val xs = Seq.fill(Random.between(1, 20))(Random.between(-100, 101))
      (xs, if xs.sum % 2 == 0 then
        "even"
      else
        "odd")

    Seq.fill(100)(makeTestCase).foreach {
      (xs, expected) =>
        assertResult(expected, s"\nInput:\n xs = $xs")(oddOrEven(xs))
    }
  }
}
