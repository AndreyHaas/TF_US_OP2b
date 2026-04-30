package tag03.aufgaben.a1;

import java.util.List;

public class Main {
    static void main() {
        String[] daten = {"Hallo", "Welt", "und Lambda in Java"};

        ausgabeKonfigurationen().forEach(konfiguration ->
            ausgeben(daten, konfiguration.praeposition, konfiguration.ziel)
        );
    }

    record AusgabeKonfig(String praeposition, String ziel) {}

    private static List<AusgabeKonfig> ausgabeKonfigurationen() {
        return List.of(
            new AusgabeKonfig("auf den", "Bildschirm"),
            new AusgabeKonfig("in die", "Datei"),
            new AusgabeKonfig("in die", "Datenbank")
        );
    }

    private static void ausgeben(String[] daten, String praeposition, String ziel) {
        for (String datei : daten) {
            System.out.printf("Schreibe %s %s %s...%n", datei, praeposition, ziel);
        }
        System.out.println();
    }
}