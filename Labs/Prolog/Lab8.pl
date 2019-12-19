implements(expression, funcall).
implements(expression, identifier).
implements(specialForm, conditional).
implements(literal, boole).

extends(expression, specialForm).
extends(expression, literal).
extends(value, literal).

has(conditional, condition, expression).
has(conditional, consequent, expression).
has(conditional, alternative, expression).
has(funcall, operator, identifier).
has(funcall, operands, expression).

arrow(X, Y) :- extends(Y, X); implements(Y, X); has(Y, _, X).
depends(X, X).
depends(X, Y) :- arrow(X, Y).
depends(X, Y) :- arrow(X, Z), depends(Z, Y).