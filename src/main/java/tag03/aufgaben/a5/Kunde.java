package tag03.aufgaben.a5;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Kunde {
    private static final List<Kunde> kundenListe = new ArrayList<>();
    private final Integer kundennummer;
    private String name;

    public Kunde(Integer kundennummer, String name) {
        this.kundennummer = kundennummer;
        this.name = name;
        kundenListe.add(this);
    }

    public Integer getKundennummer() {
        return kundennummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Kunde> getKundenListe() {
        return kundenListe;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
                .add("kundennummer=" + kundennummer)
                .add("name='" + name + "'")
                .toString();
    }
}