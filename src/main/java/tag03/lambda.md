# Lambda-Ausdrücke, Funktionale Interfaces & Methodenreferenzen in Java

## Einleitung: Das Problem vor Java 8

Früher (vor Java 8) war es sehr umständlich, Verhalten (also Code) als Parameter an eine Methode zu übergeben. Man musste immer eine ganze Klasse erstellen oder ein anonymes Objekt eines Interfaces.

```java
// Alter Stil (vor Java 8)
Button button = new Button();
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Geklickt!");
    }
});
```

Das ist sehr viel **Boilerplate-Code** (unnötiger Wiederholungscode). Mit Java 8 wurde das viel einfacher.

---

## 1. Lambda-Ausdrücke – Code als Daten

Ein **Lambda-Ausdruck** ist im Grunde eine **kurze Schreibweise für eine Methode**. Man kann ihn sich wie eine "herumgereichte Funktion" vorstellen.

### Die Syntax

```java
(Parameter) -> { Ausführung }
```

Oder ganz kurz: `() -> System.out.println("Hallo")`

### Einfachste Form

```java
// Lambda ohne Parameter
() -> System.out.println("Hallo Welt");

// Lambda mit einem Parameter
name -> System.out.println("Hallo " + name);

// Lambda mit mehreren Parametern
(a, b) -> a + b;

// Lambda mit mehreren Anweisungen (geschweifte Klammern + return nötig)
(a, b) -> {
    int sum = a + b;
    System.out.println("Summe ist: " + sum);
    return sum;
};
```

### Wofür braucht man Lambdas?

Lambdas werden immer dann verwendet, wenn eine Methode erwartet, dass man ihr **Verhalten** mitgibt. Zum Beispiel:

- `list.forEach(...)` – Was soll mit jedem Element passieren?
- `list.sort(...)` – Nach welcher Regel soll sortiert werden?
- `list.removeIf(...)` – Welche Elemente sollen gelöscht werden?

---

## 2. Funktionale Interfaces – Das Rückgrat der Lambdas

Ein **funktionales Interface** ist ein Interface mit **genau einer abstrakten Methode**.

```java
@FunctionalInterface  // Optional, aber empfehlenswert
interface MeinInterface {
    void tuWas();  // Nur EINE abstrakte Methode
}
```

Das Besondere: Ein Lambda-Ausdruck kann überall dort verwendet werden, wo ein solches funktionales Interface erwartet wird.

> **Merke:** Ein Lambda ist eine kurze Schreibweise für die Implementierung eines funktionalen Interfaces.

### Beispiel: Eigenes funktionales Interface

```java
@FunctionalInterface
interface Begruesser {
    void begruesse(String name);
}

public class Main {
    public static void main(String[] args) {
        // Lambda für das Interface
        Begruesser gruss = (name) -> System.out.println("Hallo " + name);
        
        gruss.begruesse("Anna");  // Ausgabe: Hallo Anna
    }
}
```

---

## 3. Die wichtigsten vordefinierten funktionalen Interfaces

Java stellt viele fertige funktionale Interfaces in `java.util.function` bereit. Die wichtigsten sind:

| Interface | Methode | Beschreibung |
|-----------|---------|--------------|
| `Predicate<T>` | `boolean test(T t)` | Prüft eine Bedingung |
| `Consumer<T>` | `void accept(T t)` | Führt eine Aktion aus (ohne Rückgabe) |
| `Supplier<T>` | `T get()` | Liefert etwas (ohne Parameter) |
| `Function<T,R>` | `R apply(T t)` | Wandelt T in R um |
| `Comparator<T>` | `int compare(T a, T b)` | Vergleicht zwei Objekte |

### Beispiele für jedes Interface

