package tag01.hausAufgaben.loesungen.lösung_1.kreatur;

public class Drache extends Kreatur
{
    public Drache(String name)
    {
        super(name);
    }

    @Override
    public void angreifen()
    {
        System.out.println(getClass().getSimpleName() + " " + name + ": Ich spucke Feuer!");
    }
}
