package tag01.hausAufgaben.a3;

import java.util.ArrayList;
import java.util.List;

public abstract class Ware {

  private static final List<Ware> warenListe = new ArrayList<>();

  private final String bezeichnung;
  private final double preis;

  protected Ware(String bezeichnung, double preis) {
    this.bezeichnung = bezeichnung;
    this.preis = preis;
    warenListe.add(this);
  }

  public static List<Ware> getWarenListe() {
    return new ArrayList<>(warenListe);
  }

  @Override
  public String toString() {
    return bezeichnung + " - " + String.format("%.2f", preis) + " €";
  }
}