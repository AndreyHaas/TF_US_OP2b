package tag03.aufgaben.a3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    /**
     * Löscht alle Elemente der Liste, für die der Predicate true zurückgibt.
     *
     * @param liste     Die String-Liste, aus der gelöscht werden soll
     * @param bedingung Das Predicate, das die Löschbedingung definiert
     * @return Die Anzahl der gelöschten Elemente
     */
    public static int meinRemoveAll(List<String> liste, Predicate<String> bedingung) {
        int anzahlGeloescht = 0;

        for (int i = liste.size() - 1; i >= 0; i--) {
            String element = liste.get(i);
            if (bedingung.test(element)) {
                liste.remove(i);
                anzahlGeloescht++;
            }
        }

        return anzahlGeloescht;
    }

    public static void listeAusgeben(List<String> liste, String titel) {
        System.out.println(titel);

        for (int i = 0; i < liste.size(); i++) {
            System.out.printf("  [%d] \"%s\"%n", i + 1, liste.get(i));
        }
        System.out.println();
    }

    static void main() {
        List<String> strings =
                new ArrayList<>(List.of
                        ("Tee", "Auto", "Gitarre", "Abrakadabra", "C# ist die beste OOP-Programmiersprache"));

        listeAusgeben(strings, "=== Ursprüngliche Liste ===");

        int anzahlGeloescht = meinRemoveAll(strings, wort -> wort.length() < 15);

        listeAusgeben(strings, "=== Verbliebene Elemente ===");

        System.out.println("=== Anzahl gelöschter Elemente ===");
        System.out.println("Gelöscht wurden: " + anzahlGeloescht + " Element(e)");
    }
}