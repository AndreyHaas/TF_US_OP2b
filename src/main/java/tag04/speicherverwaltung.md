# Speicherverwaltung in Java: Heap, Stack, Stringpool & Garbage Collector

## 1. Einleitung
Java verwaltet den Speicher automatisch. Der Entwickler muss sich nicht um `malloc`/`free` kümmern. Trotzdem ist es wichtig zu wissen, wie der Speicher aufgeteilt ist, um:
- Speicherlecks zu vermeiden
- die Leistung zu verstehen
- Fehler wie `OutOfMemoryError` zu beheben

---

## 2. Heap (Haldenspeicher)
Der **Heap** ist der **große, gemeinsame Speicherbereich** für alle Objekte.

- Dynamisch (Größe kann sich ändern)
- Wird vom **Garbage Collector (GC)** verwaltet
- Alle **Objekte** und **Arrays** landen hier

```java
// Beispiel: Objekt landet immer im Heap
Person p = new Person(); // Das Objekt steht im Heap
```

### 2.1 Even / Eden (junger Teil des Heaps)
Der Heap ist in **Generationen** aufgeteilt:

- **Eden** (auch *Even* genannt) – hier werden neue Objekte geboren
- **Survivor** (S0, S1) – Objekte, die einen GC-Zyklus überlebt haben
- **Old Gen / Tenured** – langlebige Objekte

**Merke:** Junger GC = nur Eden + Survivor

---

## 3. Stack (Stapelspeicher)
Der Stack ist **pro Thread** und enthält:

- **Lokale Variablen** (primitive Typen)
- **Referenzen** auf Objekte im Heap
- **Methodenaufrufe** (Call-Stack)

```java
public void doSomething() {
    int zahl = 5;          // zahl liegt auf dem Stack (primitiver Wert)
    String name = "Alex";  // name ist eine Referenz (liegt auf Stack), das String-Objekt liegt im Heap
}
```

### Größe
Der Stack ist meist klein (Standard ca. 512KB-1MB). Zu viele Rekursionen => `StackOverflowError`.

---

## 4. Stringpool
Der **Stringpool** ist ein spezieller Bereich **im Heap**, der `String`-Literale verwaltet.

```java
String a = "Hallo";     // geht in den Stringpool
String b = "Hallo";     // Wiederverwendung desselben Objekts (a == b)

String c = new String("Hallo"); // zwingt neues Objekt (außerhalb des Pools)
```

Mit `.intern()` kann man manuell in den Pool legen.

### Warum gibt es den Pool?
- String sind **immutable** (unveränderlich)
- Dadurch können gleiche Literale sicher wiederverwendet werden
- Spart Speicher

---

## 5. Garbage Collector (GC)
Der GC löscht automatisch Objekte, die **nicht mehr referenziert** werden.

```java
public void test() {
    Person p = new Person();
    p = null; // das Person-Objekt ist jetzt GC-Kandidat
}
```

### 5.1 Freigabe-Strategien (GC-Algorithmen)

| Name | Beschreibung |
|------|--------------|
| **Serial GC** | Einzelner Thread, für kleine Applikationen |
| **Parallel GC** | Mehrere Threads, hoher Durchsatz |
| **G1 GC** | Standard seit Java 9, gut für große Heaps |
| **ZGC** | Sehr kurze Pausen, für riesige Heaps (>100GB) |
| **Shenandoah** | Siehe Kapitel 6 |

---

## 6. Shenandoah GC (ausführlich)
**Shenandoah** ist ein **low-pause Garbage Collector**, der parallel und nebenläufig arbeitet.

- Entwickelt von Red Hat
- Seit **Java 12** verfügbar (teilweise in OpenJDK)
- Ziel: **sehr kurze GC-Pausen** (unabhängig von Heap-Größe)

### Wie funktioniert es?
1. Markiert lebende Objekte (nebenläufig)
2. Verschiebt Objekte (nebenläufig)
3. Passt Referenzen an (nebenläufig)

Dadurch gibt es keine langen "Stop-the-World"-Phasen.

### Aktivierung in der JVM:
```bash
-XX:+UseShenandoahGC
```

---

## 7. Zusammenspiel von Stack, Heap und Stringpool – Beispiel

```java
public class Main {
    static int global = 10; // Klasse: Special Area (MetaSpace)

    public static void main(String[] args) {
        int local = 5;                      // Stack
        String name = "Java";               // "Java" im Stringpool, name als Referenz auf Stack
        Integer i = 142;                    // 142 im Heap (Integer-Objekt)
        Person p = new Person();            // Person-Objekt im Heap
    }
}
```

---

## 8. Häufige Fehler und Begriffe

| Begriff | Bedeutung |
|---------|-----------|
| **Memory Leak** | Objekte werden nicht mehr gebraucht, aber noch referenziert => GC kann nicht löschen |
| **OutOfMemoryError** | Heap voll, GC kann keinen Platz mehr freimachen |
| **StackOverflowError** | Stack voll (meist durch Endlos-Rekursion) |
| **Stop the World (STW)** | Anwendung pausiert komplett, während GC arbeitet |

---

## 9. Merksätze für Prüfungen

✅ **"Objects live on the Heap, local variables live on the Stack"**  
✅ **"Stringpool spart Speicher und hilft bei häufig genutzten Strings"**  
✅ **"Shenandoah versucht, GC-Pausen sehr kurz zu halten – auch bei großen Heaps"**  
✅ **"Der GC entfernt Objekte, die nicht mehr erreichbar sind"**

---

## 10. Zusammenfassung
- **Heap:** alle Objekte
- **Stack:** Methodenaufrufe + lokale Variablen
- **Stringpool:** Teil des Heaps, optimiert `String`-Literale
- **Garbage Collector:** automatische Speicherbereinigung
- **Shenandoah:** moderner GC mit sehr kurzen Pausen