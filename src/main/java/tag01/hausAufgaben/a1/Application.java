package tag01.hausAufgaben.a1;

public class Application {

  public static void main(String[] args) {
    Ritter ritter = new Ritter("Lancelot");
    ritter.angreifen();
    Drache drache = new Drache("Fuerspucker");
    drache.angreifen();
  }
}