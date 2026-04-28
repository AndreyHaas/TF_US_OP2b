package tag02.aufgaben.a2;

public class Kunde implements Druckbar {
  private String name;

  public Kunde(String name) {
    this.name = name;
  }

  @Override
  public String getInfo() {
    return name;
  }
}