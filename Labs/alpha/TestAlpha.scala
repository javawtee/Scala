import expression._
import value._

object TestAlpha extends App {
   var exp: Expression = Sum(Number(42), Product(Number(3.14), Number(2.71)))
   println("value = " + exp.execute)
   exp = Product(Number(2), Product(Number(3), Number(5)))
   println("value = " + exp.execute)
   exp = And(Boole(true), And(Boole(false), Boole(true)))
   println("value = " + exp.execute) 
   exp = And(Boole(true), Number(1.9))
   println("value = " + exp.execute)
}