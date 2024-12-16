Question : Les deux méthodes donnent-elles le même résultat ?
Réponse : Non ❌

Les deux méthodes lireDesFichiersFor() et lireDesFichiersTryFor() ne donnent pas le même résultat, bien que les deux aient pour but de lire une série de fichiers (de 1.txt à 9.txt) et de capturer l'exception FileNotFoundException si un fichier n'existe pas. Leur différence réside dans l'emplacement du bloc try-catch.

Explication détaillée des deux méthodes :
1. Méthode lireDesFichiersFor() :
kotlin
Copier le code
fun lireDesFichiersForTry() {
    for (i in 1 until 10) {
        try {
            lireFichier("$i.txt")
        } catch (e: FileNotFoundException) {
            println("fichier n'existe pas")
        }
    }
}
Comportement de cette méthode :
Essaye de lire chaque fichier individuellement.
Pour chaque fichier, elle tente d'exécuter lireFichier("$i.txt") dans le bloc try.
Si un fichier n'existe pas (et génère une FileNotFoundException), l'exception est capturée et un message est imprimé ("fichier n'existe pas").
Chaque erreur est traitée individuellement : si un fichier n'est pas trouvé, l'exception est capturée pour ce fichier spécifique, et la boucle continue pour les autres fichiers.
Exemple de comportement :
Si 3.txt et 7.txt n'existent pas :

rust
Copier le code
fichier n'existe pas
fichier n'existe pas
Cela signifie que les erreurs de 3.txt et 7.txt sont capturées, mais la boucle continue pour tenter de lire 4.txt, 5.txt, etc.

2. Méthode lireDesFichiersTryFor() :
kotlin
Copier le code
fun lireDesFichiersTryFor() {
    try {
        for (i in 1 until 10) {
            lireFichier("$i.txt")
        }
    } catch (e: FileNotFoundException) {
        println("fichier n'existe pas")
    }
}
Comportement de cette méthode :
Essaye de lire tous les fichiers d'un coup, en plaçant toute la boucle for dans le même bloc try.
Si un seul fichier génère une FileNotFoundException, cette exception est capturée une seule fois pour l'ensemble de la boucle.
La boucle s'arrête immédiatement dès qu'une exception est lancée (au lieu de continuer pour les autres fichiers).
Exemple de comportement :
Si 3.txt n'existe pas :

rust
Copier le code
fichier n'existe pas
Et la lecture des fichiers suivants s'arrête. Aucun fichier après 3.txt n'est tenté, même si 4.txt, 5.txt, etc., existent.

Différence clé entre les deux méthodes :
lireDesFichiersForTry() gère chaque fichier individuellement et continue d'essayer les autres fichiers même si un fichier échoue.
lireDesFichiersTryFor() arrête la boucle dès qu'une exception est levée pour un fichier. Elle ne tente pas les fichiers suivants après une erreur.