# automatonStringMatch

This implements the string matching algorithm discussed in Intro to Algorithms 3rd eddition page995. 

Given state p and input character c, the next state is calculated as delta(q, c).

Define function sigma(x) = max{k: Pk is a postfix of x}  (p is the string to create automaton for)

THM:  delta(q, c) = sigma(  p.substr(0, q + 1)  + c )

The getTransFunc precomputes the values of delta for all possible combinations of q and c. 


  