```java
import java.util.function.*;

public class Demo {
    public static void main(String[] args) {
        
        // Predicate: Prüft eine Bedingung
        Predicate<String> istLang = s -> s.length() > 5;
        System.out.println(istLang.test("Hallo"));  // false (5 ist nicht > 5)
        
        // Consumer: Führt eine Aktion aus
        Consumer<String> ausgabe = s -> System.out.println(s);
        ausgabe.accept("Hallo Welt");  // Ausgabe: Hallo Welt
        
        // Supplier: Liefert einen Wert
        Supplier<Double> zufall = () -> Math.random();
        System.out.println(zufall.get());  // z.B. 0.473829
        
        // Function: Wandelt um
        Function<String, Integer> laenge = s -> s.length();
        System.out.println(laenge.apply("Java"));  // 4
        
        // Comparator: Vergleicht
        Comparator<String> nachLaenge = (a, b) -> a.length() - b.length();
        System.out.println(nachLaenge.compare("Haus", "Baum"));  // -1 (Haus ist kürzer)
    }
}
```

---

## 4. Methodenreferenzen – Noch kürzer

Eine **Methodenreferenz** ist eine verkürzte Schreibweise für ein Lambda, das **nur eine einzige Methode aufruft**.

### Die Syntax im Überblick

| Art | Syntax | Beispiel |
|-----|--------|----------|
| Referenz auf statische Methode | `Klasse::methode` | `Math::max` |
| Referenz auf Instanzmethode eines bestimmten Objekts | `objekt::methode` | `systemOut::println` |
| Referenz auf Instanzmethode eines beliebigen Objekts (Parametertyp) | `Klasse::instanzMethode` | `String::length` |
| Referenz auf Konstruktor | `Klasse::new` | `ArrayList::new` |

### Beispiele

```java
import java.util.Arrays;
import java.util.List;

public class Methodenreferenzen {
    
    // Eine statische Methode
    public static void sagHallo(String name) {
        System.out.println("Hallo " + name);
    }
    
    // Eine Instanzmethode
    public void sagTschuess(String name) {
        System.out.println("Tschüss " + name);
    }
    
    public static void main(String[] args) {
        List<String> namen = Arrays.asList("Anna", "Ben", "Clara");
        
        // 1. Lambda (normal)
        namen.forEach(name -> System.out.println(name));
        
        // 2. Methodenreferenz auf statische Methode
        namen.forEach(Methodenreferenzen::sagHallo);
        
        // 3. Methodenreferenz auf Instanzmethode eines Objekts
        Methodenreferenzen objekt = new Methodenreferenzen();
        namen.forEach(objekt::sagTschuess);
        
        // 4. Methodenreferenz auf Instanzmethode des Parametertyps
        namen.forEach(String::toUpperCase);  // NICHT: System.out::println? Vorsicht!
        
        // 5. Referenz auf Konstruktor
        Supplier<List<String>> listenFabrik = ArrayList::new;
        List<String> neueListe = listenFabrik.get();
    }
}
```

### Umwandlungstabelle: Lambda → Methodenreferenz

| Lambda | Methodenreferenz |
|--------|------------------|
| `() -> Math.random()` | `Math::random` |
| `s -> System.out.println(s)` | `System.out::println` |
| `s -> s.length()` | `String::length` |
| `(a, b) -> a.compareTo(b)` | `String::compareTo` |
| `() -> new ArrayList<>()` | `ArrayList::new` |

---

## 5. Zusammenspiel: Alle Konzepte im echten Code

Hier ist ein vollständiges Beispiel, das alles zeigt:

