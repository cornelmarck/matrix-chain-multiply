# matrix-chain-multiply
Compute the optimal order of multiplication using dynamic programming. 

- Using java.util.Scanner to process strings

What I learned:
- Java generics and maths really do not get along well. Arithmetic operations like multiply only work on primitive types that must be known at compile-time. A possible solution is 1- subclassing of the generic class 2- define custom number classes and use polymorphism. This is quite convoluted as multiplying matrices of differing numeric types may lead to undefined behaviour. So it is best to stick to a single matrix data type.
