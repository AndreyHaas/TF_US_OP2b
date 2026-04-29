package tag03.template.predicate;

import java.util.ArrayList;
import java.util.List;

public class Person
{
    public static List<Person> personenListe = new ArrayList<Person>();
    private String vorname;

    public Person(String vorname) {
        this.vorname = vorname;
        personenListe.add(this);
    }

    public String getVorname() {
        return vorname;
    }

}
