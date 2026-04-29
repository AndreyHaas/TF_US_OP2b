package tag03.aufgaben.loesung_5;

import java.util.ArrayList;
import java.util.List;

class Kunde implements Comparable<Kunde>
{
    public static final List<Kunde> kundeListe = new ArrayList<Kunde>();

    private final int kundennummer;
    private String name;

    public int getKundennummer()
    {
        return kundennummer;
    }

    public Kunde(int kundennummer, String name)
    {
        this.kundennummer = kundennummer;
        this.name = name;
        kundeListe.add(this);
    }

    // Variante mit Comparable
    @Override
    public int compareTo(Kunde obj)
    {
        return Integer.compare(kundennummer, obj.kundennummer);
        //return kundennummer < obj.kundennummer ? -1 : kundennummer == obj.kundennummer ? 0 : 1;
    }

    @Override
    public String toString()
    {
        return "Kdnr: " + kundennummer + " - Name: " + name;
    }
}
