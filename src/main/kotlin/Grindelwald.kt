class Grindelwald(name: String, hp: Int, level: Int) : Gegner(name, hp, level) {

    // TODO Liste Zauberkraft
    override var listeZauberspruch: List<String> = listOf(
        "Ratzeputz",
        "Waddiwasi",
        "Confringo",
        "Impervius ",
        "Tarantallegra",
        "Spuck Schnecken"
    )

    //TODO Angriff des Gegners // (override?!)
    override fun angriffGegner(held: Helden, listeGegner: MutableList<Gegner>) {
        if (!this.isKo && !held.isKo) {
            var aktuellerZauberspruch = listeZauberspruch.random()
            println("Es wurde der Zauberspruch: $aktuellerZauberspruch ausgewählt")
            println()
            var schaden: Double = this.schadenswert

            when (aktuellerZauberspruch) {

                "Ratzeputz" -> {

                    schaden = 2.5 * schadenswert
                }

                "Waddiwasi" -> {
                    schaden = 1.5 * schadenswert
                }

                "Confringo" -> {
                    schaden = 2.8 * schadenswert
                }

                "Impervius " -> {
                    schaden = 2.4 * schadenswert
                }

                "Tarantallegra" -> {
                    schaden = 1.5 * schadenswert
                }

                "Spuck Schnecken" -> {
                    schaden = 0.50 * schadenswert
                }

            }
            when (held.name) {
                "Ratzeputz" -> {
                    schaden *= 3.0
                }

            }

            // TODO println
            println("${this.name} greift ${held.name} mit $aktuellerZauberspruch für ${schaden.toInt()} an.")

            held.loseHp(schaden.toInt())
        } else if (held.hp <= 0) {
            println("Angriff kann nicht ausgeführt werden, Held ${held.name} hat bereits verloren.")
        }
    }
}
