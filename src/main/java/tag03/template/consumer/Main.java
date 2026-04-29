package tag03.template.consumer;

import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.function.Consumer;


class Hund
{
    private String name;
    private int alter;

    public Hund(String name, int alter)
    {
        this.name = name;
        this.alter = alter;
    }

    public String getName()
    {
        return name;
    }

    public int getAlter()
    {
        return alter;
    }

    public String getNameAndAlter()
    {
        return name + " " + alter;
    }

}

class Person
{
    private String vorname;
    private String nachname;

    public Person(String vorname, String nachname)
    {

        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname()
    {
        return vorname;
    }

    public String getNachname()
    {
        return nachname;
    }

    public void printVornameAndNachname()
    {
        System.out.println(vorname + " " + nachname);
    }

}

public class Main
{

    public static void main(String[] args)
    {
        // Das FuntktionalInterface Consumer kann man da einsetzen wo man Parameter vergibt aber
        // aber keinen Rückgabewert erwartet.

        BiConsumer<Integer, Float> bic = (a, b) -> System.out.println((a * a) + " " + (b * b));
        bic.accept(5, 5.5f);
        bic.accept(10, 10.5f);
        bic.accept(6, 6.6f);

        BiConsumer<String, Integer> bic2 = (c, d) -> System.out.println(c + "=" + (d + d));
        bic2.accept("Ergebnis", 25);
        bic2.accept("Das Ergebnis der Addition", 12);

        IntConsumer ic = a -> System.out.println(a * a);
        ic.accept(5);
        ic.accept(10);
        ic.accept(6);

        Consumer<Hund> hundConsumer = hund -> System.out.println(hund.getNameAndAlter());
        hundConsumer.accept(new Hund("Bello", 2));
        hundConsumer.accept(new Hund("Argos", 4));

        Consumer<Person> personCS = (Person::printVornameAndNachname);
        personCS.accept(new Person("Ronny", "Miller"));
    }

}
