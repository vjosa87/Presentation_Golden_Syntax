open class Hermine(name: String, hp: Int, level: Int) : Helden(name, hp, level) {

    // TODO Zauberkräfte
    override var listeZauberspruch: MutableList<String> = mutableListOf(
        "Expelliarmus",
        "Lumos",
        "Wingardium",
        "Imperio",
        "Beutel",
    )

    // TODO Held führt den Angriff aus
    override fun angriffHelden(gegner: Gegner) {
        println("Wähle eine Zauberkraft aus $listeZauberspruch")
        println("---")
        var attack = readln()
        var check = attack in listeZauberspruch
        if (check) {

            if (!this.isKo && !gegner.isKo) {

                var schaden: Double = this.schadenswerte

                when (attack) {

                    "Expelliarmus" -> {
                        schaden = 1.5 * schadenswerte
                    }

                    "Lumos" -> {
                        schaden = 0.50 * schadenswerte
                    }

                    "Wingardium" -> {
                        schaden = 1.5 * schadenswerte
                    }

                    "Imperio" -> {
                        schaden = 2.0 * schadenswerte
                    }

                    "Beutel" -> {
                        Beutel().zauberTrank(Helden(name, hp, level))
                    }

                }
                // TODO Angriff != Beutel
                if (attack != "Beutel") {
                    println(
                        "${this.name} greift ${gegner.name} mit ---" +
                                "$attack ---für ${schaden.toInt()} an"
                    )
                    Gegner.hpLose(gegner, schaden.toInt())
                    println("---")
                }
            } else if (gegner.hp <= 0) {
                println("Angriff kann nicht ausgeführt werden, Gegner ${gegner.name} hat bereits verloren.")

            }
        } else {
            println("Fehlerhafte Eingabe. Erneut versuchen!")
            println("---")
            angriffHelden(gegner)
        }
    }
}
