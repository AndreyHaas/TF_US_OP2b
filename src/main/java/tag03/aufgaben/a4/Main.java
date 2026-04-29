package tag03.aufgaben.a4;

public class Main {
    /**
     * Sortiert ein String-Array mit dem Bubblesort-Verfahren.
     *
     * @param array     Das zu sortierende String-Array
     * @param vergleich Das funktionale Interface, das die Vergleichslogik definiert
     */
    public static void sortiere(String[] array, PruefeStrings vergleich) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vergleich.pruefe(array[j], array[j + 1])) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Gibt den Inhalt eines String-Arrays auf der Konsole aus.
     *
     * @param array Das auszugebende String-Array
     */
    public static void ausgabe(String[] array) {
        System.out.println("Aktueller Array-Inhalt:");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("  [%d] \"%s\" (Länge: %d)%n", i + 1, array[i], array[i].length());
        }
        System.out.println();
    }

    static void main() {
        String[] strings = {
                "Autobahnpolizist",
                "Grundstücksverkehrsgenehmigungszuständigkeitsübertragungsverordnung",
                "Ja"
        };

        System.out.println("=== Ursprüngliches Array ===");
        ausgabe(strings);

        sortiere(strings, (s1, s2) -> s1.length() > s2.length());

        System.out.println("=== Nach Sortierung (längere Strings nach hinten) ===");
        ausgabe(strings);
    }
}