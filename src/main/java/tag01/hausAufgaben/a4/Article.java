package tag01.hausAufgaben.a4;

public class Article extends Content {

  private final String text;

  public Article(String title, String author, String text) {
    super(title, author);
    this.text = text;
  }

  @Override
  public void displayContent() {
    String erste100Zeichen = text.length() > 100
        ? text.substring(0, 100) + "..."
        : text;

    System.out.println(
        "Artikel: Titel: " + title + ", Autor: " + author + ", Text: " + erste100Zeichen);
  }
}