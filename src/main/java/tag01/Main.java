package tag01;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Statische Polymorphie
    Hund bello = new Hund();
    bello.fressen();
    // und die ueberladene Methode. Der Aufrufer waehlt die Methode indem passende Argumente uebergibt:
    bello.fressen("Trockenfutter");

    // Dynamische Polymorphie verstehen.
    // Bei der dynamischen Polymorphie geht es um Methodenueberladung:
    Tier einTier = new Katze();
    // Katze eineKatze = new Tier(); - funktioniert nicht

    //
    einTier.laufen(); // Es wird die richtige Ueberladung gefunden (es wird die ueberschriebene laufen von Katze
    // gefunden und ausgefuehrt.
    // einTier.sagMiau(); // Die Referenz ist vom Typ Tier. Nicht alle Tiere koennen Miau sagen, darum kommen wir
    // nicht an die sagMiau Methode der Katze.

    einTier = new Hund();
    einTier.laufen();

    List<Tier> tiere = new ArrayList<>();
    tiere.add(einTier);
    tiere.add(new Katze());
    tiere.add(new Hund());

    System.out.println("----------------------------------------------");

    Main.lasseIrgendeinTierWeglaufen(einTier);
    Main.lasseIrgendeinTierWeglaufen(new Katze());
    Main.lasseIrgendeinTierWeglaufen(new Katze());
  }

  public static void lasseIrgendeinTierWeglaufen(Tier einTier) {
    einTier.laufen();
    if (einTier instanceof Katze) {
      ((Katze) einTier).sageMiau();
    }

    Tier tier = Main.erzeugeTier(true);
    Hund einHund = (Hund) tier;
  }

  public static Tier erzeugeTier(boolean moechteHund) {
    if (moechteHund) {
      return new Hund();
    } else {
      return new Katze();
    }
  }
}