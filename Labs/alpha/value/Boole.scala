package value

import expression._

class Boole (val value: Boolean) extends Literal {
  override def toString = value.toString
}
object Boole {
   def apply(value: Boolean) = new Boole(value)
}