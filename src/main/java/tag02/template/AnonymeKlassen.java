package tag02.template;

// Mithilfe von anonymen Klassen können wir Implementierungen schaffen, die wir nur
// einmalig, sozusagen im Vorbeigehen, lokal verwenden wollen.
// Wenn auf die schnelle eine kleine Klasse gebraucht wird, um kleine Codebestandteile zwischen Programmmodulen auszutauschen,
// dann bekommen anonyme Klassen ihren Sinn.
// Wir verwenden anonyme Klassen dann, wenn eine lokale Klasse nur einmalig verwenden werden soll.
// Namenlose, anonyme Klassen werden gleichzeitig lokal deklariert und instanziiert.
// Der Vorteil anonymer Klassen besteht in ihrer Flexibilität.
// Anonyme Klassen können auf lokale Variablen und Klassenmember ihrer unmittelbaren Umgebung zugreifen und diese weitergeben.
// Werden Klassen umfangreicher und werden diese an verschiedenen Stellen im Code gebraucht, sollte auf anonyme Klassen verzichtet
// und stattdessen eine benannte Klasse definiert und verwendet werden.
// Der häufigste Einsatz anonymer Klassen sind Listener für GUIs.

// Wir können mit zwei Verfahren anonyme Klassen erstellen.
// 1) Wir erweitern bestehende Klassen.
// 2) Wir erstellen uns eine anonyme Klasse, die ein Interface (ohne extends Keyword) implementiert.

// Anonyme Klassen bestehen aus diesen Elementen:
// -> Den new Operator.
// -> Den Namen des Interfaces welches implementiert werden soll oder den Namen der Klasse die erweitert werden soll.
// -> Runde Klammern welche die Argumente für den Konstruktor beinhalten, wie bei normaler Klassenerstellung. Oder leere Klammern für Interfaces.
// -> Geschwungene Klammern für den Körper der anonymen Klasse, in der wir die Logik implementieren, indem wir die Methoden der erweiterten Klasse / Interface überschreiben.
// -> Abschließend setzen wir hinter die schließende Klammer ein Semikolon.

