package org.Rajabi

fun main(){
val intval : Int = 42
    val tofloat: Float = intval.toFloat()
    println("int $intval to float = $tofloat")


    val Doubleval : Double = 42.9
    val toint : Int = Doubleval.toInt()
    println("double $Doubleval to int = $toint")
    //ca arrondie les chiffres au decimal plus petit


    val stringval : String = "98"
    val toInt : Int = stringval.toInt()
    println("string $stringval to int = $toInt")
    //ca fait un erreur si il ya dautre chose que des chiffres


    val valint : Int = 970
    val tostr : String = valint.toString()
    println("int $valint to string = $tostr")


    val floatval: Float = 123.546f
    val todouble: Double = floatval.toDouble()
    println("flaot $floatval to double = $todouble")

}