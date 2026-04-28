package tag02.unterricht;

public class Main {

  public static void main(String[] args) {
    Katze minkie = new Katze();
    minkie.sageMiau();

    Katze englischeKatze = new Katze() {
      @Override
      public void sageMiau() {
        System.out.println("Meow!");
      }
    };

    englischeKatze.sageMiau();
    System.out.println(englischeKatze.getClass().isAnonymousClass());

    Tiger tiger = new Tiger("gelb, braun, orange MIT SCHWARZEN STREIFEN") {
      @Override
      public void fressen() {
        super.fressen();
        System.out.println("Lecker Kekse!!!");
      }

      @Override
      public void sageFellfarbe() {
        System.out.println("Ich bin ein huebscher Tiger. Mein Fell ist " + getFellFarbe());
      }

      public void bruellen() {
        System.out.println("ROARRRGH!!!");
      }
    };

    tiger.sageFellfarbe();
    tiger.fressen();
  }
}
