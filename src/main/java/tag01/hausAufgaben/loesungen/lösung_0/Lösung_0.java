/* Level 1
 * Erstellen Sie die abstrakte Klasse "Künstler" mit einer abstrakten Methode "kunstErstellen()".
 * Erstellen Sie zwei weitere Klassen "Maler" und "Sänger", die beide von "Künstler" erben.
 * Die beiden Subklassen überschreiben die Methode der Basisklasse.
 * Dabei gibt der Maler auf der Konsole "Ich male ein Bild" und der Sänger "Ich singe einen Song" aus.
 * Im main() erzeugen Sie je ein Objekt von Maler und Sänger.
 * Rufen Sie in der main()-Methode für beide Objekte die Methode kunstErstellen() auf.
 *
 * Zeichnen Sie ein Klassendiagramm.
 */

package tag01.hausAufgaben.loesungen.lösung_0;

public class Lösung_0 {

  public static void main(String[] args) {
    //Künstler k = new Künstler(); // Nicht möglich, da Künstler abstrakt ist.

    Maler maler = new Maler();
    Sänger sänger = new Sänger();

    maler.kunstErstellen();
    sänger.kunstErstellen();
  }
}