```java
import java.util.*;
import java.util.function.*;

public class VollstaendigesBeispiel {
    
    // Eigene Klasse
    static class Person {
        String name;
        int alter;
        
        Person(String name, int alter) {
            this.name = name;
            this.alter = alter;
        }
        
        int getAlter() { return alter; }
        
        @Override
        public String toString() {
            return name + " (" + alter + ")";
        }
    }
    
    // Statische Methode für Methodenreferenz
    public static void ausgabe(Person p) {
        System.out.println(">> " + p);
    }
    
    public static void main(String[] args) {
        List<Person> personen = Arrays.asList(
            new Person("Anna", 25),
            new Person("Ben", 19),
            new Person("Clara", 32)
        );
        
        // 1. Lambda mit Consumer für Ausgabe
        System.out.println("=== Alle Personen ===");
        personen.forEach(p -> System.out.println(p));
        
        // 2. Methodenreferenz (noch kürzer)
        personen.forEach(System.out::println);
        
        // 3. Mit eigener statischer Methode
        personen.forEach(VollstaendigesBeispiel::ausgabe);
        
        // 4. Sortieren mit Lambda (Comparator)
        personen.sort((p1, p2) -> p1.alter - p2.alter);
        System.out.println("\n=== Nach Alter sortiert ===");
        personen.forEach(System.out::println);
        
        // 5. Mit Comparator-Hilfsmethode (noch eleganter)
        personen.sort(Comparator.comparing(Person::getAlter));
        
        // 6. Filtern mit Predicate
        System.out.println("\n=== Volljährige (>= 18) ===");
        Predicate<Person> istVolljaehrig = p -> p.alter >= 18;
        personen.stream()
            .filter(istVolljaehrig)
            .forEach(System.out::println);
        
        // 7. Umwandeln mit Function
        System.out.println("\n=== Nur die Namen ===");
        Function<Person, String> nameMapper = Person::getName; // Getter vorausgesetzt
        personen.stream()
            .map(Person::getName)  // oder nameMapper
            .forEach(System.out::println);
    }
}
```

---

## 6. Die häufigsten Fehler (und wie man sie vermeidet)

### Fehler 1: `@FunctionalInterface` vergessen
Das Interface funktioniert auch ohne die Annotation, aber die Annotation hilft dem Compiler, Fehler zu finden.

### Fehler 2: Zwei abstrakte Methoden im Interface
```java
interface MeinInterface {
    void methode1();
    void methode2();  // FEHLER! Nur eine abstrakte Methode erlaubt
}
```

### Fehler 3: Lambda mit mehreren Anweisungen ohne `return`
```java
// FALSCH:
(a, b) -> a + b; System.out.println("fertig");

// RICHTIG (geschweifte Klammern + return):
(a, b) -> {
    int sum = a + b;
    System.out.println("fertig");
    return sum;
};
```

### Fehler 4: Methodenreferenz auf eine Methode mit falscher Signatur
Die Methodenreferenz muss genau zum funktionalen Interface passen.

---

## 7. Zusammenfassung – Wann nimmt man was?

| Situation | Lösung |
|-----------|--------|
| Einfache, einmalige Aktion | **Lambda** direkt beim Aufruf |
| Komplexere Logik (mehrere Zeilen) | **Lambda** mit geschweiften Klammern |
| Eine existierende Methode passt genau | **Methodenreferenz** `Klasse::methode` |
| Eigenes Interface mit einer Methode | **Funktionales Interface** selbst erstellen |
| Prüfung (`true`/`false`) | `Predicate<T>` |
| Aktion ausführen (ohne Rückgabe) | `Consumer<T>` |
| Wert liefern (ohne Parameter) | `Supplier<T>` |
| Umwandlung | `Function<T,R>` |
| Sortierung | `Comparator<T>` |

---

## 8. Quick Reference Card

```java
// LAMBDA
(Parameter) -> Ausdruck
(Parameter) -> { Anweisungen; return wert; }

// PREDICATE (prüfen)
list.removeIf(s -> s.length() < 5);
list.stream().filter(s -> s.startsWith("A"));

// CONSUMER (ausführen)
list.forEach(s -> System.out.println(s));
list.forEach(System.out::println);  // Methodenreferenz

// FUNCTION (umwandeln)
list.stream().map(s -> s.length());
list.stream().map(String::length);   // Methodenreferenz

// COMPARATOR (sortieren)
list.sort((a, b) -> a.length() - b.length());
list.sort(Comparator.comparing(String::length));

// METHODENREFERENZEN
Math::max              // statische Methode
System.out::println    // Instanzmethode eines Objekts
String::length         // Instanzmethode des Parametertyps
ArrayList::new         // Konstruktor
```