package org.Rajabi

fun repete(n:Int, nombreFois: Int) {
var number : Int = 1
    for (i in 1..n) {
        repeat(nombreFois)
    {
        print("$number,")
    }
    number++
}

}


fun main(){
    val test1 = repete(4, 3 )
    val test2 = repete(10,2)

    println("$test1 \n")

}