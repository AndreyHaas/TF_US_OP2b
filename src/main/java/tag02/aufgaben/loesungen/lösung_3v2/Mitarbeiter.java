package aufgaben.lösung_3v2;

import java.util.ArrayList;
import java.util.List;

public class Mitarbeiter
{
    public static final List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();


    public static StringConverter<Mitarbeiter> converter = new StringConverter<Mitarbeiter>()
    {
        @Override
        String toString(Mitarbeiter obj)
        {
            return obj.nummer + "-" + obj.name;
        }

        @Override
        Mitarbeiter fromString(String obj)
        {
            try
            {
                // Das Ergebnis der toString-Methode muss auch von der fromString-Methode verarbeitet werden können. Wenn die toString Nummer UND Name zurückgibt, muss fromString daraus die Nummer extrahieren können.
                // split() kann einen String an dem angegebenen Zeichen trennen und erstellt daraus ein Array.
                String nummerString = obj.split("-")[0]; // An Index 0 steht dann die Nummer.

                int nummer = Integer.parseInt(nummerString);

                // Nach dem Mitarbeiter suchen:
                for (Mitarbeiter m : mitarbeiterListe)
                    if (m.nummer == nummer)
                        return m;
            }
            catch (Exception ex)
            {
                return null;
            }

            return null;
        }
    };


    private int nummer;
    private String name;

    public String getName()
    {
        return name;
    }

    public Mitarbeiter(int nummer, String name)
    {
        this.nummer = nummer;
        this.name = name;
        mitarbeiterListe.add(this);
    }

}
