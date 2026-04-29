package tag03.aufgaben.a0;

public class Main {

    public static void schwimmen() {
        System.out.println("Ich schwimme.");
    }

    public static void laufen() {
        System.out.println("Ich laufe.");
    }

    static void main() {
        Sportler sportler = new Sportler();

        // Methodenreferenzen
        sportler.fuehreAktionAus(Main::schwimmen);
        sportler.fuehreAktionAus(Main::laufen);

        //
        sportler.fuehreAktionAus(() -> System.out.println("Ich schwimme."));
        sportler.fuehreAktionAus(() -> System.out.println("Ich laufe."));
    }
}