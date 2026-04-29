/*  Aufgabe 1-1
 *
 *  - Erstellen Sie das funktionale Interface "Ausgabe" mit der void "ausgeben(String[] daten)"-Methode
 *  - Erstellen Sie die drei void Methoden bildschirm, datei und datenbank mit String[]-Parameter passend zum Interface

 *  - Die drei Methoden sollen jeden String im Array testweise auf der Konsole ausgeben wobei
 *      die Methoden zur Unterscheidung auch das Ziel der Ausgabe mit ausgeben sollen
 *      z.B. System.out.printf("Schreibe %s in die Datenbank...%n", d);
 *  - Testen Sie die Methoden und das Interface im Main, indem Sie dort ein String Array anlegen,
 *      dem Interface die Methoden zuweisen (als Array z.B.) und aufrufen.
 *
 *  Aufgabe 1-2
 *  Modifizieren Sie das Programm so, dass anstelle des eigenen Interfaces "Ausgabe", das in Java bereits vorhandene Interface "Consumer" verwendet wird.
 */

package tag03.aufgaben.loesung_1;

import java.util.Arrays;
import java.util.function.Consumer;

public class Loesung_1
{
    public static void main(String[] args)
    {
        String[] daten = { "Data1", "Data2", "Data3" };

        // 1-1
        Ausgabe[] ausgaben = new Ausgabe[] { Loesung_1::bildschirm, Loesung_1::datei, Loesung_1::datenbank, (d) -> System.out.println("Lambda Ausgabe" + Arrays.toString(d)) };

        for (Ausgabe ausgabe : ausgaben)
            ausgabe.ausgeben(daten);

        System.out.println();

        // 1-2
        Consumer<String[]> consumer =  Loesung_1::bildschirm;
        consumer = consumer.andThen(Loesung_1::datei);
        consumer = consumer.andThen(Loesung_1::datenbank);
        consumer = consumer.andThen((d) -> System.out.println("Lambda Ausgabe" + Arrays.toString(d)));

        consumer.accept(daten);
    }

    static void bildschirm(String[] data)
    {
        System.out.println("Konsole:");
        for (String d : data)
        {
            System.out.printf("Schreibe %s in die Konsole...%n", d);
        }
    }

    static void datei(String[] data)
    {
        System.out.println("Datei:");
        for (String d : data)
        {
            System.out.printf("Schreibe %s in die Datei...%n", d);
        }
    }

    static void datenbank(String[] data)
    {
        System.out.println("Datenbank:");
        for (String d : data)
        {
            System.out.printf("Schreibe %s in die Datenbank...%n", d);
        }
    }
}

