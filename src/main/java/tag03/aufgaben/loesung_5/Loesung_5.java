/* Klasse Kunde mit:
 *  einer statischen Liste aller Kunden
 *  einer Integer kundennummer
 *  einem String name
 *  und einem Konstruktor, welcher die Eigenschaften füllt und den Kunden der Liste hinzufügt.
 *
 * In der Main:
 *  Eine Schleife, die 10 Mal eine Zufallszahl zwischen 1 und inklusive 10 ermittelt,
 *  prüft, ob es bereits einen Kunden mit dieser Zufallszahl als kundennummer gibt
 *  und wenn nicht, einen Kunden mit dieser kundennummer erstellt.
 *  Wie der name erzeugt wird, ist egal.
 *
 *  Um herauszufinden, ob es bereits Kunden mit der kundennummer gibt, kann die .stream().noneMatch() Methode der KundeListe aufgerufen werden.
 *  Diese Methode hat ein funktionales Interface vom Typ Predicate als Parameter. Hier übergeben Sie eine passende Lambda-Expression.
 *
 *  Anschließend geben Sie die KundeListe mit der ForEach()-Methode aus. Die ForEach()-Methode hat einen Consumer-Parameter. Hier übergeben Sie eine passende Lambda-Expression für die Konsolen-ausgaben.
 *
 *  Nun lassen Sie die Liste nach kundennummer sortieren. Dafür nutzen Sie die sort()-Methode der Liste. Diese Methode verwendet ein Functional Interface vom Typ 'Comparator'. Oder Sie verwenden Collections.sort(). Dafür muss Kunde dann das Interface 'Comparable' implementieren.
 *
 *  Zum Schluss wird die sortierte Liste ausgegeben.
 *
 */

package tag03.aufgaben.loesung_5;

import java.util.*;

public class Loesung_5
{
    public static void main(String[] args)
    {
        Random random = new Random();

        for (int i = 0; i < 10; i++)
        {
            int nummer = random.nextInt(10) + 1;

            // 'stream()' führt eine For-Each-Schleife auf der Liste durch und bietet Methoden an, die für jedes Element der Liste aufgerufen werden kann.
            // 'noneMatch()' prüft, ob eine übergebene Aussage/Behauptung (Predicate) für Objekte der Liste stimmt und wenn die Behauptung für kein Objekt stimmt, gibt sie True zurück.
            // mit .stream().noneMatch() nach einem Kunden mit der Nummer suchen und wenn keiner gefunden wird:
            if (Kunde.kundeListe.stream().noneMatch(x -> x.getKundennummer() == nummer))
                new Kunde(nummer, "Kunde" + i); // neuen Kunden mit der Nummer erzeugen
        }

        System.out.println("Ausgabe unsortiert:");
        ausgabe();

        // Nach kundennummer sortieren
        Kunde.kundeListe.sort(Comparator.comparingInt(Kunde::getKundennummer));

        // Sort ausführlich:
        Kunde.kundeListe.sort((Kunde x, Kunde y) ->
        {
            if (x.getKundennummer() > y.getKundennummer())
                return 1;
            else if (x.getKundennummer() == y.getKundennummer())
                return 0;
            else
                return -1;
        });

        // Variante mit Comparable
        Collections.sort(Kunde.kundeListe);
        // oder:
        Kunde.kundeListe.sort(Kunde::compareTo);

        System.out.println("\nAusgabe sortiert:");
        ausgabe();
    }

    // Ausgabe-Methode zur Vermeidung von doppeltem Code
    static void ausgabe()
    {
        Kunde.kundeListe.forEach(System.out::println);
    }
}

