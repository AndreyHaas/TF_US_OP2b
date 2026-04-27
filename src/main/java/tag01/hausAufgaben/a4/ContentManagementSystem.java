package tag01.hausAufgaben.a4;

public class ContentManagementSystem {

  public static void displayAllContents(Content[] contents) {
    for (Content content : contents) {
      if (content != null) {
        content.displayContent();
      }
    }
  }

  public static void countContentTypes(Content[] contents) {
    int articleCount = 0;
    int videoCount = 0;

    for (Content content : contents) {
      if (content instanceof Article) {
        articleCount++;
      } else {
        videoCount++;
      }
    }

    System.out.println("Anzahl der Artikel: " + articleCount);
    System.out.println("Anzahl der Videos: " + videoCount);
  }

  public static void main(String[] args) {

    Content[] contents = new Content[3];

    contents[0] = new Article(
        "Java Grundlagen",
        "Alice",
        "Einführung in Java. Es ist eine vielseitige Sprache, die für verschiedene Anwendungen genutzt werden kann. "
            +
            "Java ist objektorientiert und plattformunabhängig. Weitere Konzepte werden später erklärt."
    );

    contents[1] = new Video(
        "Java Tutorial",
        "Bob",
        315
    );

    contents[2] = new Article(
        "CSS Tricks",
        "Ayesha",
        "CSS ist eine Stylesheet-Sprache, die verwendet wird, um das Aussehen von Webseiten zu gestalten. "
            +
            "Mit CSS können Sie Farben, Schriftarten, Layouts und vieles mehr anpassen."
    );

    System.out.println(System.lineSeparator());
    displayAllContents(contents);
    System.out.println(System.lineSeparator());
    countContentTypes(contents);
  }
}