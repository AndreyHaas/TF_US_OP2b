import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        // Statische Polymorphie
        Hund bello = new Hund();
        bello.fressen();
        // und die ueberladene Methode. Der Aufrufer waehlt die Methode indem passende Argumente uebergibt:
        bello.fressen("Trockenfutter");

        // Dynamische Polymorphie verstehen.
        // Bei der dynamischen Polymorphie geht es um Methodenueberladung:
        Tier einTier = new Katze();
        // Katze eineKatze = new Tier();

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

    public static void lasseIrgendeinTierWeglaufen(Tier einTier)
    {
        einTier.laufen();
        if( einTier instanceof Katze)
        {
            ((Katze)einTier).sageMiau();
        }

       Tier tier = Main.erzeugeTier(true);
        Hund einHund = (Hund)tier;

    }

    public static Tier erzeugeTier(boolean moechteHund)
    {
        if(moechteHund)
        {
            return new Hund();
        }
        else
        {
            return new Katze();
        }
    }
}

abstract class Tier
{
    // Die fressen Methode ist ueberladen und hat damit mehrere Gestalten. Ueberladene Methoden
    // werden auch als statisch polymorph bezeichnet.
    public void fressen()
    {
        System.out.println("Omnomnom das ist lecker");
    }

    public void fressen(String futter)
    {
        System.out.println("Omnomnom das " + futter + " schmeckt ausgezeichnet");
    }
    public abstract void laufen();
}

// Erbende Klassen duerfen nicht die Elternklassen einschraenken, sondern sollen diese erweitern.
class Hund extends Tier
{
    @Override
    public void laufen()
    {
        System.out.println("Ich bin ein Hund und trampel durch die Gegend");
    }

    public void bellen()
    {
        System.out.println("Wuff, wau, wau!");
    }
}

class Katze extends Tier
{
    // Das ueberschreiben von Methoden ermoeglicht die dynamische (Laufzeit-) Polymorphie.
    @Override
    public void laufen()
    {
        System.out.println("Ich schleiche geschmeidig durch die Gegend.");
    }

    public void sageMiau()
    {
        System.out.println("Miau, Miau");
    }
}