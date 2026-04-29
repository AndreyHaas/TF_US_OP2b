/*
    - Führen Sie bitte die 3 folgenden Methoden ein:
        a) Name:            Sortiere
           Übergabewerte:   String-Array und ein Functional Interface vom Typ PrüfeStrings
           Funktion:        Sortiert das Array nach dem Bubblesort-Verfahren mithilfe einer übergebenen Methode
           Rückgabewert:    keiner
        b) Name:            Ausgabe
           Übergabewerte:   String-Array
           Funktion:        Konsolenausgabe aller Felder
           Rückgabewert:    keiner

    'PrüfeStrings' ist ein funktionales Interface mit der boolean-Methode 'prüfe(String s1, String s2)'

    Im Main
       Führen Sie bitte zunächst ein String-Array 'strings' ein, gefüllt mit den folgenden drei Strings: "Autobahnpolizist", "Grundstücksverkehrsgenehmigungszuständigkeitsübertragungsverordnung", "Ja"
       Lassen Sie den aktuellen Inhalt des Arrays bitte auf der Konsole ausgeben
       Rufen Sie die Methode Sortiere auf (Übergabewerte 'strings' und eine Lambda-Expression - die Lambda-Expression soll zwei Strings vergleichen und true zurückgeben, wenn der erste länger als der zweite ist, sonst false)
       Lassen Sie bitte erneut den aktuellen Inhalt des Arrays auf der Konsole ausgeben
*/

package tag03.aufgaben.loesung_4;

public class Loesung_4
{
    static void Sortiere(String[] strings, PruefeStrings prüfeStrings)
    {
        String hilfe;
        for (int i = strings.length; i > 1; i--)
            for (int j = 0; j < i - 1; j++)
                if (prüfeStrings.prüfe(strings[j], strings[j + 1]))
                {
                    hilfe = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = hilfe;
                }
    }

    static void Ausgabe(String[] strings)
    {
        for (String s : strings)
            System.out.println(s);
    }

    public static void main(String[] args)
    {
        String[] strings = new String[] { "Autobahnpolizist", "Grundstücksverkehrsgenehmigungszuständigkeitsübertragungsverordnung", "Ja" };

        Ausgabe(strings);
        Sortiere(strings, (s1, s2) -> s1.length() > s2.length());
        Ausgabe(strings);
    }
}

