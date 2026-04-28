package tag02.aufgaben.a3;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {

    new Mitarbeiter("Anna Schmidt", 1001);
    new Mitarbeiter("Thomas Weber", 1002);
    new Mitarbeiter("Lisa Hoffmann", 1003);
    new Mitarbeiter("Michael Becker", 1004);

    ausdruecken("Mitarbeiter als String (Nummer)");

    for (Mitarbeiter mitarbeiter : Mitarbeiter.getMitarbeiterListe()) {
      ausdruecken(Mitarbeiter.CONVERTER.toString(mitarbeiter));
    }

    try (Scanner scanner = new Scanner(System.in)) {
      ausdruecken(System.lineSeparator() + "Bitte geben Sie eine Mitarbeiternummer ein: ");

      String userEingabe = scanner.nextLine();

      Mitarbeiter existierenderMitarbeiter = Mitarbeiter.CONVERTER.fromString(userEingabe);

      ausdruecken(existierenderMitarbeiter != null
          ? "Gefundener Mitarbeiter: " + existierenderMitarbeiter.getName()
          : "Kein Mitarbeiter mit der Nummer " + userEingabe + " gefunden.");
    }
  }

  private static void ausdruecken(String text) {
    System.out.println(text);
  }
}