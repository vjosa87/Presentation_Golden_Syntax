open class Hermine(name: String, hp: Int, level: Int) : Helden(name, hp, level) {

    // Auflistung der Zaubersprüche.
    override var listeZauberspruch: MutableList<String> = mutableListOf(
        "1 Expelliarmus",
        "2 Lumos",
        "3 Wingardium",
        "4 Imperio",
        "5 Beutel"
    )

    // Vererbung der Funktion "Angriff Helden". Auswahl der "Attacke" in der Konsole & Überprüfung des K.O. Status.
    override fun angriffHelden(gegner: Gegner) {

        if (this.isKo) {
            println("Hermine ist KO.")

        } else {
            println("Wähle einen Zauberspruch aus $listeZauberspruch.")
            println("---")
            var attack = readln().toInt()
            if (attack < listeZauberspruch.size) {
                var check = listeZauberspruch.get(attack - 1)

                if (!gegner.isKo) {

                    var schaden: Double = this.schadenswerte

                    when (check) {

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
                    // Beutel "check" und Berechnung des Schadens.
                    if (check != "Beutel") {
                        println("${this.name} greift ${gegner.name} mit --- $check --- für ${schaden.toInt()} an")
                        Gegner.hpLose(gegner, schaden.toInt())
                        println("---")
                    }
                } else {
                    println("Angriff kann nicht ausgeführt werden, da der Gegner ${gegner.name} bereits verloren hat.")

                }
            } else {
                println("Fehlerhafte Eingabe. Erneut versuchen!")
                println("---")
                angriffHelden(gegner)
            }
        }
    }
}
