/*
    - Führen Sie bitte die folgende Methode ein:
        Name: meinRemoveAll
        Übergabewerte: eine String-Liste und ein Objekt vom funktionalen Interface 'Predicate<String>' (Dieses Interface ist bereits in Java vordefiniert)
        Funktion: a) Löscht alle Elemente der Liste, für die der Rückgabewert der Funktion, auf den das Interface-Objekt verweist, "true" lautet
                  b) Zählt die Anzahl der Elemente, die gelöscht werden
        Rückgabewert: Die ermittelte Anzahl (der gelöschten Elemente)

    Im Main:
       - Führen Sie bitte zunächst eine String-Liste "strings" mit folgenden Elementen ein:
          { "Tee", "Auto", "Gitarre", "Abrakadabra", "C# ist die beste OOP-Programmiersprache" }
       - Lassen Sie anschließend bitte zur Kontrolle den aktuellen Inhalt von 'strings' auf der Konsole ausgeben
       - Rufen Sie bitte daraufhin die Methode 'meinRemoveAll()'  auf
           + übergeben Sie hierbei bitte die beiden folgenden Parameter:
                a) Die String-Liste
                b) Eine Lambda-Expression (vom Typ "Predicate<String>") die GENAU DANN "true" zurückgibt WENN die Länge des Strings < 15 ist
           + speichern Sie bitte den Rückgabewert von "meinRemoveAll()"
        - Lassen Sie abschließend bitte auf der Konsole ausgeben:
            a) alle (verbliebenen) Elemente der String-Liste
            b) die Anzahl der gelöschten Elemente
*/

package tag03.aufgaben.loesung_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Loesung_3
{
    public static void main(String[] args)
    {
        List<String> strings = new ArrayList<String>(Arrays.asList("Tee","Auto","Gitarre","Abrakadabra","C# ist die beste OOP-Programmiersprache"));

        for(String s : strings)
            System.out.println(s);

        System.out.println("Anzahl Elemente gelöscht: " + meinRemoveAll(strings, (x) -> x.length() < 15));

        for(String s : strings)
            System.out.println(s);
    }

    public static int meinRemoveAll(List<String> sl, Predicate<String> predicate)
    {
        int anzahl = 0;
        int zähler = 0;
        while (zähler < sl.size())
        {
            if (predicate.test(sl.get(zähler)))
            {
                sl.remove(sl.get(zähler));
                anzahl++;
            } else
                zähler++;
        }

        return anzahl;
    }
}
