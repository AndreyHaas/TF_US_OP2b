package tag02.aufgaben.a2;

public class Application {

  static void drucken(Druckbar... druckbars) {
    for (Druckbar druckbar : druckbars) {
      System.out.println(druckbar.getInfo());
    }
  }

  public static void main(String[] args) {

    Kunde kunde1 = new Kunde("Hans");
    Kunde kunde2 = new Kunde("Jan");

    Druckbar ausdruecken = new Druckbar() {
      @Override
      public String getInfo() {
        return ">";
      }
    };

    drucken(kunde1, ausdruecken, kunde2);
  }
}