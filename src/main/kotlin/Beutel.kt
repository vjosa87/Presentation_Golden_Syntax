open class Beutel(
    var anzahl: Int = 3,
    var anzahl1: Int = 1,
    var beutel: Beutel = Beutel()
) {

    // TODO Zaubertrank
    open fun zauberTrank(helden: Helden): Boolean {
        println("Zaubertrank")
        println("Es darf nur 1 Zaubertrank pro Runde angewendet werden")
        if (anzahl > 0) {

            var heilung: Int = 50

            helden.name = readln()
            helden.hp += heilung
            anzahl -= 1

            println("${helden.name} seine Gesundheitspunkte sind gestiegen und jetzt bei ${helden.hp} Gesundheitspunkten.")
            println("___")
            return true
        }
        return false
    }

    //TODO Vitamine erstellen
    open fun vitamine(gegner: Gegner): Boolean {
        println("Vitamine")
        if (anzahl1 > 0) {

            var vitamine: Int = 350
            gegner.hp -= vitamine
            anzahl1 - 1

            println("Der Gegner ${gegner.name} hat nur ${gegner.hp} Gesundheitspunkte übrig")
            println("___")
            return true
        }
        return false
    }
}
