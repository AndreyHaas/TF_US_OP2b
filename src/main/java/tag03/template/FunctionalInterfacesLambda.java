package tag03.template;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Themen: Funktionale Interfaces und Lambda-Ausdrücke.
// Wir haben bereits gelernt, wie wir anonyme Klassen implementieren.
// Ein Problem bei der Verwendung von anonymen Klassen ist, wenn die Implementierung
// sehr einfach gehalten ist, z.B. wenn ein Interface nur eine Methode hat, dann wirkt
// die Syntax zur Verwendung anonymer Klassen umständlich und nicht klar.
//
// Durch Lambda Ausdrücke können wir Instanzen von Klassen mit nur einer Methode kompakter verwenden
// als die umständliche Implementierung anonymer Klassen.
//
// Mit Java 8 wurden funktionale Interfaces und Lambda eingeführt.
// Funktionale Interfaces werden durch Lambda-Ausdrücke instanziiert und wir vermeiden den Einsatz expliziter anonymer Klassen.
//
// Lambda Ausdrücke ähneln Methoden, sie haben Parameter, einen Körper und einen Rückgabewert. Man kann sie auch als anonyme Methoden bezeichnen.
// Lambda Ausdrücke lehnen sich am Functional Programming an und bringen dieses Paradigma damit, zu gewissen Teilen,
// in die OOP Welt von Java ein.
//
// Funktionale Interfaces:
// Ein funktionales Interface ist ein Interface, welches nur eine abstrakte Methode bereitstellt. Dies bedeutet, dass ein
// funktionales Interface nur 1 Verhalten repräsentiert. Ein funktionales Interface kann aber zusätzlich zur abstrakten Methode beliebig
// viele default und statische Methoden bereitstellen. Ein funktionales Interface kann andere Interfaces erweitern, solange
// diese keine abstrakten Methoden beinhalten.
public class FunctionalInterfacesLambda
{
    public static void main(String[] args)
    {
        // Wir erstellen uns eine Implementationsklasse 'QuadratZahlKlasse' und implementieren die 'berechneQuadratZahl'-Methode.
        // Wir instanziieren eine benannte Klasse:
        QuadratZahlKlasse quadratZahlKlasse = new QuadratZahlKlasse();
        int ergebnis = quadratZahlKlasse.berechneQuadratZahl(7);

        System.out.println("Das Ergebnis ist: " + ergebnis);

        // Oder wir erstellen eine anonyme Klasse:
        QuadratZahl quadratZahl = new QuadratZahl()
        {
            @Override
            public int berechneQuadratZahl(int zahl)
            {
                return zahl * zahl;
            }
        };

        ergebnis = quadratZahl.berechneQuadratZahl(8);
        System.out.println("Das Ergebnis ist: " + ergebnis);

        // Diese bekannten Verfahren sind aber eventuell umständlich und beinhalten redundanten Code.
        // Mit Lambda-Ausdrücken können wir dasselbe erreichen, aber mit weniger Codezeilen.

        // https://de.wikipedia.org/wiki/Anonyme_Funktion
        // Erstes Beispiel für einen Lambda-Ausdruck:
        QuadratZahl quadratZahlLambda = zahl -> zahl * zahl;
        // Das Interface besitzt nur eine (1) abstrakte Methode und der Ausdruck 'zahl -> zahl * zahl' ist die Implementierung der abstrakten Methode.
        int ergebnisLambda = quadratZahlLambda.berechneQuadratZahl(3);
        System.out.println("Das Ergebnis ist: " + ergebnisLambda);

        // Syntax:
        // Im Beispiel erwartet die Methode 'berechneQuadratZahl' einen Integer-Übergabewert.
        // Die linke Seite des Lambda-Ausdrucks ist: 'zahl'
        // 'zahl' ist der Parameter der Funktion.
        // Die rechte Seite des Lambda-Ausdrucks, die hinter dem Pfeil '->' steht, ist: 'zahl * zahl'
        // Dies ist die tatsächliche Implementierung der abstrakten 'berechneQuadratZahl'-Methode des funktionalen Interfaces.
        // Das Ergebnis von 'zahl * zahl' ist die Rückgabe der Methode.
        // Parameter und Rückgabe müssen der abstrakten Methode des Interfaces entsprechen.
        // Der Pfeil verbindet die Parameterliste mit dem Funktionskörper.
        // Syntax in kurz: (Parameterliste) -> { Funktionskörper }

        // Komplexe Lambda-Ausdrücke:
        // Lambda-Ausdrücke können beliebig viele Anweisungen im Methodenkörper haben. In diesen Fällen muss der Körper aber mit geschwungen Klammern angegeben werden.
        // Wenn kein Datentyp angegeben wurde, dann nimmt sich der Lambda-Ausdruck den Typ aus dem Kontext.
        // Wir können aber die Datentypen zur besseren Lesbarkeit trotzdem angeben.
        QuadratZahl quadratZahl1 = (int zahl) ->
        {
            System.out.println("Übergebener Wert: " + zahl);
            return zahl * zahl; // Werden geschwungene Klammern für den Funktionskörper verwendet, müssen wir für die Rückgabe das return-Keyword angeben.
        };

        ergebnisLambda = quadratZahl1.berechneQuadratZahl(5);
        System.out.println("Das Ergebnis ist: " + ergebnisLambda);

		// Lambda-Ausdruck ohne Parameter:
		// Hat die Funktion/Methode keine Parameter, müssen trotzdem runde Klammern angegeben werden.
		EtwasAusgebend halloWelt = () -> System.out.println("Hallo, Welt!");
		halloWelt.ausgabe();

        // Lambda-Ausdrücke können beliebig viele Parameter haben:
        Berechnend berechnend = (x, y) -> x + y;
        ergebnisLambda = berechnend.berechnen(1, 2);
        System.out.println("Das Ergebnis ist: " + ergebnisLambda);

		// Lambda-Ausdrücke können als Argumente an Methoden übergeben werden. Dies ist auch eine der Hauptzwecke von Lambda-Ausdrücken.
		// Lambda ermöglicht es uns also, Funktionalität an Methoden zu übergeben. Funktionalität wird wie Daten behandelt.
		// Dieses Verfahren wird z.B. häufig in der GUI Entwicklung eingesetzt.
		ergebnis = berechne((a, b) -> a - b, 5, 2);
		System.out.println("Dasa Ergebnis ist: " + ergebnis);

        // Der Vorteil gegenüber anonymen Klassen ist ganz klar die viel kürzere Schreibweise bei kurzen Befehlen.

        System.out.println();
        // Weiteres Anwendungsbeispiel:
        ArrayList<String> tiere = new ArrayList<>();
        tiere.add("Krokodil");
        tiere.add("Nilpferd");
        tiere.add("Elefant");
        tiere.add("Tiger");

        System.out.println("Ausgabe über foreach-Schleife:");
        for (String tier : tiere)
            System.out.println(tier);

        // Mit Lambda:
        System.out.println("Ausgabe über forEach-Methode:");
        tiere.forEach(tier -> System.out.println(tier));

		// Sonderfall: Die 'println()'-Methode hat eine Signatur, die identisch mit dem 'Consumer'-Interface ist (void mit String-Parameter).
		// Darum können wir hier verkürzt eine Methodenreferenz anstelle der Lambda-Expression angeben.
		// Anstatt des .-Operators wird dann :: verwendet.
		tiere.forEach(System.out::println);

		// Die Methode im Berechnend-Interface hat eine identische Signatur zur 'Integer.sum()'-Methode.
		// Zwei int-Parameter mit int-Return.
		// Darum kann auch hier eine Methodenreferenz verwendet werden.
		berechnend = Integer::sum;
		System.out.println(berechnend.berechnen(10, 20));

        System.out.println();

		// Wichtige Functional Interfaces in Java:
		// Consumer Interface
		// Java stellt uns viele vordefinierte funktionale Interfaces bereit. Ein Beispiel dafür ist das 'Consumer<T>'-Interface, welches zwei Methoden bereitstellt. Erinnerung: Funktionale Interfaces dürfen nur eine abstrakte Methode haben, aber beliebig viele statische und default Methoden.
		// Um die Definition einzusehen mit IntelliJ: Rechtsklick auf Consumer -> Go To -> Declaration or Usages.
		// Alternativ mit der Maus über das Interface und im Popup Rechtsklick -> Jump to Source.

        // Beispiele zum Consumer: https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/

        // Die Methode 'accept()' des Interfaces ist die abstrakte Methode.
        // Sie konsumiert einen beliebigen Typen und gibt nichts zurück.
        // Die Methode 'andThen()' des Interfaces ist eine default-Methode. Sie wird auf ein existierendes Consumer-Objekt aufgerufen.

        // Wir legen eine Variable vom Typ Consumer an:
        Consumer<String> gibStringAus = System.out::println; // Wir können eine Lambda-Expression zuweisen, oder eine passende Methodenreferenz.

        // Mit 'andThen()' können wir die Methoden verketten:
        gibStringAus = gibStringAus.andThen(s -> System.out.println(s.toUpperCase()));
        gibStringAus = gibStringAus.andThen(s -> System.out.println(s.toLowerCase()));

        // Mit 'accept()' führen wir alle gespeicherten Anweisungen aus:
        gibStringAus.accept("Hallo, Welt!");

        // Function Interface (Erster Typ für den Parameter, zweiter Typ für die Rückgabe)
        Function<Integer, Integer> quadrat = (Integer x) -> x * x;
        System.out.println(quadrat.apply(10));

        // Predicate Interface (Einen Parameter, gibt immer Boolean zurück)
        Predicate<Integer> größer10 = (x) -> x > 10;
        System.out.println(größer10.test(5));

        // Comparator Interface (Zwei Parameter vom selben Typ und gibt immer int zurück)
        Comparator<String> vergleich = (String x, String y) -> Integer.compare(y.length(), x.length());
        System.out.println(vergleich.compare("Hallo", "Welt"));

        Comparator<Integer> ivergleich = Integer::compare;

    } // Hier endet die Main-Methode

	// Lambda-Ausdrücke können als Argumente an Methoden übergeben werden:
	// (Funktionalität wird wie Daten behandelt)
	private static int berechne(Berechnend lambda, int z1, int z2)
	{
		return lambda.berechnen(z1, z2);
	}
}