package expression

import value._

class And(val operand1: Expression, val operand2: Expression) extends Expression {
  def execute = {
    // short circuit
    val arg1 = operand1.execute
    if(!arg1.isInstanceOf[Boole]) throw new Exception("input a must be Boole")
    if(!arg1.asInstanceOf[Boole].value) arg1 // since a is false so that a && b ==> false without checking b
    else {
      val arg2 = operand2.execute
      if(!arg2.isInstanceOf[Boole]) throw new Exception("input b must be Boole")
      arg2
    }
  }
}

object And {
  def apply(op1: Expression, op2: Expression) = new And(op1, op2)
}