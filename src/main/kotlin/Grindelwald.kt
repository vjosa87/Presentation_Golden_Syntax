class Grindelwald(name: String, hp: Int, level: Int) : Gegner(name, hp, level) {

    // Auflistung & Vererbung der Zauberspruchliste.
    override var listeZauberspruch: List<String> = listOf(
        "Ratzeputz",
        "Waddiwasi",
        "Confringo",
        "Impervius ",
        "Tarantallegra",
        "Spuck Schnecken"
    )

    // Vererbung der Funktion "Angriff Gegner" & Überprüfung des K.O. Status.
    override fun angriffGegner(held: Helden, listeGegner: MutableList<Gegner>) {
        if (this.isKo) {
            println("Der Gegner Grindelwald ist K.O.!")
        } else {
            var aktuellerZauberspruch = listeZauberspruch.random()
            println("Es wurde der Zauberspruch: $aktuellerZauberspruch ausgewählt")
            println()
            var schaden: Double = this.schadenswert

            when (aktuellerZauberspruch) {

                "Ratzeputz" -> {
                    schaden = 3.0 * schadenswert
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

            println("${this.name} greift ${held.name} mit $aktuellerZauberspruch für ${schaden.toInt()} an.")

            held.loseHp(schaden.toInt())
        }
    }
}
