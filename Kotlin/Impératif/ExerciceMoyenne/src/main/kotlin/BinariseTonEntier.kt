package org.Rajabi



fun converter(input: String){
    val number = input.toInt()
    val binary = number.toString(2)
    println(binary)
}

fun main(){
    val input = "23"
    converter(input)
}
