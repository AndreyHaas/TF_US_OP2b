package tag03.unterricht.functionalInterfacesBeispiel.consumer;

public class Person {
    private String vorname;
    private String nachname;

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void printVornameAndNachname() {
        System.out.println(vorname + " " + nachname);
    }
}
