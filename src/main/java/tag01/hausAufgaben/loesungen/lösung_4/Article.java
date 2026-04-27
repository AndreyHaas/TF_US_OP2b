package tag01.hausAufgaben.loesungen.lösung_4;

public class Article extends Content
{
	private String text;

	public Article(String title, String author, String text)
	{
		super(title, author);
		this.text = text;
	}

	@Override
	public void displayContent()
	{
		System.out.printf("Artikel: Titel %s, Autor: %s, Text: %s", title, author, text.length() > 100 ? text.substring(0, 100) + "..." : text);
	}
}
