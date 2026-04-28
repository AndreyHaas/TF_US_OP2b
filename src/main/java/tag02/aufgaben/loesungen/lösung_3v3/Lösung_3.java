package tag02.aufgaben.loesungen.lösung_3v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lösung_3
{
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		new Mitarbeiter("MA1", 1);
		new Mitarbeiter("MA2", 2);
		new Mitarbeiter("MA3", 3);
		new Mitarbeiter("MA4", 4);

		for (Mitarbeiter m : Mitarbeiter.getMitarbeiterList())
		{
			System.out.println(Mitarbeiter.converter.toString(m));
		}

		System.out.print("Nummer: ");
		String nummer = scanner.nextLine();

		Mitarbeiter m = Mitarbeiter.converter.fromString(nummer);
		System.out.println(m.getName());
	}
}

abstract class StringConverter<T>
{
	public abstract String toString(T obj);
	abstract T fromString(String obj);
}

class Mitarbeiter
{
	private static final List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
	public static List<Mitarbeiter> getMitarbeiterList()
	{
		return new ArrayList<>(mitarbeiterList);
	}

	public static final StringConverter<Mitarbeiter> converter = new StringConverter<>()
	{
		@Override
		public String toString(Mitarbeiter obj)
		{
			return String.valueOf(obj.nummer);
		}

		@Override
		Mitarbeiter fromString(String obj)
		{
			// Komplizierte Version:
			//return mitarbeiterList.stream().filter((mitarbeiter -> String.valueOf(mitarbeiter.nummer).equals(obj))).findAny().orElse(null);

			// Einfache Version:
			for (Mitarbeiter m : mitarbeiterList)
				if (String.valueOf(m.nummer).equals(obj))
					return m;

			return null;
		}
	};

	private String name;
	private int nummer;

	public String getName()
	{
		return name;
	}

	public Mitarbeiter(String name, int nummer)
	{
		this.name = name;
		this.nummer = nummer;

		mitarbeiterList.add(this);
	}
}