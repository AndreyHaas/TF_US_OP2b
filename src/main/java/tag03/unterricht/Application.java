package tag03.unterricht;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Application {
    static void main() {
        Rechner quadratZahlRechner = new Rechner();
        int ergebnis = quadratZahlRechner.konsumiereZahl(9);
        System.out.println(ergebnis);

        IZahlKonsumierer quadratRechner = new IZahlKonsumierer() {
            @Override
            public int konsumiereZahl(int zahl) {
                return zahl * zahl;
            }
        };

        System.out.println(quadratRechner.konsumiereZahl(8));

        IZahlKonsumierer quadratRechnerLambda = zahl -> zahl * zahl;
        ergebnis = quadratRechnerLambda.konsumiereZahl(7);

        System.out.println(ergebnis);

        IZahlKonsumierer qudratZahlLambdaAusdruck = (int zahl) -> {
            System.out.println("Zahl: " + zahl);
            return zahl * zahl;
        };

        System.out.println(qudratZahlLambdaAusdruck.konsumiereZahl(9));

        //IBerechnend berechnend = Integer::sum; - kan mann auch so
        IBerechnend berechnend = (x, y) -> x + y;
        int berechne = Application.berechne(berechnend, 7, 8);
        System.out.println(berechne);

        List<String> tiere = new ArrayList<>();
        tiere.add("Krokodil");
        tiere.add("Nilpferd");
        tiere.add("Elefant");
        tiere.add("Tiger");

        System.out.println("Ausgabe von foreach-Schleife");

        for (String tier : tiere) {
            System.out.println(tier);
        }

        System.out.println("Ausgabe ueber foreach-Methode");
        //tiere.forEach(System.out::println);
        tiere.forEach(tier -> System.out.println(tier));

        //Consumer<String> gibStringAus = s -> System.out.println(s);
        Consumer<String> gibStringAus = System.out::println;
        gibStringAus = gibStringAus.andThen(s -> System.out.println(s.toUpperCase()));
        gibStringAus = gibStringAus.andThen(s -> System.out.println(s.toLowerCase()));
        gibStringAus.accept("Wir sind aufm Gipfel angekommen!!! Yahoooooo!!!");

        Predicate<Integer> groesser10 = x -> x > 10;
        System.out.println(groesser10.test(12));
    }

    private static int berechne(IBerechnend lambda, int zahlEins, int zahlZwei) {
        return lambda.berechnen(zahlEins, zahlZwei);
    }

    // // Themen: Funktionale Interfaces und Lambda-Ausdrücke.
    //    // Wir haben bereits gelernt, wie wir anonyme Klassen implementieren.
    //    // Ein Problem bei derhttps://github.com/Benjamin-Web/Heist_Bot_Updates Verwendung von anonymen Klassen ist, wenn die Implementierung
    //    // sehr einfach gehalten ist, z.B. wenn ein Interface nr eine Methode hat, dann wirkt
    //    // die Syntax zur Verwendung anonymer Klassen umständlich und nicht klar.
    //    //
    //    // Durch Lambda Ausdrücke können wir Instanzen von Klassen mit nur einer Methode kompakter verwenden
    //    // als die umständliche Implementierung anonymer Klassen.
    //    //
    //    // Mit Java 8 wurden funktionale Interfaces und Lambda eingeführt.
    //    // Funktionale Interfaces werden durch Lambda-Ausdrücke instanziiert und wir vermeiden den Einsatz expliziter anonymer Klassen.
    //    //
    //    // Lambda Ausdrücke ähneln Methoden, sie haben Parameter, einen Körper und einen Rückgabewert. Man kann sie auch als anonyme Methoden bezeichnen.
    //    // Lambda Ausdrücke lehnen sich am Functional Programming an und bringen dieses Paradigma damit, zu gewissen Teilen,
    //    // in die OOP Welt von Java ein.
    //    //
    //    // Funktionale Interfaces:
    //    // Ein funktionales Interface ist ein Interface, welches nur eine abstrakte Methode bereitstellt. Dies bedeutet, dass ein
    //    // funktionales Interface nur 1 Verhalten repräsentiert. Ein funktionales Interface kann aber zusätzlich zur abstrakten Methode beliebig
    //    // viele default und statische Methoden bereitstellen. Ein funktionales Interface kann andere Interfaces erweitern, solange
    //    // diese keine abstrakten Methoden beinhalten
    //    public static void main(String[] args)
    //    {
    //        // Wir instanziieren eine benannte Klasse:
    //        Rechner quadratzahlRechner = new Rechner();
    //        int ergebnis = quadratzahlRechner.konsumiereZahl(9);
    //        System.out.println(ergebnis);
    //
    //        // Oder wir erstellen eine anonyme innere Klasse:
    //        IZahlKonsumierer quadratRechner = new IZahlKonsumierer()
    //        {
    //            @Override
    //            public int konsumiereZahl(int zahl)
    //            {
    //                return zahl * zahl;
    //            }
    //        };
    //
    //        System.out.println(quadratRechner.konsumiereZahl(8));
    //
    //        // Diese bekannten Verfahren sind aber eventuell umständlich und beinhalten redundanten Code.
    //        // Mit Lambda-Ausdrücken können wir dasselbe erreichen, aber mit weniger Codezeilen.
    //
    //        // https://de.wikipedia.org/wiki/Anonyme_Funktion
    //        IZahlKonsumierer quadratZahlLambda = z -> z * z;
    //
    //        // Das Interface besitzt nur eine abstrakte Methode und der Ausdruck 'zahl -> zahl * zahl' ist die Implementierung der abstrakten Methode.
    //        System.out.println(quadratZahlLambda.konsumiereZahl(7));
    //
    //        // Syntax:
    //        // Im Beispiel erwartet die Methode einen Integer-Übergabewert.
    //        // Die linke Seite des Lambda-Ausdrucks ist: 'zahl'
    //        // 'zahl' ist der Parameter der Funktion.
    //        // Die rechte Seite des Lambda-Ausdrucks, die hinter dem Pfeil '->' steht, ist: 'zahl * zahl'
    //        // Dies ist die tatsächliche Implementierung der abstrakten Methode des funktionalen Interfaces.
    //        // Das Ergebnis von 'zahl * zahl' ist die Rückgabe der Methode.
    //        // Parameter und Rückgabe müssen der abstrakten Methode des Interfaces entsprechen.
    //        // Der Pfeil verbindet die Parameterliste mit dem Funktionskörper.
    //        // Syntax in kurz: (Parameterliste) -> { Funktionskörper }
    //
    //        // Komplexe Lambda-Ausdrücke:
    //        // Lambda-Ausdrücke können beliebig viele Anweisungen im Methodenkörper haben. In diesen Fällen muss der Körper aber mit geschwungen Klammern angegeben werden.
    //        // Wenn kein Datentyp angegeben wurde, dann nimmt sich der Lambda-Ausdruck den Typ aus dem Kontext.
    //        // Wir können aber die Datentypen zur besseren Lesbarkeit trotzdem angeben.
    //        IZahlKonsumierer quadratZahlLambdaAusdruck = (int zahl) ->
    //        {
    //            System.out.println("Uebergebener Wert: " + zahl);
    //            return zahl * zahl; // Werden geschwungene Klammern für den Funktionskörper verwendet, müssen wir für die Rückgabe das return-Keyword angeben.
    //        };
    //
    //        ergebnis = quadratZahlLambdaAusdruck.konsumiereZahl(5);
    //        System.out.println("Das Ergibnis ist: " + ergebnis);
    //
    //        IBerechnend berechnend = (x, y) -> x + y;
    //
    //        // Lambda
    //        ergebnis = Main.berechne(berechnend, 7, 8);
    //        System.out.println("Ergebnis Lambda Addition" + ergebnis);
    //
    //        IBerechnend berechnend1 = (x, y) -> x * y;
    //        ergebnis = Main.berechne(berechnend1, 3, 5);
    //        System.out.println("Ergebnis Lambda Multiplikation" + ergebnis);
    //    }
    //
    //    private static int berechne(IBerechnend lambda, int zahlEins, int zahlZwei)
    //    {
    //       return lambda.berechnen(zahlEins , zahlZwei);
    //    }
    //
    //
    //}
    //---------------------------
    //
    //package unterricht;
    //
    //@FunctionalInterface
    //public interface IBerechnend
    //{
    //      int berechnen(int zahlEins, int zahlZwei);
    //}
    //----------------------------------------
    //
    //package unterricht;
    //
    //// Funktionale Interfaces:
    //// Ein funktionales Interface ist ein Interface, welches nur eine abstrakte Methode bereitstellt. Dies bedeutet, dass ein
    //// funktionales Interface nur 1 Verhalten repräsentiert. Ein funktionales Interface kann aber zusätzlich zur abstrakten Methode beliebig
    //// viele default und statische Methoden bereitstellen. Ein funktionales Interface kann andere Interfaces erweitern, solange
    //// diese keine abstrakten Methoden beinhalten.
    //// Erstes funktionales Interface:
    ////Ein funktionales Interface ist ein Interface, das nur eine (1) abstrakte Methode bereitstellt.
    ////Funktionale Interfaces können beliebig viele default-Methoden beinhalten, aber nur eine abstrakte Methode!
    //@FunctionalInterface
    //public interface IZahlKonsumierer
    //{
    //    int konsumiereZahl(int zahl);
    //}
    //====================================
    //
    //package unterricht;
    //
    //// Bekanntes Verfahren: wir implementieren das Interface in einer Klasse und verwenden die Instanz-Methode, um eine Quadratzahl zu berechnen.
    //public class Rechner implements IZahlKonsumierer
    //{
    //    @Override
    //    public int konsumiereZahl(int zahl)
    //    {
    //        return zahl * zahl;
    //    }
    //}
}