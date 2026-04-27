/* Level 1
    Führen Sie bitte zunächst eine abstrakte Klasse 'GeräuscheMacher' ein.
    Diese besitzt nur eine abstrakte Methode 'macheGeräusch' (keine Über-, oder Rückgabewerte).
    Implementieren Sie bitte zusätzlich die Klassen Auto, Hund und Mensch, die von GeräuscheMacher erben.
        Keine dieser Klassen enthält weitere Member.
        Konsolenausgabe von macheGeräusch in Auto:   "Brummmmmm ..."
        Konsolenausgabe von macheGeräusch in Hund:   "Wau Wau Kläff Grrrrr ..."
        Konsolenausgabe von macheGeräusch in Mensch: "Java lernen ist toll!"

    Führen Sie eine Liste vom Typ GeräuscheMacher ein.
    Erstellen Sie von allen drei Subklassen ein Objekt und fügen diese der Liste hinzu.
    Rufen Sie bitte mittels einer foreach-Schleife, für alle Elemente der Liste, die Methode macheGeräusch auf.
*/

package tag01.hausAufgaben.loesungen.lösung_2;

import java.util.ArrayList;
import java.util.List;

public class Lösung_2
{
    public static void main(String[] args)
    {
        List<GeräuscheMacher> geräuscheMacherListe = new ArrayList<GeräuscheMacher>();

        Auto a = new Auto();
        geräuscheMacherListe.add(a);
        Hund h = new Hund();
        geräuscheMacherListe.add(h);
        Mensch m = new Mensch();
        geräuscheMacherListe.add(m);

        for (GeräuscheMacher g : geräuscheMacherListe)
        {
            g.macheGeräusch();
        }
    }
}

