package tag03.aufgaben.a5;

import java.util.Comparator;
import java.util.Random;

public class Main {
    static void main() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int zufallsNummer = random.nextInt(10) + 1; // 1 bis 10

            boolean kundeExistiert = Kunde.getKundenListe().stream()
                    .noneMatch(kunde -> kunde.getKundennummer() == zufallsNummer);

            if (kundeExistiert) {
                String name = "Kunde_" + zufallsNummer;
                new Kunde(zufallsNummer, name);
                System.out.println("Neuer Kunde erstellt: Nr. " + zufallsNummer);
            } else {
                System.out.println("Kunde mit Nr. " + zufallsNummer + " existiert bereits.");
            }
        }

        System.out.println("\n=== Ursprüngliche Liste (unsortiert) ===");

        Kunde.getKundenListe().forEach(System.out::println);

        System.out.println("\n=== Nach Sortierung nach Kundennummer (aufsteigend) ===");
        //Kunde.getKundenListe().sort((k1, k2) -> Integer.compare(k1.getKundennummer(), k2.getKundennummer()));
        Kunde.getKundenListe().sort(Comparator.comparingInt(Kunde::getKundennummer));

        Kunde.getKundenListe().forEach(System.out::println);
    }
}