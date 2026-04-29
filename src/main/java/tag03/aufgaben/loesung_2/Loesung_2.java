/*
    - Führen Sie bitte zunächst ein funktionales Interface 'PrüfeStrings' ein mit der Methode 'prüfen' (übergabewerte: 2 Strings, Rückgabewert: boolean)
    - Fügen Sie bitte ferner die 4 folgenden statischen Methoden z.B. der Main-Klasse hinzu:
        a) Name:            A_IstLängerAls_B
           Übergabewerte:   2 Strings A und B
           Funktion:        Ermittelt die Länge beider Strings
           Rückgabewert:    true, FALLS A länger als B, SONST false
        b) Name:            A_hatMehrEAls_B
           Übergabewerte:   2 Strings A und B
           Funktion:        Ermittelt die Anzahl der (großen oder kleinen) E´s beider Strings
           Rückgabewert:    true, FALLS A mehr E´s (bzw. e´s) als B hat, SONST false
        c) Name:            Sortiere
           Übergabewerte:   String-Array und ein Interface vom Typ PrüfeStrings
           Funktion:        Sortiert das Array nach dem Bubblesort-Verfahren bzgl. des übergebenen Interfaces [siehe Erläuterung(*)]
           Rückgabewert:    keiner
        d) Name:            Ausgabe
           Übergabewerte:   String-Array
           Funktion:        Konsolenausgabe aller Felder (wählen Sie selbst ein Layout nach ihren Vorlieben :-)
           Rückgabewert:    keiner

    Im Main
       Führen Sie bitte zunächst ein String-Array 'arr' ein, gefüllt mit den folgenden drei Strings:
            "Dampfschifffahrtsgesellschaft", "EDV", "Schneeeule"
       Lassen Sie den aktuellen Inhalt des Arrays bitte auf der Konsole ausgeben
       Führen Sie bitte ferner ein Objekt des Interfaces 'PrüfeStrings' ein und initialisieren dieses mit dem Verweis auf 'A_IstLängerAls_B'
       Rufen Sie anschließend bitte die Methode Sortiere auf (Übergabewerte arr und das Interface-Objekt)
       Lassen Sie bitte erneut den aktuellen Inhalt des Arrays auf der Konsole ausgeben
       Überschreiben Sie daraufhin bitte das Interface-Objekt mit dem Verweis auf 'A_hatMehrEAls_B'
       Rufen Sie daraufhin bitte erneut die Methode Sortiere auf
       Lassen Sie bitte auch diesmal den aktuellen Inhalt des Arrays auf der Konsole ausgeben

    (*)ERLÄUTERUNG:
       Beim Bubblesort wird pro Durchlauf der inneren Schleife entschieden, ob für zwei benachbarte Elemente 'A' und 'B' gilt: A>B ...
       ... A>B ist eine Frage der Betrachtung: Es kann alphabetisch gemeint sein, oder bzgl. der Wortlänge, oder der Anzahl der E´s ...
       Genau dies kann durch die übergebene Interface-Implementierung entschieden werden!

*/


package tag03.aufgaben.loesung_2;

public class Loesung_2
{
    static boolean A_IstLängerAls_B(String A, String B)
    {
        return A.length() > B.length();
    }

    static boolean A_hatMehrEAls_B(String A, String B)
    {
        int Azähler = 0;
        for (int i = 0; i < A.length(); i++)
            if (A.charAt(i) == 'e' || A.charAt(i) == 'E')
                Azähler++;
        int Bzähler = 0;
        for (int i = 0; i < B.length(); i++)
            if (B.charAt(i) == 'e' || B.charAt(i) == 'E')
                Bzähler++;

        return Azähler > Bzähler;
    }

    static void sortiere(String[] arr, PruefeStrings d)
    {
        String hilfe;
        for (int i = arr.length; i > 1; i--)
            for (int j = 0; j < i - 1; j++)
                if (d.prüfe(arr[j], arr[j + 1]))
                {
                    hilfe = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = hilfe;
                }
    }

    static void ausgabe(String[] arr)
    {
        System.out.println("Aktueller Inhalt des Arrays:");
        for (String s : arr) System.out.print(s + " ");
        System.out.println("\n");
    }

    public static void main(String[] args)
    {
        String[] arr = new String[] { "Dampfschifffahrtsgesellschaft", "EDV", "Schneeeule" };
        ausgabe(arr);

        //PrüfeStrings prüfeStrings = Lösung_2::A_IstLängerAls_B;
        PruefeStrings prüfeStrings = (s1, s2) -> s1.length() > s2.length();
        sortiere(arr, prüfeStrings);
        ausgabe(arr);

        prüfeStrings = Loesung_2::A_hatMehrEAls_B;
        sortiere(arr, prüfeStrings);
        ausgabe(arr);
    }
}
