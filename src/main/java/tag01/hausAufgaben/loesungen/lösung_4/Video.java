package tag01.hausAufgaben.loesungen.lösung_4;

public class Video extends Content
{
	private int duration;

	public Video(String title, String author, int duration)
	{
		super(title, author);
		this.duration = duration;
	}

	@Override
	public void displayContent()
	{
		System.out.printf("Video: Titel %s, Autor: %s, Dauer: %d Sekunden", title, author, duration);
	}
}
