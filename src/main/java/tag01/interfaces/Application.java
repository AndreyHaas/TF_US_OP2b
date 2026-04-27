package tag01.interfaces;

public class Application {

  public static void main(String[] args) {
    Waschstrasse waschstrasse = new Waschstrasse();
    waschstrasse.waschen(new Auto());
    Elefant benjamin = new Elefant();
    waschstrasse.waschen(benjamin);
  }
}

