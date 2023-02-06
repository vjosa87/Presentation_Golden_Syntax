open class Ron(name: String, hp: Int, level: Int) : Helden(name, hp, level) {

    // TODO Zauberkräfte auflisten // (override?!)
    override var listeZauberspruch: MutableList<String> = mutableListOf(
        "Accio",
        "Expecto",
        "Leviosa",
        "Stupor",
        "Beutel"
    )
    // TODO Held beginnt mit dem Angriff

    override fun angriffHelden(gegner: Gegner) {
        println("Wähle einen Zauberspruch aus $listeZauberspruch .")
        println("---")
        var attack = readln()
        var check = attack in listeZauberspruch
        if (check) {

            if (!this.isKo && !gegner.isKo) {

                var schaden: Double = this.schadenswerte

                //TODO Schadenswerte ermitteln

                when (attack) {
                    "Accio" -> {
                        schaden = 1.5 * schadenswerte
                    }

                    "Expecto" -> {
                        schaden = 1.0 * schadenswerte
                    }

                    "Leviosa" -> {
                        schaden = 0.50 * schadenswerte
                    }

                    "Stupor" -> {
                        schaden = 2.0 * schadenswerte
                    }

                    "Beutel" -> {
                        Beutel().zauberTrank(Helden(name, hp, level))
                    }
                }
                when (gegner.name) {

                    "Leviosa" -> {
                        schaden *= 3.5
                    }

                }
                if (attack != "Beutel" && attack != "Beutel1") {
                    println("${this.name} greift ${gegner.name} mit --- $attack --- für ${schaden.toInt()} an")
                    println("---")
                    Gegner.hpLose(gegner, schaden.toInt())
                    println("---")
                }
            } else if (gegner.hp <= 0) {
                println("Angriff kann nicht ausgeführt werden. Gegner ${gegner.name} hat verloren.")
            }
        } else {
            println("Fehlerhafte Eingabe. Erneut versuchen!")
            println("---")
            angriffHelden(gegner)
        }
    }
}
