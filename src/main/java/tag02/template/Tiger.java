package tag02.template;

public class Tiger extends Katze
{
    private String fellfarbe;

    public Tiger(String fellfarbe)
    {
        this.fellfarbe = fellfarbe;
    }

    public String getFellfarbe()
    {
        return fellfarbe;
    }

    public void fressen()
    {
        System.out.println("Omnomnom!");
    }

    public void sageFellfarbe()
    {
        System.out.println("Meine Fellfarbe ist: " + fellfarbe);
    }
}
