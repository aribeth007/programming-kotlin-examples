package chapter7.comparison

import  chapter7.comparison.Temperature as MyFancyTempName

fun main() {
    // usage of top level function
    chapter7.comparison.unitsSupported()
    unitsSupported()

    Distance.milesToKm(100.0)
    MyFancyTempName.c2f(23.0)
}