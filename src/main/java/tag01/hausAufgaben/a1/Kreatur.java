package tag01.hausAufgaben.a1;

public abstract class Kreatur {
  protected String name;

  abstract void angreifen();

  protected Kreatur(String name) {
    this.name = name;
  }
}