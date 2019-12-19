package expression
import value.Value

trait Literal extends Value with Expression {
  def execute = this
}