package tag01.hausAufgaben.a4;

public class Video extends Content {

  private final int duration;

  public Video(String title, String author, int duration) {
    super(title, author);
    this.duration = duration;
  }

  private String secInMinUmwandeln(int duration) {
    int min = duration / 60;
    int sec = duration % 60;
    return min + " min. " + sec + " sec.";
  }

  @Override
  public void displayContent() {
    System.out.println(
//        "Video: Titel: " + title + ", Autor: " + author + ", Dauer: " + duration + " Sekunden");
    "Video: Titel: " + title + ", Autor: " + author + ", Dauer: " + secInMinUmwandeln(duration));
  }
}