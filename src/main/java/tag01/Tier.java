package tag01;

abstract class Tier {

  // Die fressen Methode ist ueberladen und hat damit mehrere Gestalten. Ueberladene Methoden
  // werden auch als statisch polymorph bezeichnet.
  public void fressen() {
    System.out.println("Omnomnom das ist lecker");
  }

  public void fressen(String futter) {
    System.out.println("Omnomnom das " + futter + " schmeckt ausgezeichnet");
  }

  public abstract void laufen();
}