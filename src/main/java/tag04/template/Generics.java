package tag04.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

// Zum Thema Generics: https://www.torsten-horn.de/techdocs/java-generics.htm

// Normale Klasse - nicht generisch
class MyClass
{
	// Generische Methode in Nicht-Generischer Klasse.
	// Der Typ-Parameter wird in spitzen Klammern vor dem Rückgabetyp der Methode geschrieben.
	// Der Typ-Parameter kann dann als Rückgabetyp oder Parametertyp verwendet werden.
	// Durch Komma getrennt können mehrere Typ-Parameter angegeben werden.
	public <T, R> R genericMethod(T param1)
	{
		T variable = param1; // Variable mit dem Typ-Parameter als Datentyp.
		System.out.println("Ich bin eine generische Methode und mein Parameter hat jetzt den Typ " + param1.getClass());

		return null;
	}
}

// Generische Klasse
// Syntax: NameDerKlasse<TypVariable>
// Der Bezeichner der Typ-Variable folgt den Regeln der Variablenbezeichnung.
class MyGenericClass<Type>
{
    // Unsere bereits bekannte List ist auch eine generische Klasse/Interface.
    public List<Type> liste = new ArrayList<>();

    // Variable, die den zugewiesenen Typ annehmen wird.
    public Type myVariable;

    // Generisch und Nicht-Generisch können auch gemischt werden!
    public int myIntVariable;

    public MyGenericClass()
    {
        // Generische Typen sind immer Referenztypen, daher kann null zugewiesen werden.
        myVariable = null;
    }

    // Typ-Variable als Datentyp für Parameter.
    public MyGenericClass(Type param)
    {
        myVariable = param;
        System.out.printf("MyVariable %s ist vom Typ %s\n", myVariable, myVariable.getClass().getName());
    }

    public <OtherType> void doSomething(Type param1, OtherType param2)
    {
        System.out.printf("param1 %s ist vom Typ %s\n", param1, param1.getClass().getName());
        System.out.printf("param2 %s ist vom Typ %s\n", param2, param2.getClass().getName());
    }

    public void doSomethingElse(List<? extends MyClass> liste)
    // Wildcards (das ?) können wir beim Erstellen von Variablen generischer Klassen verwenden, um Typ-Einschränkungen vorzunehmen.
    // Hier haben wir neben "extends" auch noch "super" als Auswahl.
    // "extends" erlaubt den angegebenen Typen und alle Subklassen, "super" erlaubt nur den angegebenen Typen und dessen Superklassen.
    {
        for (MyClass mc : liste)
            mc.genericMethod("42"); // Hier kann der Typ der List-Elemente MyClass oder eine Subklasse davon sein, darum können wir die Methoden aus MyClass aufrufen.
    }
}

// Subklasse, um die Schreibweise mit der Wildcard ausprobieren zu können.
class MySubClass extends MyClass
{}

class MyUpperRestrictedGeneric<T extends Number> // extends Number: Einschränkung des Typs. Nun dürfen nur Number und Subklassen davon als Typ verwendet werden
{
    public <X extends Number & Comparable<T>> void myGenericMethod(X param1)
    // Die Einschränkung kann sich auf mehrere Typen beziehen, wobei davon höchstens eins eine Klasse sein darf (wir haben schließlich keine Mehrfachvererbung!)
    {

    }
}

// Generisches Interface mit einer Methode:
interface GenericInterface<T>
{
    void method(T param);
}

// Wird von generischen Klassen geerbt, sollte die erbende Klasse ebenfalls generisch sein, um den Typ-Parameter (der generische Typ) zur Verfügung zu stellen.
// Beispiel: Von ArrayList<> erben.
class MyList<E> extends ArrayList<E>
{
    public String text;
}


public class Generics
{
	public static void main(String[] args)
	{
		MyClass myClass = new MyClass();
		myClass.<Integer, Object>genericMethod(42);
		// Typ-Argumente werden vor den Methodenbezeichner geschrieben.
		// In den meisten Fällen kann bei Methoden der Datentyp weggelassen werden, da er aus dem Kontext automatisch erkannt wird.
		// Typen werden zur Compile-Zeit geprüft und ersetzt. Aus <T> wird <Integer>

		myClass.genericMethod("Hallo Welt"); // Für diesen Methodenaufruf ist <T> vom Typ String.

		//List<double> liste = new ArrayList<>(); // Primitive Typen sind in Generics nicht erlaubt!
		List<Double> liste = new ArrayList<>();
		liste.add(1.2);

        // Bei der Instanziierung von generischen Klassen kann der Datentyp beim Konstruktor weggelassen werden.
        // Das wird dann als "Diamond-Operator" bezeichnet.
        MyGenericClass<Integer> myGenericClassInt = new MyGenericClass<>(2);
        myGenericClassInt.myVariable = 42;
        myGenericClassInt.liste.add(1);
        myGenericClassInt.doSomething(123456789, "1234");

        // Ohne Wildcard liefert diese Zeile einen Fehler:
        // (Wenn wir den Typen der Liste in der Methode nur auf MyClass setzen, darf auch nur eine Liste mit MyClass übergeben werden. Durch die Wildcard mit extends dürfen wir aber auch Listen mit Subklassen von MyClass übergeben)
        myGenericClassInt.doSomethingElse(new ArrayList<MySubClass>());

        //MyUpperRestrictedGeneric<String> myUpperRestrictedGeneric = new MyUpperRestrictedGeneric<String>(); // String ist hier nicht möglich, da T Number sein muss.
        MyUpperRestrictedGeneric<Integer> myUpperRestrictedGeneric = new MyUpperRestrictedGeneric<>(); // Integer erbt von Number, daher ist Integer hier möglich.
        myUpperRestrictedGeneric.myGenericMethod(42); // Integer erbt von Number und implementiert Comparable<Integer>

        // Instanziierung der eigenen Subklasse von ArrayList<>
        MyList<String> stringList = new MyList<>();
        stringList.text = "Meine tolle Liste";
        stringList.add("Hallo Welt");

        // Weitere Beispiele für generische Typen
        Consumer<Integer> consumer;
        HashMap<Integer, String> hashMap = new HashMap<>();
    }
}
