import MultiplyAll.multiplyAll
import org.scalatest.flatspec.AnyFlatSpec

class MultiplyAllSpec extends AnyFlatSpec {

  private def doTest(xs: Seq[Int], m: Int, expected: Seq[Int]): Unit =
    assert(multiplyAll(xs)(m) == expected, s"for multiplyAll($xs)($m)")

  "multiplyAll" should "work for trivial 1 element sequence" in {
    doTest(Seq(1), 2, Seq(2))
  }

  it should "work for 1D sequences" in {
    doTest(-3 to 3, -2, 6 to -6 by -2)
  }

  it should "work for empty sequences" in {
    doTest(Nil, 10, Nil)
  }

  it should "work for random sequences" in {
    import util.Random

    def makeTestCase: (Seq[Int], Int, Seq[Int]) =
      val m = Random.between(-100, 101)
      val xs = Seq.fill(Random.nextInt(20))(Random.between(-500, 501))
      (xs, m, xs map (_ * m))

    Iterator.fill(100)(makeTestCase) foreach doTest
  }
  
}
