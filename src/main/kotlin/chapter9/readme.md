# Chapter 9 - Extension Through Delegation

Kotlin supports both inheritance and delegation.

The first can lead to tight coupling and is inflexible, 
while the latter is more flexible but lacks support in most OO languages such as Java.

###When to Choose Delegation over Inheritance?
Both delegation and inheritance are useful, but you have to decide when one is a better choice than the other.
#####Inheritance: 
- use if you want an object of a class to be used in place of an object of another class
#####Delegation: 
- use if you want an object of a class to simply make use of an object of another class

If delegation is the right choice for your design, you’ll have to write a lot of duplicated code 
in languages like Java. That leads to bloated code that can be hard to maintain. 

Kotlin uses a better, declarative approach to delegation—you concisely convey your intent, and the compiler runs off to generate the necessary code.

###Designing with Delegates

see example [here](ExtensionThroughDelegation.kt)

###Delegating variables and properties

see examples [here](DelegatingVariablesAndProperties.kt)

###Built-in Standard Delegates
#####The Lazy delegate: 
- useful to defer creating objects or executing computations until the result is truly needed
#####The Observable delegate: 
- useful to observe/monitor changes to the value or property
#####The Vetoable delegate: 
- can be used to reject changes to properties based on some rules/business logic
- returns a boolean result: true means accept the change, false means reject.

see examples for each [here](BuiltInStandardDelegates.kt)
