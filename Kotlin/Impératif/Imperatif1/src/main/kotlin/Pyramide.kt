package org.Rajabi


fun main(args: Array<String>) {
    for (arg: String in args) {
        val height = arg.toInt()
        pyramide(height)
    }
}
    fun pyramide(height: Int){
        for(i in 0..<height){
            val blank= " ".repeat(height -i -1)
            val star= "*".repeat(i*2+1)
            println(blank+star)
        }
    }
