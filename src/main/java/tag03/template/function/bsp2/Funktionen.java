package tag03.template.function.bsp2;

import java.util.function.Function;

public class Funktionen
{
    Function<Integer,Integer> berechneQuadratZahl = zahl -> zahl * zahl;

    Function<Integer,String> speichereDaten = zahl ->
    {
        new Daten(zahl);
        return "Die QuadratZahl: "+zahl+" wurde gespeichert!";
    };

    public int istEingabeInteger(String s)
    {
        while(true)
        {
            try
            {
                return Integer.parseInt(s);
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Falsche Eingabe!");
            }
        }
    }
}
