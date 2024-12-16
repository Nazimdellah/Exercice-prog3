Exercice 1
Code à analyser :

kotlin
Copier le code
fun uneFonction() {
    try {
        // du code…
    } catch (e: Exception) {
        println("Erreur : $e")
    } catch (a: ArrayIndexOutOfBoundsException) {
        println("Erreur : $a")
    }
}
Réponse : Non ❌

Pourquoi :

Ordre des catch est incorrect. En Kotlin (comme en Java), les exceptions sont capturées de manière hiérarchique. Cela signifie que ArrayIndexOutOfBoundsException est une sous-classe de Exception. Si vous placez le catch pour Exception avant celui pour ArrayIndexOutOfBoundsException, cette dernière ne sera jamais capturée, car Exception attrapera toutes les exceptions (y compris ArrayIndexOutOfBoundsException).

Correction : Il faut interchanger les blocs catch pour que l'exception plus spécifique soit capturée avant la classe de base Exception.

Code corrigé :

kotlin
Copier le code
fun uneFonction() {
    try {
        // du code…
    } catch (a: ArrayIndexOutOfBoundsException) {
        println("Erreur : $a")
    } catch (e: Exception) {
        println("Erreur : $e")
    }
}
Exercice 2
Code à analyser :

kotlin
Copier le code
fun calculerPoidsSupernova() {
    try {
        // calculs compliqués...
    } catch (e: NumberFormatException) {}
}
Réponse : Non ❌

Pourquoi :

Le bloc catch est vide. Capturer une exception sans en faire quoi que ce soit (c'est-à-dire sans la traiter ou afficher un message) est une mauvaise pratique. Cela masque l'erreur sans fournir de retour d'information, ce qui rend le débogage difficile et peut entraîner des comportements inattendus dans l'application.

Si une exception est capturée, il est important d’en faire quelque chose, au minimum en loggant l'exception ou en affichant un message pour l'utilisateur ou le développeur.

Correction : Vous devriez au moins enregistrer l'exception ou afficher un message pour comprendre ce qui s'est passé. Par exemple :

kotlin
Copier le code
fun calculerPoidsSupernova() {
    try {
        // calculs compliqués...
    } catch (e: NumberFormatException) {
        println("Erreur de format : ${e.message}")
    }
}
Ou, si vous ne voulez pas afficher d'information, il peut être pertinent de relancer l'exception :

kotlin
Copier le code
fun calculerPoidsSupernova() {
    try {
        // calculs compliqués...
    } catch (e: NumberFormatException) {
        throw e // Relance l'exception
    }
}
Mais le plus important est de ne pas ignorer l'exception sans rien faire.