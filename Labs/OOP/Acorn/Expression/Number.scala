package Expression

class Number (val value: Double) extends Expression {
  def execute = value
  override def toString = value.toString
}

object Number {
  def apply(value: Double) = new Number(value)
}