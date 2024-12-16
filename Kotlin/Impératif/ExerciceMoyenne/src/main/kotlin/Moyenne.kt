package org.Rajabi



fun creeTableauAleatoire(n: Int): Array<Int> {

   val table = Array(n){(0..100).random()}
    return(table)
}
fun calculator(array: Array<Int>){
val sum = array.sum()
    val average = array.average()
    val min = array.min()
    val max= array.max()
    println("Sum: $sum")
    println("Average: $average")
    println("Min: $min")
    println("Max: $max")

}



fun main(){
calculator(creeTableauAleatoire(2))

}