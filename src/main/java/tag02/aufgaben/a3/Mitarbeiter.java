package tag02.aufgaben.a3;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;

public class Mitarbeiter {

  private static final List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();

  private final String name;
  private final int nummer;

  public Mitarbeiter(String name, int nummer) {
    this.name = name;
    this.nummer = nummer;
    mitarbeiterListe.add(this);
  }

  public String getName() {
    return name;
  }

  public int getNummer() {
    return nummer;
  }

  public static List<Mitarbeiter> getMitarbeiterListe() {
    return mitarbeiterListe;
  }

  public static final StringConverter<Mitarbeiter> CONVERTER = new StringConverter<>() {
    @Override
    public String toString(Mitarbeiter mitarbeiter) {
      return mitarbeiter == null ? StringUtils.EMPTY : String.valueOf(mitarbeiter.getNummer());
    }

    @Override
    public @Nullable Mitarbeiter fromString(String nummer) {
      try {
        int mitarbeiterNummer = Integer.parseInt(nummer);
        for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
          if (mitarbeiter.getNummer() == mitarbeiterNummer) {
            return mitarbeiter;
          }
        }
      } catch (NumberFormatException _) {
        return null;
      }

      return null;
    }
  };
}