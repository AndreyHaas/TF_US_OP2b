package tag03.unterricht;

public class Rechner implements IZahlKonsumierer {
    @Override
    public int konsumiereZahl(int zahl) {
        return zahl * zahl;
    }
}
