/* Sie bereiten Ihre Model-Klassen zur Verwendung in einer GUI vor. Um die Daten in den GUI Elementen darstellen zu können, brauchen Sie eine Möglichkeit, die Objekte in Strings und aus Strings zurück in die Objekte konvertieren zu können. Die GUI Elemente sind bereits darauf eingestellt, einen String-Konverter zu verwenden.
 * Der String-Konverter ist eine abstrakte, generische Klasse mit dem Namen 'StringConverter'. Verwenden Sie folgende Syntax:
 *  'abstract class StringConverter<T>'
 * Über generische Klassen erfahren Sie zu einem anderen Zeitpunkt mehr. Im Prinzip bedeutet es, dass die Klasse mit beliebigen Typen verwendet werden kann. Diese Typen sind in diesem Fall Ihre Model-Klassen.
 * Die StringConverter-Klasse verfügt über folgende Methoden:
 *  abstract String toString(T obj)
 *  abstract T fromString(String obj)
 *
 * Ihre Model-Klasse 'Mitarbeiter' verfügt über eine öffentliche statische Liste vom Typ Mitarbeiter und die beiden Attribute 'String name' und 'int nummer'. Diese Attribute werden über den Konstruktor beschrieben. Für 'name' gibt es auch noch einen getter.
 *
 * In der 'Mitarbeiter'-Klasse erzeugen Sie ein öffentliches, statisches Feld vom Typ StringConverter und instanziieren eine anonyme Klasse, welche von StringConverter erbt.
 * Die toString-Methode gibt Nummer als String zurück.
 * Die fromString-Methode sucht in der Liste nach einem passenden Objekt entsprechend der übergebenen Nummer als String und gibt dieses Objekt zurück. Wird keins gefunden, wird null zurückgegeben.
 *
 * Zum Testen erstellen Sie vier Mitarbeiter und lassen diese mit der Converter-Methode als String ausgeben.
 * Anschließend fragen Sie über die Konsole eine Nummer als String ab. Es wird der Name des Mitarbeiters mithilfe der fromString-Methode ausgegeben.
 */

package aufgaben;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lösung_3
{
    public static void main(String[] args)
    {
        new Mitarbeiter("Sabine", 100);
        new Mitarbeiter("John", 200);
        new Mitarbeiter("Hakim", 300);
        new Mitarbeiter("Isabella", 400);

        for (Mitarbeiter m : Mitarbeiter.mitarbeiterList)
            System.out.println(Mitarbeiter.converter.toString(m));


        System.out.print("Bitte Mitarbeiternummer eingeben: ");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();

        System.out.println(Mitarbeiter.converter.fromString(eingabe).getName());

    }
}

abstract class StringConverter<T>
{
    abstract String toString(T obj);

    abstract T fromString(String obj);
}

class Mitarbeiter
{
    public static final List<Mitarbeiter> mitarbeiterList = new ArrayList<Mitarbeiter>();

    private String name;
    private int nummer;

    public Mitarbeiter(String name, int nummer)
    {
        this.name = name;
        this.nummer = nummer;
        mitarbeiterList.add(this);
    }

    public String getName()
    {
        return name;
    }

    public static final StringConverter<Mitarbeiter> converter = new StringConverter<Mitarbeiter>()
    {
        @Override
        String toString(Mitarbeiter obj)
        {
            return String.valueOf(obj.nummer);
        }

        @Override
        Mitarbeiter fromString(String s)
        {
            int nummer = Integer.parseInt(s);
            for (Mitarbeiter m : mitarbeiterList)
            {
                if (m.nummer == nummer)
                    return m;
            }

            return null;
        }
    };

}