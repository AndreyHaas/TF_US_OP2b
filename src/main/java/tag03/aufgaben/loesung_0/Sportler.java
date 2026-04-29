package tag03.aufgaben.loesung_0;

class Sportler
{
    public void führeAktionAus(Aktion aktion)
    {
        // Prüfen, ob aktion auch vorhanden ist
        if (aktion != null)
            aktion.ausführen(); // Wenn ja, ausführen
    }
}
