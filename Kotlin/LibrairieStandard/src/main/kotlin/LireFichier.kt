package org.Rajabi

import java.io.File

fun main(args: Array<String>){


    var file1 : String= args[0]
    var file2 : String = args[1]
    var fichier: File = File(file1)
    var fichier1: File = File(file2)
    if (fichier.exists()){
        try{
            var list1: List<String> = fichier.readLines()
            println(list1)
            var devider : String = "-----------------------------------------------------------"
            println(devider)
            var list2 : List<String> = fichier1.readLines()
            println(list2)
        } catch (e: Exception){
            println()
        }


    }

}