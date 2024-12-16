package org.Rajabi

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    var count = 3
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, $name! J'ai $count counter")

    var tableau: Array<String> = arrayOf("one", "two" ,"three")
    for (s: String in tableau){
        println(s)

    }
            for (i in 1 .. 5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
        Bidon()
    }



}

fun Bidon() {
    var j: Int = 1
    var k: Float = 3.4F
    var l: String = "Bn"
}
