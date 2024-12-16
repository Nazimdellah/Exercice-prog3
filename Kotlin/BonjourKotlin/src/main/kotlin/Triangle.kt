package org.Rajabi


fun main(args: Array<String>)
{
if (args.isEmpty()){
    println("provide height")
    return
}

    val height = args[0].toIntOrNull()


    if (height == null || height <= 0){
        println("provide correct height")
        return
    }

    for( i in 1..height){
        for (j in 1..i){
            print("*")
        }
        println()
    }

}