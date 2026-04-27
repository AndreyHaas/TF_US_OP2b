package tag01.hausAufgaben.a3;

import java.util.List;

public class Application {

  public static void main(String[] args) {

    new Speise("Pizza Salami", 8.50, List.of("Teig", "Tomatensauce", "Käse", "Salami"));
    new Speise("Caesar Salad", 6.90, List.of("Salat", "Tomaten", "Gurken", "Dressing"));
    new Getraenk("Cola", 2.50, 500);
    new Getraenk("Mineralwasser", 1.80, 750);

    for (Ware ware : Ware.getWarenListe()) {
      System.out.println(ware);
    }
  }
}