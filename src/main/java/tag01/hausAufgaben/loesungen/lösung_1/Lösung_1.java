/* Level 1
Erstellen Sie die abstrakte Klasse "Kreatur" mit einem protected Attribut "name", einer abstrakten Methode "angreifen" und einem Konstruktor, der name initialisiert.
 * Erstellen Sie zwei weitere Klassen "Ritter" und "Drache", die beide von "Kreatur" erben.
 * Die beiden Subklassen implementieren die Methode der Basisklasse.
 * Der Ritter nutzt sein Schwert, der Drache spuckt Feuer.
 * In main() erzeugen Sie je ein Objekt von Ritter und Drache.
 * Rufen Sie in der main-Methode() für beide Objekte die überschriebene angreifen()-Methode auf.
 */

package tag01.hausAufgaben.loesungen.lösung_1;


import tag01.hausAufgaben.loesungen.lösung_1.kreatur.Drache;
import tag01.hausAufgaben.loesungen.lösung_1.kreatur.Ritter;

public class Lösung_1 {

  public static void main(String[] args) {
    Ritter ritter = new Ritter("Adriana, Captain of the Guard");
    Drache drache = new Drache("Nicol Bolas, the Ravager");

    ritter.angreifen();
    drache.angreifen();
  }
}