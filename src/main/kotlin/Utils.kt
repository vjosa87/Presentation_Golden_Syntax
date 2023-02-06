// TODO Funktionen Angriff erstellen
var beutel: Beutel = Beutel()
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
    // TODO While Schleife & IF/ELSE Verzweigung
    while (!harry.isKo && !voldemort.isKo) {


        if (harry.listeZauberspruch == voldemort.listeZauberspruch) {

            harry.angriffHelden(listegegner.random())
            hermine.angriffHelden(listegegner.random())
            ron.angriffHelden(listegegner.random())
            voldemort.angriffGegner(listeHelden.random(), listegegner)
            grindelwald.angriffGegner(listeHelden.random(), listegegner)
            zabini.angriffGegner(listeHelden.random(), listegegner)

        } else if (!grindelwald.isKo && !hermine.isKo) {
            harry.angriffHelden(listegegner.random())
            hermine.angriffHelden(listegegner.random())
            ron.angriffHelden(listegegner.random())
            voldemort.angriffGegner(listeHelden.random(), listegegner)
            grindelwald.angriffGegner(listeHelden.random(), listegegner)
            zabini.angriffGegner(listeHelden.random(), listegegner)

        } else if (grindelwald.isKo && !voldemort.isKo && !zabini.isKo) {
            harry.angriffHelden(voldemort)
            hermine.angriffHelden(voldemort)
            ron.angriffHelden(voldemort)
            voldemort.angriffGegner(listeHelden.random(), listegegner)
            zabini.angriffGegner(listeHelden.random(), listegegner)

        } else (println("GAME OVER"))

    }

    if (harry.isKo && !voldemort.isKo) {
        println("${voldemort.name} hat ${harry.name} besiegt")
        listeHelden.remove(harry)

        if (hermine.isKo && !voldemort.isKo) {
            println("${voldemort.name} hat ${hermine.name} besiegt")
            listeHelden.remove(hermine)
        }
        if (ron.isKo && !voldemort.isKo) {
            println("${voldemort.name} hat ${ron.name} besiegt")
            listeHelden.remove(ron)

        } else if (voldemort.isKo && !harry.isKo) {
            println("${harry.name} hat ${voldemort.name} besiegt")
        }
        if (voldemort.isKo && !hermine.isKo) {
            println("${hermine.name} hat ${voldemort.name} besiegt")

        } else if (voldemort.isKo && !ron.isKo) {
            println("${ron.name} hat ${voldemort.name} besiegt")
        }

        if (harry.isKo && !zabini.isKo) {
            println("${zabini.name} hat ${harry.name} besiegt")
            listeHelden.remove(harry)

            if (hermine.isKo && !zabini.isKo) {
                println("${zabini.name} hat ${hermine.name} besiegt")
                listeHelden.remove(hermine)
            }
            if (ron.isKo && !zabini.isKo) {
                println("${zabini.name} hat ${ron.name} besiegt")
                listeHelden.remove(ron)

            } else if (zabini.isKo && !harry.isKo) {
                println("${harry.name} hat ${zabini.name} besiegt")
            }
            if (zabini.isKo && !hermine.isKo) {
                println(" ${hermine.name} hat ${zabini.name} besiegt")

            } else if (zabini.isKo && !ron.isKo) {
                println("${ron.name} hat ${zabini.name} besiegt")
            }

        } else {
            println("GAME OVER")
        }
    }
}
