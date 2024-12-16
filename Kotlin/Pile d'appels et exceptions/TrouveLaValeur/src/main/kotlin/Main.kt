package org.Rajabi

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    try {
        trouveru(arrayOf("10"))
    } catch (e: ValeurIntrouvableException) {
        println(e.message)
    }

}

fun trouveru(choix: Array<String>): String {
    val number: String = valeur(choix)
    println("La valeur est $number")
    return number
}

fun valeur(choix: Array<String>): String {
    // Compare the first element of the array (choix[0]) instead of the entire array
    return when (choix[0]) {
        "1" -> "Un"
        "2" -> "Deux"
        "3" -> "Trois"
        "4" -> "Quatre"
        "5" -> "Cinq"
        else -> {
            throw ValeurIntrouvableException()
        }
    }
}