public class AnonymeKlassen
{
    public static void main(String[] args)
    {
        // Bekannt: Instanziierung einer Klasse und Aufruf ihrer Methode:
        Katze katze = new Katze();
        katze.macheMiau();

        // 1. Wir erweitern eine bestehende nicht-abstrakte Klasse:
        // Durch Hinzufügen von geschwungenen Klammern nach dem Konstruktoraufruf erstellen wir eine neue anonyme Klasse.
        // z.B. new Katze() { };
        // Wir erweitern damit die Klasse und können die 'macheMiau()'-Methode überschreiben.
        // Hier ist 'englischeKatze' die Referenz auf die Instanz der anonymen Klasse.
        Katze englischeKatze = new Katze()
        {
            @Override
            public void macheMiau()
            {
                System.out.println("Meow!"); // Neue Implementierung der 'macheMiau()'-Methode.
            }
        };

		englischeKatze.macheMiau(); // Aufruf der in der anonymen Klasse überschriebenen Methode.
		// Über Reflection den Namen der Klasse abfragen:
		System.out.println(katze.getClass());
		System.out.println(katze.getClass().getSimpleName());
		System.out.println(englischeKatze.getClass()); // Intern wird der anonymen Klasse der Bezeichner '1' vergeben.
		System.out.println(englischeKatze.getClass().getSimpleName()); // Die Klasse hat keinen Namen und somit wird hier ein Leerstring ausgegeben.
		System.out.println(englischeKatze.getClass().isAnonymousClass()); // true

        // Wir können die Methoden der anonymen Klasse auch ohne Referenz-Variable über den Punkt-Operator aufrufen:
        new Katze()
        {
            @Override
            public void macheMiau()
            {
                System.out.println("Miaaaw!");
            }
        }.macheMiau();

        // Hinweis: Der Aufruf der Member direkt bei der Instanziierung ohne Variable geht immer für alle Klassen.
        new Katze().macheMiau();


        // Komplexeres Beispiel mit eigenem Konstruktor und mehreren Methoden:
        // Wir erweitern die bestehende Klasse als anonyme Klasse.
        Tiger tiger = new Tiger("gelb, braun, orange mit schwarzen Streifen")
        {
            // Wir überschreiben 'fressen()' und 'sageFellfarbe()':
            @Override
            public void fressen()
            {
                super.fressen();
                System.out.println("Lecker Kekse!!!");
            }

            @Override
            public void sageFellfarbe()
            {
                System.out.println("Ich bin ein hübscher Tiger. Mein Fell ist " + getFellfarbe());

                brüllen(); // Wir können diese neue Methode nicht über eine Referenz-Variable aufrufen, aber natürlich innerhalb der anonymen Klasse.
            }

            // Wir können diese anonyme Klasse durch beliebige weitere Member ergänzen:
            // ACHTUNG: Der Datentyp 'Tiger' kennt diese Methode nicht! Da wir nicht casten können (denn der Typ der Subklasse ist unbekannt), können wir diese Methode nachträglich nicht über Referenz-Variablen aufrufen.
            public void brüllen()
            {
                System.out.println("ROAR!!!");
            }
        };

        tiger.fressen();
        tiger.sageFellfarbe();
        tiger.macheMiau();
        //tiger.brüllen(); // Der Datentyp 'Tiger' kennt die Methode nicht!

        // Wie wir am vorherigen Beispiel gesehen haben, können neue Methoden nicht über die Referenz-Variable aufgerufen werden. ABER sie können während der Instanziierung aufgerufen werden.
        new Katze()
        {
            public void schnurren()
            {
                System.out.println("Schnurr...");
            }
        }.schnurren();


        // 2. Wir erweitern eine abstrakte Klasse:
        //Lebewesen löwe = new Lebewesen(); // Wir können abstrakte Klassen und Interfaces nicht direkt instanziieren.
        // Um Objekte davon erzeugen zu können, benötigen wir eine nicht-abstrakte Klasse, welche die abstrakte Klasse erweitert.
        // Das lässt sich als anonyme Klasse umsetzen:
        Lebewesen löwe = new Lebewesen()
        {
            // Wir müssen die abstrakte Methode überschreiben:
            @Override
            public void macheGeräusch()
            {
                System.out.println("Brüllgeräusche!");
            }
        };

        löwe.macheGeräusch();


        // 3. Wir implementieren ein Interface:
        //Fahrbar pkw = new Fahrbar();
        Fahrbar pkw = new Fahrbar()
        {
            @Override
            public void fahren()
            {
                System.out.println("Brumm...");
            }
        };

        pkw.fahren();

		// Typischer Anwendungsfall: Aufruf einer Methode, welche ein Objekt einer abstrakten Klasse oder eines Interfaces erwartet.
		// Hier erzeugen wir eine anonyme Klasse direkt als Argument für die Methode. Dabei wird von der anonymen Klasse ein Objekt erzeugt und dem Parameter der Methode zugewiesen.
		ausgabe(new Lebewesen()
		{
			@Override
			public void macheGeräusch()
			{
				System.out.println("Ich bin ein Lebewesen.");
			}
		});


        // Später in der GUI Entwicklung werden wir auf viele Methoden treffen, die als Parameter Interfaces oder abstrakte Klassen entgegennehmen.
        // Dort wird dieses Muster der Erstellung anonymer Klassen häufig verwendet.
        // Ein Beispiel aus der Gui Entwicklung:
        // Hier erschaffen wir uns eine anonyme Klasse vom Typ EventHandler und überschreiben die handle Methode.
        /*
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                   System.out.println("Hello World!");
                }
            });
        */


        // Hinweis zu inneren / lokalen Klassen (nested classes):
        // Wenn wir anonyme Klassen erzeugen, erzeugen wir damit innere Klassen. Diese Klassen können auf Member der äußeren Klasse zugreifen.
        AnonymeKlassen.InnereKlasse iK = new InnereKlasse();
        iK.printText(); // Diese innere Klasse kann auf das private statische Field der äußeren Klasse zugreifen.
        new InnereKlasse()
        {
            @Override
            public void printText()
            {
                System.out.println(text); // und auch als anonyme Klasse kann hier auf das private Field 'text' der äußeren Klasse zugegriffen werden.
            }
        };


    } // Hier ist die main() zu Ende!

	// Eine Methode, die ein Objekt einer abstrakten Klasse als Argument entgegennimmt. Beim Aufruf dieser Methode können wir dann ein Objekt einer anonymen Sub-Klasse übergeben.
	public static void ausgabe(Lebewesen lebewesen)
	{
		lebewesen.macheGeräusch();
	}


    // Hinweis zu inneren / lokalen Klassen (nested classes):
    private static final String text = "Ich bin ein statisches Field der 'AnonymeKlassen'-Klasse.";

    public static class InnereKlasse
    {
        public void printText()
        {
            System.out.println(text); // Innere Klassen können auf Member der äußeren Klasse zugreifen!
        }
    }
}
