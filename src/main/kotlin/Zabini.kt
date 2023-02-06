// TODO Vererbung
class Zabini(name: String, hp: Int, level: Int) : Gegner(name, hp, level) {

    // TODO Liste Zauberkraft
    override var listeZauberspruch: List<String> = listOf(
        "Aguamenti",
        "Alohomora",
        "Aparecium",
        "Diffindo",
        "Sectumsempra",
        "Ferula"
    )

    //TODO Angriff des Gegners // (override?!)
    override fun angriffGegner(held: Helden, listeGegner: MutableList<Gegner>) {
        if (!this.isKo && !held.isKo) {
            var aktuellerZauberspruch = listeZauberspruch.random()
            println("Es wurde der Zauberspruch: $aktuellerZauberspruch ausgewählt")
            println()
            var schaden: Double = this.schadenswert

            when (aktuellerZauberspruch) {

                "Aguamenti" -> {

                    schaden = 1.0 * schadenswert
                }

                "Alohomora" -> {
                    schaden = 1.5 * schadenswert
                }

                "Aparecium" -> {
                    schaden = 1.5 * schadenswert
                }

                "Diffindo" -> {
                    schaden = 0.50 * schadenswert
                }

                "Sectumsempra" -> {
                    schaden = 0.80 * schadenswert
                }

                "Ferula" -> {
                    schaden = 2.50 * schadenswert
                }

            }
            when (held.name) {
                "Aguamenti" -> {
                    schaden *= 3.0
                }

            }

            // TODO println
            println("${this.name} greift ${held.name} mit $aktuellerZauberspruch für ${schaden.toInt()} an.")

            held.loseHp(schaden.toInt())
        } else if (held.hp <= 0) {
            println("Angriff kann nicht ausgeführt werden, Held ${held.name}hat bereits verloren.")
        }
    }

}
