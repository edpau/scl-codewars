import org.scalatest._
import flatspec._


class FNCSpec extends AnyFlatSpec {
  "a simple example" should "return 6" in {
    assertResult(Some(6), "\nInput: Seq(1,2,3,4,6,7,8)") {FirstNonConsecutive.firstNonConsecutive(Seq(1,2,3,4,6,7,8))}
  }

  "a zero example" should "return 0" in {
    assertResult(Some(0), "\nInput: List(-3,-2,0,1,2)") {FirstNonConsecutive.firstNonConsecutive(List(-3,-2,0,1,2))}
  }

  "second item" should "return 5" in {
    assertResult(Some(5), "\nInput: List(3,5,6)") {FirstNonConsecutive.firstNonConsecutive(List(3,5,6))}
  }

  "last item" should "return 6" in {
    assertResult(Some(6), "\nInput: List(3,4,6)") {FirstNonConsecutive.firstNonConsecutive(List(3,4,6))}
  }

  "all sequential" should "return None" in {
    assertResult(None, "\nInput: Seq(1,2,3,4)") {FirstNonConsecutive.firstNonConsecutive(Seq(1,2,3,4))}
  }

  "random positive tests" should "pass" in {
    import scala.util.Random
    def makeTestCase: (Seq[Int], Option[Int]) = { //(values, expected)
      val values = Seq.fill(20)(Random.nextInt(20)).distinct.sorted
      val expected = values.tail.zip(values).collectFirst {case (a, b) if ((a - b) != 1) => a}
      (values, expected)
    }

    LazyList.continually(makeTestCase).distinct.take(10).foreach {
      case (input, expected) =>
        val clue = s"\nInput: $input"
        assertResult(expected, clue) {FirstNonConsecutive.firstNonConsecutive(input)}
    }
  }
}
