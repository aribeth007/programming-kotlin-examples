# Type Safety to Save the Day

#Notes

---

 Any And Nothing Clases
 ----------------------
 * Any is the equivalent of java's Object class
 * Kotlin equivalent of void is Unit. Nothing class represents nothing at all.

Nullabe References
-----------------------
* Kotlin as special nullable and not nullable types
* Each data type can be marked as nullable or not nullable using ?

Elvis Operator

?: - wil return the left side if not null otherwise will evaluate and return the 
right side of the expression

Not null assertion operator

!! - Will override the need for a null check when a nullable type is used

````
return name!!.reversed().toUpperCase()
````

Type Checking and Casting
-------------------------

is / !is - operator for checking if an object is of a specific type

Smart cast

````
    other is Animal2 && age == other.age
````

Explicit cast

as / as? - checks for a specific type and cast to that type or throws and error is not 
            / check for a specific type and casts to that or returns null


Notes:
* Use smart casts as much as possible.
* Use safe cast only when smart cast isn’t an option.
* Use unsafe cast if you want to see the application crash and burn.

Type Invariance

Covariance

Reified Type Parameters - tp
 


