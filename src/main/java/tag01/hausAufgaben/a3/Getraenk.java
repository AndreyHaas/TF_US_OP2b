package tag01.hausAufgaben.a3;

public class Getraenk extends Ware {

  private final int fuellmenge;

  public Getraenk(String bezeichnung, double preis, int fuellmenge) {
    super(bezeichnung, preis);
    this.fuellmenge = fuellmenge;
  }

  @Override
  public String toString() {
    return super.toString() + " | " + fuellmenge + " ml";
  }
}