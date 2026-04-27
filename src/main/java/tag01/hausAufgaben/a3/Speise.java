package tag01.hausAufgaben.a3;

import java.util.List;

public class Speise extends Ware {

  private final List<String> zutaten;

  public Speise(String bezeichnung, double preis, List<String> zutaten) {
    super(bezeichnung, preis);
    this.zutaten = zutaten;
  }

  @Override
  public String toString() {
    return super.toString() + " | Zutaten: " + String.join(", ", zutaten);
  }
}