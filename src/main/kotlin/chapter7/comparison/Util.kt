package chapter7.comparison

fun unitsSupported() = listOf("Metric", "Imperial")

fun precision(): Int = throw RuntimeException("Not implemented yet")

object Temperature {
    fun c2f(c: Double) = c * 9.0/5 + 32
    fun f2c(f: Double) = (f - 32) * 5.0/ 9
}

object Distance {
    fun milesToKm(miles: Double) = miles * 1.609344
    fun kmToMiles(km: Double) = km / 1.609344
}
