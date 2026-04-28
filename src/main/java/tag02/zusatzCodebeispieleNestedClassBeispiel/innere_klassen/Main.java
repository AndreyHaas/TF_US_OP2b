package tag02.zusatzCodebeispieleNestedClassBeispiel.innere_klassen;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        "//***************************************************** NICHT STATISCHE LOKALE KLASSEN *********************************************************************************\n");
    // Themen: Lokale und anonyme Klassen

    // Lokale Klassen
    // 1. Nicht statische lokale Klassen oder verschachtelte Klassen (englisch: Inner Classes bzw. nested classes)
    // Definition: Innerhalb einer Klasse wird eine neue Klasse definiert.
    // Die Instanziierung der inneren Klasse muss in der äußeren Klasse in einer Methode oder im Konstruktor geschehen.
    // Die innere Klasse kann auf die Member der äußeren Klasse zugreifen und umgekehrt.
    ÄussereKlasse aeussereKlasse = new ÄussereKlasse(); // Instanziierung der äußeren Klasse.

    // Instanziierung der Member der äußeren Klasse:
    aeussereKlasse.name = "Außen";
    aeussereKlasse.äussereZahl = 3;

    // Instanziierung der inneren Klasse und Initialisierung der name-Variable der inneren Klasse (muss zwingend über die äußere Klasse gemacht werden):
    aeussereKlasse.erstelleInnereKlasseUndZeigeQualifiziertenNamen("Innen");

    System.out.println(
        "//*********************************************************** STATISCHE LOKALE KLASSEN *********************************************************************************\n");
    // Statische lokale Klassen werden innerhalb einer anderen Klasse definiert und mit static Keyword qualifiziert. Die statische innere Klasse ist im
    // Unterschied zu nicht statischen lokalen Klassen überall sichtbar und global instanziierbar. Die statische lokale Klasse verweist nicht auf die
    // umgebende, instanzierende  Klasse und kann daher nicht auf deren Member zugreifen.
    // Einziger Unterschied zu normalen Klassen besteht darin, dass der Bezeichner der inneren Klasse als Praefix den Bezeichner der aeußeren Klasse enthaelt:

    ÄussereKlasse3.InnereStatischeKlasse innen = new ÄussereKlasse3.InnereStatischeKlasse();
    innen.gibAus();

    System.out.println(
        "\n //****************************************************** Innere Klassen in Methoden ***********************************************************************************\n");

    // Innere Klassen in Methoden
    // Innere Klassen können in beliebigen Anweisungsblöcken der äußeren Klasse definiert werden und müssen nicht alleine definiert werden. Dadurch bekommt die innere
    // Klasse dann Zugriff auf alle lokalen Variablen des umgebenden Codeblocks. Um den Zugriff zu gewährleisten müssen diese Variablen dann aber mit final als Konstante
    // deklariert werden.
    // Dieses Verfahren wird fast nie verwendet, stattdessen werden in der Regel anonyme Klassen für diese Anwendungsfälle benutzt.
    ÄussereKlasse2 aeussereKlasse2 = new ÄussereKlasse2();
    aeussereKlasse2.gibAus();
  }
}
