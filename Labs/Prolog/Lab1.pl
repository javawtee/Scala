academic(X) :- student(X); instructor(X).
passed(X, Y) :- student(X), taken(X, Y, pass).
studentOf(X, Y) :- student(X), instructor(Y), taken(X, Z, _), teaches(Y, Z).
upperDivisionCSstudent(X) :- student(X), passed(X, cs46a), passed(X, cs46b).
teachesPreReq(X) :- instructor(X), teaches(X, Z),  prerequisite(Z, _).

foreach(X, Y) :- prerequisite(Y, Z), passed(X, Z), student(X).
canTake(X, Y) :- student(X), foreach(X,Y).

student(smith).
student(jones).
student(nguyen).
student(young).
student(sherman).

instructor(pearce).
instructor(godel).
instructor(escher).
instructor(bach).

taken(smith, cs46a, pass).
taken(smith, cs46b, fail).
taken(smith, cs146, pass).
taken(jones, cs46a, pass).
taken(jones, cs46b, pass).
taken(jones, cs146, pass).
taken(nguyen, cs46a, pass).
taken(nguyen, cs46b, pass).
taken(nguyen, cs151, pass).

teaches(pearce, cs152).
teaches(godel, cs151).
teaches(escher, cs146).
teaches(bach, cs46b).
teaches(bach, cs46a).

prerequisite(cs152, cs151).
prerequisite(cs152, cs46b).
prerequisite(cs151, cs46b).
prerequisite(cs146, cs46b).
prerequisite(cs46b, cs46a).

