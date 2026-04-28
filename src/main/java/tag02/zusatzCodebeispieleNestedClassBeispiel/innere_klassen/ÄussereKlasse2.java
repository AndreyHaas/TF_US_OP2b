package tag02.zusatzCodebeispieleNestedClassBeispiel.innere_klassen;


// Innere Klassen in Methoden.
// Innere Klassen können in beliebigen Anweisungsblöcken der äußeren Klasse definiert werden und müssen nicht alleinstehend definiert werden. Dadurch bekommt die innere
// Klasse Zugriff auf alle lokalen Variablen des umgebenden Codeblocks. Um den Zugriff zu gewährleisten, müssen diese Variablen dann aber mit final als Konstante
// deklariert werden.
public class ÄussereKlasse2 {

  public void gibAus() {
    int zahl = 7; // Soll die in dieser Methode definierte Klasse Zugriff auf die umgebenden Variablen bekommen, müssen diese mit final deklariert werden.

    class InnereKlasse2 {

      public void gibAus() {
        System.out.println("Die Zahl lautet: "
            + zahl); // Zugriff aus der inneren Klasse auf die lokale Variable zahl der gibAus() Methode der äußeren Klasse.
      }
    }
    InnereKlasse2 innereKlasse2 = new InnereKlasse2();
    innereKlasse2.gibAus();
  }
}
