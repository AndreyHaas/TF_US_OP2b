package tag01.hausAufgaben.loesungen.lösung_4;

public abstract class Content
{
	protected String title;
	protected String author;

	public Content(String title, String author)
	{
		this.title = title;
		this.author = author;
	}

	public abstract void displayContent();
}
