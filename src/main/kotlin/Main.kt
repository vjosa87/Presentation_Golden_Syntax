fun main() {

    println("*Harry Potter & Golden Syntax*")
    println(" ")

    // Instanzvariablen
    var harry = Harry("Harry", 30, 10)
    var hermine = Hermine("Hermine", 30, 6)
    var ron = Ron("Ron", 10, 5)
    var voldemort = Voldemort("Voldemort", 30, 15)
    var grindelwald = Grindelwald("Grindelwald", 10, 12)
    var zabini = Zabini("Zabini", 10, 10)

    var listeHelden: MutableList<Helden> = mutableListOf(harry, hermine, ron)
    var listeGegner: MutableList<Gegner> = mutableListOf(voldemort, grindelwald, zabini)

    // Angriffsliste
    angriff(harry, hermine, ron, voldemort, grindelwald, zabini, listeHelden, listeGegner)

}