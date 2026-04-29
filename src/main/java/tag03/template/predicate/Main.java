package tag03.template.predicate;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        new Person("Hans");
        new Person("Anja");
        new Person("Tim");
        new Person("Sören");
        new Person("Ayse");

        String anfangsBuchstabe = "A";

        Predicate<Person> kontrolliereNamen = person -> person.getVorname().startsWith(anfangsBuchstabe);
        boolean vorhanden = Person.personenListe.stream().anyMatch(kontrolliereNamen);
        System.out.println("Ist ein Name mit dem Anfangsbuchstaben "+anfangsBuchstabe+" vorhanden true <- Ja / false <- Nein\nAusgabe: "+ vorhanden);

        System.out.println("Ausgabe des Namens aus der Liste: ");
        for (Person person : Person.personenListe)
        {
            if(kontrolliereNamen.test(person))
                System.out.println(person.getVorname());
        }


    }

}
