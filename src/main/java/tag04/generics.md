# Generics in Java – von einfach bis fortgeschritten

## 1. Was ist das Problem ohne Generics?

Vor Java 5 gab es keine Generics. Man musste mit `Object` arbeiten – das war unsicher:

```java
List list = new ArrayList();
list.add("Hallo");
list.add(123);         // Kein Fehler!
String s = (String) list.get(1); // ❌ ClassCastException!
```

**Problem:** Der Compiler kann falsche Typen nicht erkennen → Fehler erst zur Laufzeit.

---

## 2. Was sind Generics?

**Generics** (deutsch: *Generische Typen*) erlauben es, Klassen, Interfaces und Methoden **typsicher** für verschiedene Datentypen zu schreiben.

```java
List<String> list = new ArrayList<>(); // Nur Strings erlaubt
list.add("Hallo");
// list.add(123); // ❌ Compiler-Fehler!
String s = list.get(0); // Kein Cast nötig
```

**Vorteile:**
- ✅ Typsicherheit zur **Compile-Zeit**
- ✅ Kein Casting nötig
- ✅ Wiederverwendbarer Code

---

## 3. Einfache Generics – Klassen mit Typparameter

### 3.1 Eine einfache generische Klasse

```java
class Box<T> {        // T ist ein Platzhalter für einen Typ
    private T inhalt;
    
    public void setInhalt(T inhalt) {
        this.inhalt = inhalt;
    }
    
    public T getInhalt() {
        return inhalt;
    }
}
```

### 3.2 Verwendung

```java
Box<String> stringBox = new Box<>();   // T ist String
stringBox.setInhalt("Java");
String wert = stringBox.getInhalt();   // Kein Cast!

Box<Integer> intBox = new Box<>();     // T ist Integer
intBox.setInhalt(42);
```

**Merke:** Beim Erstellen wird der konkrete Typ **einmalig festgelegt**.

---

## 4. Generische Methoden

Nicht nur Klassen, auch einzelne Methoden können generisch sein.

```java
public class Util {
    public static <T> T getElement(T element) {
        return element;
    }
}

// Aufruf
String s = Util.getElement("Hallo");
Integer i = Util.getElement(123);
```

**Syntax:** `<T>` steht **vor dem Rückgabetyp**.

---

## 5. Benannte Platzhalter (Type Parameter)

Oft verwendete Namen und ihre Konvention:

| Name | Bedeutung |
|------|-----------|
| `<T>` | Type (beliebiger Typ) |
| `<E>` | Element (für Listenelemente) |
| `<K>` | Key (Schlüssel in Maps) |
| `<V>` | Value (Wert in Maps) |
| `<R>` | Return Type (Rückgabetyp) |

```java
public interface Map<K, V> {
    V put(K key, V value);
    V get(K key);
}
```

---

## 6. Wildcards `?` – Unbekannte Typen

Ein **Wildcard** `?` bedeutet: **beliebiger unbekannter Typ**.

### 6.1 Unbeschränkter Wildcard

```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

**Kann:** lesen (`get()`)
**Kann nicht:** schreiben (außer `null`)

---

## 7. Upper Bound `<? extends T>`

**"T oder eine Unterklasse von T"**

```java
public void processNumbers(List<? extends Number> list) {
    for (Number n : list) {
        System.out.println(n.doubleValue());
    }
}
```

**Erlaubt:** `Number`, `Integer`, `Double`, `Float`, ...

```java
List<Integer> ints = List.of(1, 2, 3);
List<Double> doubles = List.of(1.5, 2.5);
processNumbers(ints);   // ✅
processNumbers(doubles); // ✅
```

### Merkregel: **extends = erlaubt den Typ und seine Kinder**

---

## 8. Lower Bound `<? super T>`

**"T oder eine Oberklasse von T"**

```java
public void addNumbers(List<? super Integer> list) {
    list.add(42);          // ✅ geht
    list.add(99);          // ✅ geht
}
```

**Erlaubt:** `Integer`, `Number`, `Object`

```java
List<Number> numbers = new ArrayList<>();
List<Object> objects = new ArrayList<>();
addNumbers(numbers);  // ✅
addNumbers(objects);  // ✅
```

### Merkregel: **super = erlaubt den Typ und seine Eltern**

---

## 9. PECS – Producer Extends, Consumer Super

Eine wichtige Merkregel:

| Rolle | Wildcard | Beispiel |
|-------|----------|----------|
| **Produzent** (liest Daten) | `<? extends T>` | `List<? extends Number>` → lesen |
| **Konsument** (schreibt Daten) | `<? super T>` | `List<? super Integer>` → schreiben |

```java
// Producer – nur lesen
public double sum(List<? extends Number> list) {
    double sum = 0;
    for (Number n : list) sum += n.doubleValue();
    return sum;
}

