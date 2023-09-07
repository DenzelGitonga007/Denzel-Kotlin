fun main() {
//    var n: Int = 10
/*    var l: Long = 1000001L
   var d: Double = 3.14
   var b: Boolean = false
   var f: Float = 3.122324F
   var s: String = "Denzel"
   var c: Char = 'A' */

//    print("$n, $l, $d, $f, $b, $s, $c")

//    TypeInference
//    var n = 10
//    print(n)

//    Strings
//    var name = "Denzel"
//    println(name.uppercase())
//    println(name[2])
//    print(name.lowercase())

//    var name = "Denzel"
//    var age = 21
//
//    val msg = "$name is $age years old"
//
//    println(msg)

//    Multiline string

    var email = """
        Hi %s
        How do you do?
    """.trimIndent()

    print(email.format("Denzel"))

}