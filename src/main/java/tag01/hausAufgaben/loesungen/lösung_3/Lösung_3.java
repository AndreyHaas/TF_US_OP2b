/* Level 2
Sie betreiben einen Imbiss und möchten eine Verwaltungssoftware für die verkauften Waren erstellen.
 * Die Verkaufsware unterteilt sich in Speisen und Getränke. Alle Waren werden in der Basisklasse, von der kein Objekt erstellt werden darf, in einer Liste gespeichert.
 * Für alle Waren erfassen Sie die Bezeichnung und den Preis. Speisen bestehen zudem aus einer Auflistung der Zutaten, zu Getränken speichern Sie die Füllmenge in Milliliter.
 * Alle benötigten Daten werden über Konstruktoren erfasst.
 * Um alle Waren bequem ausgeben zu können, überschreiben Sie die toString-Methode der Klassen. Dabei vermeiden Sie doppelten Code und beachten die Abkapselung und Trennung von Darstellung und Programmlogik.
 * Zum Testen erstellen Sie ein Getränk, eine Speise und geben alle Informationen auf dem Bildschirm aus.
 *
 * Erstellen Sie dazu ein UML Klassendiagramm.
 */


package tag01.hausAufgaben.loesungen.lösung_3;

import java.util.Arrays;


public class Lösung_3
{
    public static void main(String[] args)
    {
        // Objekte erzeugen
        new Speise("Burger", 4.99, Arrays.asList("Brötchen", "Vegan-Patties", "Gurken", "Ketchup"));
        new Speise("Pizza Groß", 5.99, Arrays.asList("Pizzateig", "Tomatensoße", "Käse", "Salami" ));

        new Getränk("Cola", 1.49, 500);

        // Ausgabe
        for (Verkaufsware ware : Verkaufsware.warenliste)
        {
            System.out.println(ware); // Die toString()-Methode wird automatisch von print und println aufgerufen!
        }
    }
}

