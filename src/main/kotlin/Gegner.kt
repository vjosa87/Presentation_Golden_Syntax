// TODO Gegner class
open class Gegner(var name: String, var hp: Int, var level: Int) {

    var schadenswert: Double = 0.5 * level
    var isKo: Boolean = false

    // TODO Angriffsliste Gegner
    open var listeZauberspruch: List<String> = listOf()

    // TODO Angriffsliste
    open fun angriffGegner(held: Helden, listeGegner: MutableList<Gegner>) {}

    companion object {
        // TODO Gesundheitspunkte abziehen
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


