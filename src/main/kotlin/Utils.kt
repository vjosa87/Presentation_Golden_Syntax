// Funktion "Angriff" (Gegner & Helden)
fun angriff(
    harry: Helden,
    hermine: Helden,
    ron: Helden,
    voldemort: Gegner,
    grindelwald: Gegner,
    zabini: Gegner,
    listeHelden: MutableList<Helden>,
    listegegner: MutableList<Gegner>,
) {
    // While & IF Schleife -> willkürlicher Angriff
    while (!harry.isKo && !voldemort.isKo) {

        harry.angriffHelden(listegegner.random())
        hermine.angriffHelden(listegegner.random())
        ron.angriffHelden(listegegner.random())
        voldemort.angriffGegner(listeHelden.random(), listegegner)
        grindelwald.angriffGegner(listeHelden.random(), listegegner)
        zabini.angriffGegner(listeHelden.random(), listegegner)
    }
    // Spiel gewonnen, wenn Harry Voldemort besiegt hat.
    if (!harry.isKo && voldemort.isKo) {
        println("Glückwunsch, du hast das Spiel gewonnen. Der Gegner ist K.O.!")

    // Spiel verloren, wenn Voldemort Harry besiegt hat.
    } else if (harry.isKo && !voldemort.isKo) {
        println("Du hast verloren!")

    // Spiel zu Ende, wenn beide K.O. sind.
    } else {
        println("Game Over! Das Spiel ist zu Ende. Gegner und Held sind K.O.")
    }
}

