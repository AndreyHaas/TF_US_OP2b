package tag01.hausAufgaben.loesungen.lösung_4;
/* Level 2
Stellen Sie sich vor, Sie entwickeln ein Content-Management-System für einen Blog, in dem verschiedene Arten von Inhalten veröffentlicht werden können. Sie sollen die Inhalte in einem Array verwalten und analysieren.

Anforderungen:

    Basisklasse Content:
        Erstellen Sie eine abstrakte Klasse Content mit den folgenden Attributen:
            String title: Der Titel des Inhalts.
            String author: Der Autor des Inhalts.
        Implementieren Sie einen Konstruktor, der den Titel und den Autor initialisiert.
        Fügen Sie eine abstrakte Methode void displayContent() hinzu, die von den Unterklassen implementiert werden soll.

    Unterklassen:
        Erstellen Sie zwei Unterklassen Article und Video, die von Content erben.

    Klasse Article:
        Fügen Sie das Attribut String text hinzu, um den Text des Artikels zu speichern.
        Implementieren Sie den Konstruktor, der den Titel, den Autor und den Text initialisiert.
        Implementieren Sie die Methode displayContent(), um den Titel, den Autor und die ersten 100 Zeichen des Artikels auszugeben.

    Klasse Video:
        Fügen Sie das Attribut int duration hinzu, um die Dauer des Videos in Sekunden zu speichern.
        Implementieren Sie den Konstruktor, der den Titel, den Autor und die Dauer initialisiert.
        Implementieren Sie die Methode displayContent(), um den Titel, den Autor und die Dauer des Videos auszugeben.

    Array-Verwaltung:
        Erstellen Sie ein Array Content[] mit einer Mischung aus Article- und Video-Objekten.
        Implementieren Sie eine Methode displayAllContents(Content[] contents), die die displayContent()-Methode für jedes Content-Objekt im Array aufruft.

    Analyse:
        Implementieren Sie eine Methode countContentTypes(Content[] contents), die die Anzahl der Artikel und Videos im Array zählt und ausgibt.

Erwartete Ausgabe (Beispiel):

Artikel: Titel: Java Grundlagen, Autor: Alice, Text: Einführung in Java. Es ist eine vielseitige Sprache...
Video: Titel: Java Tutorial, Autor: Bob, Dauer: 300 Sekunden
Artikel: Titel: CSS Tricks, Autor: Ayesha, Text: CSS ist eine Stylesheet-Sprache, die verwendet wird...

Anzahl der Artikel: 2
Anzahl der Videos: 1

*/

public class Lösung_4
{
	public static void main(String[] args)
	{
		Content[] contents = new Content[3];
		contents[0] = new Article("Java Grundlagen", "Alice", "На відміну від поширеної думки Lorem Ipsum не є випадковим набором літер. Він походить з уривку класичної латинської літератури 45 року до н.е., тобто має більш як 2000-річну історію. Річард Макклінток, професор латини з коледжу Хемпдін-Сидні, що у Вірджінії, вивчав одне з найменш зрозумілих латинських слів - consectetur - з уривку Lorem Ipsum, і у пошуку цього слова в класичній літературі знайшов безсумнівне джерело. Lorem Ipsum походить з розділів 1.10.32 та 1.10.33 цицеронівського \"de Finibus Bonorum et Malorum\" (\"Про межі добра і зла\"), написаного у 45 році до н.е. Цей трактат з теорії етики був дуже популярним в епоху Відродження.");
		contents[1] = new Video("Java Tutorial", "Bob", 300);
		contents[2] = new Article("CSS Tricks", "Ayesha", "Ogólnie znana teza głosi, iż użytkownika może rozpraszać zrozumiała zawartość strony.");
		// Text von https://uk.lipsum.com/ und https://pl.lipsum.com/

		displayAllContents(contents);
		countContentTypes(contents);
	}

	private static void displayAllContents(Content[] contents)
	{
		for (Content c : contents)
		{
			c.displayContent();
			System.out.println();
		}
	}

	private static void countContentTypes(Content[] contents)
	{
		int articles = 0;
		int videos = 0;

		for (Content c : contents)
		{
			if (c instanceof Article)
				articles++;
			else if (c instanceof Video)
				videos++;
		}

		System.out.println("Anzahl der Artikel: " + articles);
		System.out.println("Anzahl der Videos: " + videos);
	}
}
