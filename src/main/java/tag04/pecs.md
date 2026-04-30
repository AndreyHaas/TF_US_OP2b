# PECS – Producer Extends, Consumer Super

## Was ist PECS?

**PECS** ist eine **Eselsbrücke** für die korrekte Verwendung von Wildcards (`? extends T` und `? super T`) in Java Generics.

---

## Die Regel

| Buchstabe | Bedeutung | Wildcard | Verwendung |
|-----------|-----------|----------|------------|
| **P** | **Producer** | `<? extends T>` | **liest** Daten (produziert) |
| **E** | Extends | | |
| **C** | **Consumer** | `<? super T>` | **schreibt** Daten (konsumiert) |
| **S** | Super | | |

**Merksatz:** *Producer Extends, Consumer Super*

---

## Kurzform

> **Producer = `extends` (lesen)**  
> **Consumer = `super` (schreiben)**

---

## Beispiel 1: Producer (`<? extends T>`)

```java
// Diese Methode LIEST nur aus der Liste → Producer
public double sum(List<? extends Number> list) {
    double sum = 0;
    for (Number n : list) {     // ✅ lesen erlaubt
        sum += n.doubleValue();
    }
    // list.add(42);            // ❌ schreiben NICHT erlaubt!
    return sum;
}
```

**Warum `extends`?**  
Die Liste könnte `List<Integer>` oder `List<Double>` sein – man kann nicht wissen, welchen konkreten Typ man hinzufügen darf. Aber lesen geht immer (als `Number`).

---

## Beispiel 2: Consumer (`<? super T>`)

```java
// Diese Methode SCHREIBT nur in die Liste → Consumer
public void fill(List<? super Integer> list) {
    for (int i = 0; i < 10; i++) {
        list.add(i);            // ✅ schreiben erlaubt
    }
    // Integer x = list.get(0); // ⚠️ lesen nur als Object möglich
}
```

**Warum `super`?**  
Die Liste könnte `List<Integer>` oder `List<Number>` oder `List<Object>` sein – man kann sicher `Integer` hinzufügen. Beim Lesen bekommt man nur `Object`.

---

## Beispiel 3: Producer und Consumer zusammen

Die berühmte `copy`-Methode aus `Collections`:

```java
public static <T> void copy(List<? extends T> src, List<? super T> dest) {
    for (T item : src) {     // src ist Producer → extends
        dest.add(item);      // dest ist Consumer → super
    }
}
```

**Aufruf:**
```java
List<Integer> src = List.of(1, 2, 3);
List<Number> dest = new ArrayList<>();
copy(src, dest);  // ✅ Integer → Number ist erlaubt
```

---

## Alternative Merksätze

| Satz | Bedeutung |
|------|-----------|
| **"Get `extends`, Put `super`"** | Wenn du Werte **holst** (get) → `extends`. Wenn du Werte **einfügst** (put) → `super`. |
| **"Producer `extends`, Consumer `super`"** | Wie oben. |
| **"Lese-Extends, Schreib-Super"** | Deutsche Eselsbrücke |

---

## Tabelle zum Nachschlagen

| Wildcard | Spitzname | Darf lesen? | Darf schreiben? | Typ des Gelesenen |
|----------|-----------|-------------|-----------------|-------------------|
| `<? extends T>` | Producer | ✅ ja | ❌ nein (außer null) | `T` |
| `<? super T>` | Consumer | ✅ ja (nur als Object) | ✅ ja (nur `T` und Unterklassen) | `Object` |
| `<?>` | unbekannt | ✅ ja | ❌ nein (außer null) | `Object` |

---

## Wann verwendet man was?

| Situation | Wildcard |
|-----------|----------|
| Nur lesen (`get`, `size`, Iteration) | `<? extends T>` |
| Nur schreiben (`add`, `set`, `put`) | `<? super T>` |
| Beides (lesen und schreiben) | Kein Wildcard (konkreter Typ `<T>`) |

---

## Typische Fehler

```java
// ❌ FALSCH: Producer darf nicht schreiben
List<? extends Number> list = new ArrayList<Integer>();
list.add(42);  // Compiler-Fehler!

// ❌ FALSCH: Consumer liefert nur Object
List<? super Integer> list = new ArrayList<Number>();
Integer i = list.get(0);  // Compiler-Fehler! (braucht Cast)
```

---

## Visuelle Merkhilfe

```
        ┌─────────────────────────────────────┐
        │                                     │
        │   Producer extends  →  nur lesen    │
        │                                     │
        │   Consumer super    →  nur schreiben│
        │                                     │
        └─────────────────────────────────────┘
```

---

## Deutsche Eselsbrücke

> **"Lies von Erweitertem, schreib in Oberes"**

- **Lies** = du liest → **Erweitertes** (`extends`)
- **Schreib** = du schreibst → **Oberes** (`super`)

---

## Zusammenfassung für die Prüfung

| Regel | Wildcard |
|-------|----------|
| Producer (gibt Daten) | `<? extends T>` |
| Consumer (nimmt Daten) | `<? super T>` |
| Get (holen) | `<? extends T>` |
| Put (einfügen) | `<? super T>` |

**Merke einfach:**  
*"Erweitert zum Lesen, Oberklasse zum Schreiben."* ✅