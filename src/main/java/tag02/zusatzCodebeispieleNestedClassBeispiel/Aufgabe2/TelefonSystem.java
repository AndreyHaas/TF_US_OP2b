package tag02.zusatzCodebeispieleNestedClassBeispiel.Aufgabe2;

public class TelefonSystem {

  public void validiereTelefonnummer(String telefonNummer) {
    final int nummernLaenge = 10;

    class Telefonnummer {

      private String formatierteTelefonnummer;

      Telefonnummer(String telefonNummer) {

        if (telefonNummer.length() == nummernLaenge) {
          this.formatierteTelefonnummer = telefonNummer;
        } else {
          this.formatierteTelefonnummer = null;
        }
      }

      public String getTelefonnummer() {
        return this.formatierteTelefonnummer;
      }

      public void gibEmpfangeneTelefonnummerAus() {
        System.out.println("Empfangene Telefonnummer: " + telefonNummer);
      }
    }
    Telefonnummer telefonnummer = new Telefonnummer(telefonNummer);
    telefonnummer.gibEmpfangeneTelefonnummerAus();

    String hilfe = telefonnummer.getTelefonnummer();

    if (hilfe == null) {
      System.out.println("Die Telefonnummer ist ungültig!");
    } else {
      System.out.println("Die Telefonnummer hat 10 Zeichen und ist daher korrekt");
    }
  }
}