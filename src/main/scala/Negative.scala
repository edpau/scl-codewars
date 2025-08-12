object Negative extends App {

  //  def makeNegative(n: Int): Int = {
  //    n match
  //      case x if x > 0 => -x
  //      case x => x
  //  }

  // refactor
//  def makeNegative(n: Int): Int = n match {
//    case x if x > 0 => -x
//    case x => x
//  }

  // above pattern matching adds verbosity for a binary decision
  // Doesn’t give me extra power here
  // below is simple
  
  def makeNegative(n: Int): Int = if (n > 0) -n else n 
  println(makeNegative(12))
}
