package expression
import value._

trait Expression {
  def execute: Value // to check type of Value
}

