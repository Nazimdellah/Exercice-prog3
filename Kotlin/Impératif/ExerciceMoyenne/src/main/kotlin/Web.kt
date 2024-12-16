package org.Rajabi

import com.sun.org.apache.bcel.internal.util.Args
import org.jsoup.Jsoup

fun main(args: Array<String>){
    val url = args[0]
    val document = Jsoup.connect(url).get()
    println(document.html())
}
