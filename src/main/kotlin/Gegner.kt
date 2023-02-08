// Offene Klasse für "Gegner" & Ermittlung vom Schadenswert.
open class Gegner(var name: String, var hp: Int, var level: Int) {

    var schadenswert: Double = 0.5 * level
    var isKo: Boolean = false

    // Offene Variable für "Zauberspruchliste".
    open var listeZauberspruch: List<String> = listOf()

    // Offene Funktion für "Angriff der Gegner".
    open fun angriffGegner(held: Helden, listeGegner: MutableList<Gegner>) {}

    companion object {

        // Funktion von Health Points Lose". Abzug von Gesundheitspunkten ermitteln.
        fun hpLose(gegner: Gegner, lost: Int) {

            gegner.hp -= lost

            if (gegner.hp <= 0) {
                gegner.isKo = true
                println("${gegner.name} hat verloren.")

            } else {
                println("${gegner.name} hat noch ${gegner.hp} Gesundheitspunkte.")
            }
            println("---")
        }
    }
}


