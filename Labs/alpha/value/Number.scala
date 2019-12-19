package value

import expression._

class Number(val value: Double) extends Literal {
  override def toString = value.toString
}

object Number {
  def apply(value: Double) = new Number(value)
}