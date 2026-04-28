/* Aufgabe 0 (Basics)
 * Erstellen Sie die abstrakte Klasse "Künstler" mit einer abstrakten Methode "kunstErstellen()".
 *
 * Im Main erzeugen Sie zwei Objekte vom Typ Künstler, wobei Sie die kunstErstellen()-Methode überschreiben.
 * Ein Maler auf der Konsole "Ich male ein Bild" und ein Sänger soll "Ich singe einen Song" ausgeben.
 * Rufen Sie in der Main für beide Objekte die Methode auf.
 */

package tag02.aufgaben.loesungen;

public class Lösung_0
{
    public static void main(String[] args)
    {
        //Künstler k = new Künstler(); // Nicht möglich, da Künstler abstrakt ist

        Künstler maler = new Künstler()
        {
            @Override
            public void kunstErstellen()
            {
                System.out.println("Ich male ein Bild");
            }
        };

        Künstler sänger = new Künstler()
        {
            @Override
            public void kunstErstellen()
            {
                System.out.println("Ich singe einen Song");
            }
        };

        maler.kunstErstellen();
        sänger.kunstErstellen();

    }
}

abstract class Künstler
{
    public abstract void kunstErstellen();
}