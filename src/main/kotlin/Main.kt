
//TODO main function
fun main() {

    println("*Harry Potter & Golden Syntax*")
    println(" ")

    // TODO Instanzvariablen
    var harry = Harry("Harry", 400, 80)
    var hermine = Hermine("Hermine", 350, 60)
    var ron = Ron("Ron", 200, 25)
    var voldemort = Voldemort("Voldemort", 500, 100)
    var grindelwald = Grindelwald("Grindelwald",  300, 20)
    var zabini = Zabini("Zabini", 200, 15)

    var listeHelden: MutableList<Helden> = mutableListOf(harry, hermine, ron)
    var listeGegner: MutableList<Gegner> = mutableListOf(voldemort, grindelwald, zabini)

    // TODO Angriffsliste
    angriff(harry, hermine, ron, voldemort, grindelwald, zabini, listeHelden, listeGegner)

}
