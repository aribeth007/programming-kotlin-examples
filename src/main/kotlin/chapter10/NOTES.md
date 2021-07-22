# Functional programming with Lambdas

Imperative Style: what + how

Declarative Style: What, not how

Functional Style: Declarative + higher order functions

Imperative style is familiar, but complex; it’s easier to write, due to our familiarity, but is hard to read.

Functional style is less familiar, but simpler; it’s harder to write, due to our unfamiliarity, but is easier to read.

### Lambda Expressions

A lambda expression is a function with no name whose return type is inferred.

Basic structure

`` { parameter list -> body } ``

Passing lambdas

Receiving lambdas

Using function references

Function returning functions

Lambdas and Anonymous Functions

Lambdas and Closures and Lexical Scoping

Closures
The compiler has to look in the defining scope of the closure—that is, where the body of the closure is defined for a specific variable. 
If it doesn’t find it there, the compiler will have to continue the search in the defining scope of the defining scope, and so on. 
This is called lexical scoping.


Non-Local and Labeled return - TODO
