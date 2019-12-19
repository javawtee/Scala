add(X, zero, X).
add(X, inc(W), Z) :- add(X, W, R), Z = inc(R).

mul(_, zero, zero).
mul(X, inc(W), Z) :- mul(X, W, R), add(X, R, Z).

exp(_, zero, inc(zero)).
exp(X, inc(W), Z) :- exp(X, W, R), mul(X, R, Z).

less(zero, _).
less(inc(X), inc(Y)) :- less(X, Y).

eval(num(X), X).
eval(sum(X, Y), Z) :-  eval(X, X1), eval(Y, Y1), Z is X1 + Y1.
eval(prod(X, Y), Z) :- eval(X, X1), eval(Y, Y1), Z is X1 * Y1.

