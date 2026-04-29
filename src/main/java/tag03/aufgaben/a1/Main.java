package tag03.aufgaben.a1;

public class Main {
    public static void bildschirm(String... daten) {
        System.out.println("=== Ausgabe auf Bildschirm ===" + System.lineSeparator());

        for (String d : daten) {
            System.out.printf("Schreibe %s auf den Bildschirm...%n", d);
        }
        System.out.println();
    }

    public static void datei(String... daten) {
        System.out.println("=== Ausgabe in Datei ===" + System.lineSeparator());

        for (String d : daten) {
            System.out.printf("Schreibe %s in die Datei...%n", d);
        }
        System.out.println();
    }

    public static void datenbank(String... daten) {
        System.out.println("=== Ausgabe in Datenbank ===" + System.lineSeparator());

        for (String d : daten) {
            System.out.printf("Schreibe %s in die Datenbank...%n", d);
        }
        System.out.println();
    }

    static void main() {
        String[] daten = {"Hallo", "Welt", "und Lambda in Java"};

        Ausgabe[] ausgaben = {
                Main::bildschirm,
                Main::datei,
                Main::datenbank
        };

        for (Ausgabe ausgabe : ausgaben) {
            ausgabe.ausgeben(daten);
        }
    }
}