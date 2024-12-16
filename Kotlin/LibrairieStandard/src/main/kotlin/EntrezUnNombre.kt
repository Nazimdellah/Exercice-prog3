package org.Rajabi
fun main() {
    var question: String = "Veuillez entrer un nombre :"
    println(question)
    while (true) {

        val input = readln()
        try {
            val reponse = input.toInt()
            println("Merci, votre nombre est $reponse ")
            break
        } catch (e: NumberFormatException) {
            println("Ceci n’est pas un nombre, veuillez entrer un nombre :")
        }
    }
}