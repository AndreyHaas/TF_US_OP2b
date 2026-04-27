package tag01.hausAufgaben.a4;

public abstract class Content {

  protected String title;
  protected String author;

  protected Content(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public abstract void displayContent();
}