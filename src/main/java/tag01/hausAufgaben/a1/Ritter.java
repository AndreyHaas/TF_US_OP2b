package tag01.hausAufgaben.a1;

public class Ritter extends Kreatur{

  protected Ritter(String name) {
    super(name);
  }

  @Override
  void angreifen() {
    System.out.println("Ich nutze sein Schwert");
  }
}