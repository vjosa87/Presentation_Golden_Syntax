open class Ron(name: String, hp: Int, level: Int) : Helden(name, hp, level) {

    // Vererbung & Auflistung der Zaubersprüche.
    override var listeZauberspruch: MutableList<String> = mutableListOf(
        "1 Accio",
        "2 Expecto",
        "3 Leviosa",
        "4 Stupor",
        "5 Beutel"
    )

    // Vererbung der Funktion "Angriff Helden". Auswahl der "Attacke" in der Konsole & Überprüfung des K.O. Status.
    override fun angriffHelden(gegner: Gegner) {

        if (this.isKo) {
            println("Ron ist K.O.!")
        } else {
            println("Wähle einen Zauberspruch aus $listeZauberspruch.")
            println("---")
            var attack = readln().toInt()
            if (attack < listeZauberspruch.size) {
                var check = listeZauberspruch.get(attack - 1)

                if (!this.isKo && !gegner.isKo) {

                    var schaden: Double = this.schadenswerte

                    //Schadenswerte ermitteln

                    when (check) {
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
                    if (check != "Beutel" && check != "Beutel1") {
                        println("${this.name} greift ${gegner.name} mit --- $attack --- für ${schaden.toInt()} an")
                        println("---")
                        Gegner.hpLose(gegner, schaden.toInt())
                        println("---")
                    }
                } else if (gegner.hp <= 0) {
                    println("Angriff kann nicht ausgeführt werden, da der Gegner ${gegner.name} verloren hat.")
                }
            } else {
                println("Fehlerhafte Eingabe. Erneut versuchen!")
                println("---")
                angriffHelden(gegner)
            }
        }
    }
}
