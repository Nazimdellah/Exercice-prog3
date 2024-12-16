package org.Rajabi

import java.io.File

fun main(){
      println("entre le nom du fichier")
createfile()
println("le fichier a ete cree")


}


fun createfile(){
    val name : String = readln()
    val filename = "$name.txt"
    val file = File(filename)
    file.createNewFile()
    file.writeText("Arman Rajabi")
}


fun infofile(){
    val fileName = "info"
    val file= File(fileName)
    file.createNewFile()
    file.writeText("Arman Rajabi")
}