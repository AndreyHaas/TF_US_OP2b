package tag01;

// Erbende Klassen duerfen nicht die Elternklassen einschraenken, sondern sollen diese erweitern.
public class Hund extends Tier {

  @Override
  public void laufen() {
    System.out.println("Ich bin ein Hund und trampel durch die Gegend");
  }

  public void bellen() {
    System.out.println("Wuff, wau, wau!");
  }
}
