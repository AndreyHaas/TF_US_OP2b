/* Aufgabe 0 (Basics)
    Eine generische Klasse "Pair" mit zwei verschiedenen Typ-Parametern (A und B)
    Zwei private Attribute, um Werte abspeichern zu können (value0 von Typ a und value1 von Typ B)
    Getter- und Setter-Methoden
    Eine öffentliche, statische "of(A value0, B value1)"-Methode, welches ein Objekt von Pair erzeugt und den Attributen die Werte zuweist.
    Eine Methode "toArray()", welche value0 und value1 als Object Array zurückgibt
    Eine toString()-Methode, welche beide values als String zurückgibt.
 */


package tag04.aufgaben.loesung;

import java.util.Arrays;

public class Loesung_0
{

    public static void main(String[] args)
    {
        Pair<Integer, String> pair = Pair.of(123, "ABC");
        System.out.println(pair);
        System.out.println(Arrays.toString(pair.toArray()));
    }
}