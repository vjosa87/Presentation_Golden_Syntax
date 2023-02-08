class Voldemort(name: String, hp: Int, level: Int) : Gegner(name, hp, level) {

    // Auflistung & Vererbung der Zauberspruchliste.
    override var listeZauberspruch: List<String> = listOf(
        "Reducio",
        "Confringo",
        "Locomotor Mortis",
        "Petrificus Totalus",
        "Nox",
        "Amnesia",
    )

    // Vererbung der Funktion "Angriff Gegner" & Überprüfung des K.O. Status.
    override fun angriffGegner(held: Helden, listeGegner: MutableList<Gegner>) {
        if (!this.isKo && !held.isKo) {
            var aktuellerZauberspruch = listeZauberspruch.random()
            println("Es wurde der Zauberspruch: $aktuellerZauberspruch ausgewählt")
            println()
            var schaden: Double = this.schadenswert

            when (aktuellerZauberspruch) {

                "Reducio" -> {

                    schaden = 3.0 * schadenswert
                }

                "Confringo" -> {
                    schaden = 1.5 * schadenswert
                }

                "Locomotor Mortis" -> {
                    schaden = 1.8 * schadenswert
                }

                "Petrificus Totalus" -> {
                    schaden = 0.24 * schadenswert
                }

                "Nox" -> {
                    schaden = 0.19 * schadenswert
                }

                "Amnesia" -> {
                    schaden = 0.50 * schadenswert
                }

            }
            when (held.name) {
                "Reducio" -> {
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
