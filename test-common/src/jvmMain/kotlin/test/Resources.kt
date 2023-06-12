package test

fun Any.resourceStream(path: String) = this::class.java.classLoader!!.getResourceAsStream(path)!!

fun Any.resourceStreamText(path: String) = resourceStream(path).readBytes().decodeToString()