// Consumer – nur schreiben
public void fill(List<? super Integer> list) {
    for (int i = 0; i < 10; i++) list.add(i);
}
```

---

## 10. Type Erasure (Typ-Löschung)

Der Compiler entfernt alle Generics-Informationen zur Laufzeit.

```java
// Code
List<String> strings = new ArrayList<>();

// Nach der Kompilierung (vereinfacht)
List strings = new ArrayList();
```

**Konsequenzen:**
- Kein `instanceof` mit generischen Typen möglich
- Kein `new T()` (man kann keinen generischen Typ instanziieren)
- Keine statischen Felder vom Typ `T`

---

## 11. Häufige Fehler (und Lösungen)

| Fehler | Lösung |
|--------|--------|
| `new T()` | Factory-Methode oder `Supplier<T>` verwenden |
| `instanceof List<String>` | Nur `instanceof List<?>` möglich |
| `List<int>` | **Nur Referenztypen** (Integer, nicht int) |

---

## 12. Beispiele für Fortgeschrittene

### 12.1 Mehrere Typparameter

```java
public class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

Pair<String, Integer> pair = new Pair<>("Alter", 30);
```

### 12.2 Generische Methode mit Wildcard

```java
public static <T> void copy(List<? extends T> src, List<? super T> dest) {
    for (T item : src) {
        dest.add(item);
    }
}
```

---

## 13. Zusammenfassung für Anfänger

| Konzept | Einfache Erklärung |
|---------|--------------------|
| `<T>` | Platzhalter für einen Typ |
| `Box<String>` | Beim Erstellen wird T durch String ersetzt |
| `<?>` | Wildcard – Typ unbekannt (lesen erlaubt, schreiben nicht) |
| `<? extends Number>` | Nur Number oder Unterklassen (lesen) |
| `<? super Integer>` | Nur Integer oder Oberklassen (schreiben) |
| **PECS** | `extends` = Producer (lesen), `super` = Consumer (schreiben) |

---

## 14. Merksätze für Prüfungen

✅ **"Generics machen Code typsicher – Fehler werden vom Compiler erkannt"**  
✅ **"Wildcard `?` steht für unbekannten Typ"**  
✅ **"`<? extends T>` erlaubt T und alle Kinder"**  
✅ **"`<? super T>` erlaubt T und alle Eltern"**  
✅ **"PECS = Producer `extends`, Consumer `super`"**  
✅ **"Type Erasure löscht Generics-Informationen zur Laufzeit"**

---

## 15. Übungsaufgabe

```java
public static void main(String[] args) {
    List<Integer> ints = List.of(1, 2, 3);
    List<Number> nums = new ArrayList<>();
    
    copy(ints, nums); // Soll funktionieren
}

// Schreibe die copy-Methode mit korrekten Wildcards
```

**Lösung:**
```java
public static <T> void copy(List<? extends T> src, List<? super T> dest) {
    dest.addAll(src);
}
```

---

## Fazit

Generics sind ein mächtiges Werkzeug für typsicheren, wiederverwendbaren Code.  
Die Regeln sind am Anfang ungewohnt – aber mit **PECS**  und etwas Übung wirst du schnell sicher im Umgang mit Wildcards.