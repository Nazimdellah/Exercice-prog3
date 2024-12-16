package org.Rajabi

class ValeurIntrouvableException : Exception() {
    override val message: String?
        get() = "La valeur n'a pas été trouvée"


}