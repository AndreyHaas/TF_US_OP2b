package tag03.aufgaben.a2;

public class Main {

    public static boolean A_IstLaengerAls_B(String a, String b) {
        return a.length() > b.length();
    }

    public static boolean A_hatMehrEAls_B(String a, String b) {
        return a.chars().filter(ch -> ch == 'E' || ch == 'e').count() >
                b.chars().filter(ch -> ch == 'E' || ch == 'e').count();
    }

    public static void sortiere(String[] array, PruefeStrings vergleich) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vergleich.pruefen(array[j], array[j + 1])) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void ausgabe(String[] array) {
        System.out.println("Aktueller Array-Inhalt:");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("  [%d] %s%n", i, array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] arr = {
                "Dampfschifffahrtsgesellschaft",
                "EDV",
                "Schneeeule"
        };

        System.out.println("=== Ursprüngliches Array ===");
        ausgabe(arr);

        PruefeStrings vergleich = Main::A_IstLaengerAls_B;

        System.out.println("=== Nach Sortierung mit A_IstLängerAls_B (längere Strings nach hinten) ===");
        sortiere(arr, vergleich);
        ausgabe(arr);

        vergleich = Main::A_hatMehrEAls_B;

        System.out.println("=== Nach Sortierung mit A_hatMehrEAls_B (mehr E's nach hinten) ===");
        sortiere(arr, vergleich);
        ausgabe(arr);
    }
}