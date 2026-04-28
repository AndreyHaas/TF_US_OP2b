package tag02.aufgaben.a0;

public class Application {

  public static void main(String[] args) {
    Kuenstler maler = new Kuenstler() {
      @Override
      void kunstErstellen() {
        System.out.println("Ich male ein Bild");
      }
    };

    Kuenstler saenger = new Kuenstler() {
      @Override
      void kunstErstellen() {
        System.out.println("Ich singe einen Song");
      }
    };

    maler.kunstErstellen();
    saenger.kunstErstellen();
  }
}
