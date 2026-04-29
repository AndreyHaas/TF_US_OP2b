package tag03.template.function.bsp1;

// Auflistung Functional Interfaces aus dem Package java.util.function
// https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

// Beispiel zu Function<T,R>   // T - Parameter, R - Rückgabetyp


import java.util.function.Consumer;
import java.util.function.Function;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Ausgabe über Methode: ");
        System.out.println(errechneQuadratZahl(4)); // aufrufen der Methode errechneQuadratZahl Übergabeparameter hier die 4
        // Ergebnis der Ausgabe = 16

        // Umsetzung des Beispiels mit der Function:

        Function<Integer,Integer> berechneQuadratZahl = zahl -> zahl * zahl;
        System.out.println("Ausgabe über Function: ");
        System.out.println(berechneQuadratZahl.apply(4));

        Function<Integer,String> addiereUndAusgabeAlsString = zahl -> {int erg = zahl + 10; return "Das Ergebnis lautet: "+erg;};
        System.out.println("Ausgabe über 2. Function");
        System.out.println(addiereUndAusgabeAlsString.apply(12));

        System.out.println("Ausgabe Kombination aus beiden Function: ");
        System.out.println(berechneQuadratZahl.andThen(addiereUndAusgabeAlsString).apply(4));
    }



    public static int errechneQuadratZahl(int zahl) // Methode mit Übergabeparameter int zahl und Rückgabetyp int
    {
        return zahl * zahl;
    }

}
