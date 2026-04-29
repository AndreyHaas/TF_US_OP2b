package template.function.bsp2;

import java.util.ArrayList;
import java.util.List;

public class Daten
{
    public static final List<Daten> datenListe = new ArrayList<Daten>();
    private int id = 0;

    private static int zähler = 0;
    private int zahl;

    public Daten( int zahl) {
        zähler++;
        id = zähler;
        this.zahl = zahl;
        datenListe.add(this);
    }

    public int getId() {
        return id;
    }

    public int getZahl() {
        return zahl;
    }
}
