package tag01.hausAufgaben.a1;

public class Drache extends Kreatur {

  public Drache(String name) {
    super(name);
  }

  @Override
  void angreifen() {
    System.out.println("Ich spucke Feuer");
  }
}