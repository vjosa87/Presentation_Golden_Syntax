//Klasse Helden
open class Helden(
    var name: String,
    var hp: Int,
    var level: Int,
) {
    //Schadenswerte ermitteln
    var schadenswerte: Double = 1.5 * level
    var isKo: Boolean = false

    fun loseHp(lost: Int) {

        this.hp -= lost

        if (this.hp <= 0) {
            this.isKo = true
            println("$name hat keine Gesundheitspunkte mehr übrig")
        } else {
            println("$name hat noch $hp übrig")
            println("---")
        }
    }

    //Zaubersprüche und Angriff
    open var listeZauberspruch: MutableList<String> = mutableListOf()
    open fun angriffHelden(gegner: Gegner) {}
}
