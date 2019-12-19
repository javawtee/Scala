object finalWorkSheet {
  println("Welcome to the final Scala worksheet")
  
  def bind[S, T, U](f: S=>Option[T], g: U=>Option[S]): U=>Option[T] = {
  		(u: U) => if(g(u) == None) None else f(g(u).get)
  }
  
  def invert(x: Double): Option[Double] = if (x == 0) None else Some(1/x)
  
  def sqrt(x: Double): Option[Double] = if (x < 0) None else Some(math.sqrt(x))
  
  def invertSqrt = bind(invert, sqrt)
  
  invertSqrt(2)
  
  invertSqrt(100)
  
  invertSqrt(0)
  
  invertSqrt(-1)
}