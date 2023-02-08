open class Harry(name: String, hp: Int, level: Int) : Helden(name, hp, level) {

    // Auflistung von Zaubersprüchen.
    override var listeZauberspruch: MutableList<String> = mutableListOf(
        "1 Nox",
        "2 Petrificus Totalus",
        "3 Finite Incantatem",
        "4 Avada Kedavra",
        "5 Beutel"
    )

    // Vererbung der Funktion "Angriff Helden". Auswahl der "Attacke" in der Konsole & Überprüfung des K.O. Status.
    override fun angriffHelden(gegner: Gegner) {
        println("Wähle einen Zauberspruch aus $listeZauberspruch")
        println("---")
        var attack = readln().toInt()
        if (attack < listeZauberspruch.size) {
            var check = listeZauberspruch.get(attack - 1)


            if (!this.isKo && !gegner.isKo) {

                var schaden: Double = this.schadenswerte

                when (check) {
                    "Nox" -> {
                        schaden = 1.3 * schadenswerte
                    }

                    "Petrificus Totalus" -> {
                        schaden = 2.1 * schadenswerte
                    }

                    "Finite Incantatem" -> {
                        schaden = 1.5 * schadenswerte
                    }

                    "Avada Kedavra" -> {
                        schaden = 2.3 * schadenswerte
                    }

                    "Beutel" -> {

                        Beutel().zauberTrank(Helden(name, hp, level))
                    }

                }

                if (check != "Beutel") {


                    println("${this.name} greift ${gegner.name} mit --- $check --- für ${schaden.toInt()} an")
                    Gegner.hpLose(gegner, schaden.toInt())
                    println("---")
                }
            } else if (gegner.hp <= 0) {
                println("Angriff kann nicht ausgeführt werden, da der Gegner ${gegner.name} bereits verloren hat.")
            }
        } else {
            println("Fehlerhafte Eingabe. Erneut versuchen!")
            println("___")
            angriffHelden(gegner)
        }
    }

}
