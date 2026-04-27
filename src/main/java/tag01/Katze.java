package tag01;

public class Katze extends Tier {

  // Das ueberschreiben von Methoden ermoeglicht die dynamische (Laufzeit-) Polymorphie.
  @Override
  public void laufen() {
    System.out.println("Ich schleiche geschmeidig durch die Gegend.");
  }

  public void sageMiau() {
    System.out.println("Miau, Miau");
  }
}