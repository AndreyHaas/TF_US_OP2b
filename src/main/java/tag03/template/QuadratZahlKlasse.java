package tag03.template;

// Bekanntes Verfahren: wir implementieren das Interface in einer Klasse und verwenden die Instanz-Methode, um eine Quadratzahl zu berechnen.
public class QuadratZahlKlasse implements QuadratZahl
{
    @Override
    public int berechneQuadratZahl(int zahl)
    {
        return zahl * zahl;
    }
}