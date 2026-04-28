package aufgaben.lösung_3v2;
/* Sie bereiten Ihre Model-Klassen zur Verwendung in einer GUI vor. Um die Daten in den GUI Elementen darstellen zu können, brauchen Sie eine Möglichkeit,
 * die Objekte in Strings und aus Strings zurück in die Objekte konvertieren zu können. Die GUI Elemente sind bereits darauf eingestellt, einen String-Konverter zu verwenden.
 * Der String-Konverter ist eine abstrakte, generische Klasse mit dem Namen 'StringConverter'. Verwenden Sie folgende Syntax:
 *  'abstract class StringConverter<T>'
 * Über generische Klassen erfahren Sie zu einem anderen Zeitpunkt mehr. Im Prinzip bedeutet es, dass die Klasse mit beliebigen Typen verwendet werden kann.
 * Diese Typen sind in diesem Fall Ihre Model-Klassen.
 * Die StringConverter-Klasse verfügt über folgende Methoden:
 *  abstract String toString(T obj)
 *  abstract T fromString(String obj)
 *
 * Ihre Model-Klasse 'Mitarbeiter' verfügt über eine öffentliche statische Liste vom Typ Mitarbeiter und die beiden Attribute 'String name' und 'int nummer'.
 * Diese Attribute werden über den Konstruktor beschrieben. Für 'name' gibt es auch noch einen getter.
 *
 * In der 'Mitarbeiter'-Klasse erzeugen Sie ein öffentliches, statisches Feld vom Typ StringConverter und instanziieren eine anonyme Klasse, welche von StringConverter erbt.
 * Die toString-Methode gibt Nummer als String zurück.
 * Die fromString-Methode sucht in der Liste nach einem passenden Objekt entsprechend der übergebenen Nummer als String und gibt dieses Objekt zurück.
 * Wird keins gefunden, wird null zurückgegeben.
 *
 * Zum Testen erstellen Sie vier Mitarbeiter und lassen diese mit der Converter-Methode als String ausgeben.
 * Anschließend fragen Sie über die Konsole eine Nummer als String ab. Es wird der Name des Mitarbeiters mithilfe der fromString-Methode ausgegeben.
 */


import java.util.Scanner;

public class lösung_3
{
    public static void main(String[] args)
    {
        new Mitarbeiter(1, "Mitarbeiter 1");
        new Mitarbeiter(2, "Mitarbeiter 2");
        new Mitarbeiter(3, "Mitarbeiter 3");
        new Mitarbeiter(4, "Mitarbeiter 4");

        for (Mitarbeiter m : Mitarbeiter.mitarbeiterListe)
            System.out.println(Mitarbeiter.converter.toString(m));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nummer: ");
        String nummer = scanner.nextLine();

        Mitarbeiter mitarbeiter = Mitarbeiter.converter.fromString(nummer);
        if (mitarbeiter != null)
            System.out.println(mitarbeiter.getName());
        else
            System.out.println("Nicht gefunden!");

    }


}
