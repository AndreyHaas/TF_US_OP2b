package tag02.unterricht;

public class Tiger extends Katze {

  private String fellFarbe;

  public Tiger(String fellFarbe) {
    this.fellFarbe = fellFarbe;
  }

  public String getFellFarbe() {
    return fellFarbe;
  }

  public void fressen() {
    System.out.println("Omnomnom!");
  }

  public void sageFellfarbe() {
    System.out.println("Meine Fellfarbe ist " + fellFarbe);
  }
}