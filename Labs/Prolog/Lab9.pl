transition(state0, C, state1) :-  is_alpha(C).
transition(state0, C, dead) :- is_digit(C).
transition(state1, C, state1) :- is_alpha(C); is_digit(C).
transition(state1, C, dead) :- \+ transition(state1, C, state1)
transition(dead, _, dead).

moves(A, CharList , B) :- [X|Y] = CharList, transition(A, X, B), moves(B, Y, _).
moves(A, [], B).

accept(X) :- string_chars(X, Y), [A|B] = Y, transition(state0, A, Z), moves(Z, Y, _).


