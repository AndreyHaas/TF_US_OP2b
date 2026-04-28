package tag02.zusatzCodebeispieleNestedClassBeispiel.innere_klassen;

// HINWEIS: Die Kommentare und Erläuterungen befinden sich hauptsächlich in der Main() Methode!

// Beispiel für innere Klassen.
// 1. Nicht statische lokale Klassen (englisch: Inner Classes)
// Definition: Innerhalb einer Klasse wird eine neue Klasse definiert.
// Die Instanziierung der inneren Klasse muss in der äußeren Klasse in einer Methode oder im Konstruktor geschehen.
// Die innere Klasse kann auf die Member der äußeren Klasse zugreifen und umgekehrt.
public class ÄussereKlasse {

  String name;
  int äussereZahl;

  // Die Instanziierung der inneren Klasse muss in der äußeren Klasse in einer Methode oder im Konstruktor geschehen:
  public void erstelleInnereKlasseUndZeigeQualifiziertenNamen(String nameInnereKlasse) {
    InnereKlasse innereKlasse = new InnereKlasse();
    innereKlasse.name = nameInnereKlasse;
    System.out.println(innereKlasse.getVollQualifiziertenNamen());
  }

  // Definition der inneren Klasse:
  class InnereKlasse {

    private String name;

    // Die innere Klasse kann auf die Member der äußeren Klasse zugreifen und umgekehrt.
    // Der Compiler sucht erst lokal nach der Variable, wird sie lokal nicht gefunden dann wird in der lokalen (innere Klasse) gesucht.
    // Wird die Variable auch hier nicht gefunden, wird der Compiler auch in den äußeren, umfassenden Klassen nach der Variable suchen.
    private String getVollQualifiziertenNamen() {

      // Variable name der inneren Klasse verdeckt die Variable name der äußeren Klasse.
      // Um auf die gleichlautende name-Variable der äußeren Klasse zugreifen zu können verwenden wir das Präfix Klassenname.this, ansonsten könnte der Compiler nur
      // auf die innere name-Variable zugreifen. Klassenname.this bezeichnet die Instanz der äußeren Klasse.
      return äussereZahl + " - Qualifizierter Name:" + ÄussereKlasse.this.name + "." + name;
    }
  }
}