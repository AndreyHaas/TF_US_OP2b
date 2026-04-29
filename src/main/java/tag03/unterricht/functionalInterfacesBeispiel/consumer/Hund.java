package tag03.unterricht.functionalInterfacesBeispiel.consumer;

public class Hund {
    private String name;
    private int alter;

    public Hund(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public String getNameAndAlter() {
        return name + " " + alter;
    }

}
