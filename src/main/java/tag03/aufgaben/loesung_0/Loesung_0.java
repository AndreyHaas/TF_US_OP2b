/* Aufgabe 0-1 (Basics)
 * Interface "Aktion" mit parameterloser void-Methode "ausführen()
 * Klasse "Sportler" mit void Methode "führeAktionAus", welche als Parameter eine Aktion erwartet und die Aktion ausführt.
 * In der Klasse "Program":
 * Void Methode "schwimmen" ohne Parameter: gibt auf der Konsole "Ich schwimme." aus.
 * Void Methode "laufen" ohne Parameter: gibt auf der Konsole "Ich laufe." aus.
 * In der Main:
 * Erstellen Sie einen Sportler, rufen Sie "führeAktionAus" auf und übergeben Sie einmal "schwimmen" und einmal "laufen".
 */

/* Aufgabe 0-2 (Basics)
 * Modifizieren Sie das vorhandene Programm so, dass nicht die Methoden schwimmen() und laufen() verwendet werden, sondern entsprechende Lambda-Expressions
 */

package tag03.aufgaben.loesung_0;

public class Loesung_0
{
    static void schwimmen()
    {
        System.out.println("Ich schwimme.");
    }

    static void laufen()
    {
        System.out.println("Ich laufe.");
    }

    public static void main(String[] args)
    {
        Sportler sportler = new Sportler();

        // Aufgabe 0-1
        Aktion aktion = Loesung_0::laufen;

        sportler.führeAktionAus(Loesung_0::schwimmen); // Wir übergeben die Referenz auf die Methode schwimmen an das Objekt des funktionalen Interfaces
        sportler.führeAktionAus(aktion);

        // Aufgabe 0-2
        sportler.führeAktionAus(() -> System.out.println("Ich schwimme."));
        sportler.führeAktionAus(() -> System.out.println("Ich laufe."));
    }
}

