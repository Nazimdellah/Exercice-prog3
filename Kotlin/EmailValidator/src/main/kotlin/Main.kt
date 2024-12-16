package org.Rajabi

import com.sanctionco.jmail.JMail



fun main() {
    val email = "a.b@ab"

    if (JMail.isValid(email)) {
        // Work with your email string
        println("email is valid")
    }
    else    {
        println("email is invalid")
    }
}