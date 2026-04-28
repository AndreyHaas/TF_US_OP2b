/*
 * Sie haben eine Methode, mit der Sie Objekte drucken können, welche das Interface 'Druckbar' implementieren. 'Druckbar' verfügt über eine 'getInfo()'-Methode, die, wenn sie in
 * implementierenden Klassen überschrieben wurde, die Infos dieser Klasse als String zurückgibt. Nun möchten Sie zwischen den Ausgaben der Klassen-Infos aber noch extra Platz lassen.
 * Die drucken-Methode und die in der Kunde-Klasse implementierte getInfo-Methode wollen oder können Sie aber nicht ändern.
 *
 * Erstellen Sie das Interface 'Druckbar' mit der String 'getInfo()'-Methode.
 * Erstellen Sie die Klasse 'Kunde' mit dem Attribut 'name', welches über den Konstruktor gefüllt wird.
 * Die Klasse implementiert das Interface und die getInfo-Methode gibt den Namen des Kunden zurück.
 *
 * In Ihrer Main-Klasse erstellen Sie die statische Methode 'void drucken(Druckbar... druckbar)' (Die Schreibweise mit ... nennt sich 'varargs' und ist quasi wie ein Array).
 * Diese Methode wird zu Testzwecken in einer Schleife für alle übergebenen Druckbar-Objekte die getInfo() aufrufen und ausgeben.
 *
 * In der main-Methode erstellen Sie zwei Kunden und eine anonyme Klasse, welche das Interface implementiert. In dieser Implementierung jedoch wird getInfo() nur ">" zurückgeben.
 *
 * Übergeben Sie den ersten Kunden, dann das Objekt der anonymen Klasse und dann den zweiten Kunden an die drucken()-Methode.
 */

package aufgaben;

public class Lösung_2
{
    public static void main(String[] args)
    {
        Kunde kunde1 = new Kunde("Kunde1");
        Kunde kunde2 = new Kunde("Kunde2");
        Druckbar platzhalter = new Druckbar()
        {
            @Override
            public String getInfo()
            {
                return ">";
            }
        };

        //Druckbar[] array = new Druckbar[] {kunde1, platzhalter, kunde2, platzhalter, kunde1, platzhalter, kunde2, platzhalter};
        //drucken(array);
        drucken(kunde1, platzhalter, kunde2, platzhalter, kunde1, platzhalter, kunde2, platzhalter);

    }

    public static void drucken(Druckbar... druckbar)
    {
        System.out.println("Drucke... ");
        for (Druckbar d : druckbar)
            System.out.println(d.getInfo());
    }
}


interface Druckbar
{
    String getInfo();
}

class Kunde implements Druckbar
{
    private String name;

    public Kunde(String name)
    {
        this.name = name;
    }

    @Override
    public String getInfo()
    {
        return name;
    }
}
