# Chapter 7
Kotlin:
- You invoke class constructors like functions—there’s no new keyword in Kotlin
- You don’t waste your time and effort to define fields—that’s an implementation detail that Kotlin takes care of.
- If your focus is on representing data rather than behavior, you can achieve that using data classes, for which Kotlin generates a few conventional methods.

## Objects
Kotlin object expressions are like JavaScript objects and Anonymous Types in C#, although they’re also useful to create instances of anonymous classes, like in Java.
- The internal type of anonymous objects can’t stand as return types to functions or methods.
- The internal type of anonymous objects can’t be used as types of param- eters to functions or methods.
- If they’re stored as properties in classes, they’ll be considered Any type and none of their properties or methods will then be available for direct access.

Anonymous objects can be useful as implementors of interfaces—that is, as anonymous inner classes like in Java.

Kotlin has a predifined way of creating singletons using the object keyword

## Kotlin compile and run commands
kotlinc-jvm ./com/agiledeveloper/util/Util.kt \ ./com/agiledeveloper/use/UseUtil.kt -d Util.jar

kotlin -classpath Util.jar com.agiledeveloper.use.UseUtilKt

## When to choose singletons or top level functions
If a group of functions are high level, general, and widely useful, then place them directly within a package. 
If on the other hand, a few functions are more closely related to each other than the other functions, like f2c() and c2f() are more closely related to each other than to milesToKm(), then place them within a singleton
if a group of functions needs to rely on state, you can place that state along with those related functions in a singleton, although a class may be a better option for this purpose
