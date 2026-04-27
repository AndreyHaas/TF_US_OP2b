package tag01.hausAufgaben.loesungen.lösung_1.kreatur;

public class Ritter extends Kreatur
{
    public Ritter(String name)
    {
        super(name);
    }

    @Override
    public void angreifen()
    {
        System.out.println(getClass().getSimpleName() + " " + name + ": Ich schlage mit meinem Schwert!");
    }
}
