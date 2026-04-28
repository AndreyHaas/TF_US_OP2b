# Lokale, anonyme und innere Klassen in Java

## 1. Übersicht der Klassentypen

| Klassentyp | Wird definiert... | Benötigt äußere Instanz |
|-----------|-----------------|----------------------|
| **Innere Klasse** (inner class) | innerhalb einer anderen Klasse | ✅ ja |
| **Lokale Klasse** (local class) | innerhalb einer Methode | ❌ nein |
| **Anonyme Klasse** (anonymous class) | direkt in einem Ausdruck | ❌ nein |
| **Statische verschachtelte Klasse** (static nested) | innerhalb einer Klasse mit `static` | ❌ nein |

---

## 2. Innere Klasse (Inner Class)

**Erklärung:**  
Die innere Klasse hat Zugriff auf alle Felder der äußeren Klasse, auch auf `private`. Für die Erstellung wird eine Instanz der äußeren Klasse benötigt.

```java
public class Outer {
    private String message = "Hallo von außen";
    
    class Inner {
        void print() {
            System.out.println(message); // Zugriff auf private Feld
        }
    }
    
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // spezielle Syntax
        inner.print();
    }
}
```

---

## 3. Lokale Klasse (Local Class)

**Erklärung:**  
Eine lokale Klasse wird innerhalb einer Methode deklariert und ist nur dort sichtbar. Sie kann auf `final` oder `effectively final` lokale Variablen zugreifen.

```java
public class Outer {
    
    void someMethod() {
        final String localVar = "Ich bin lokal";
        
        class Local {
            void print() {
                System.out.println(localVar); // Zugriff auf lokale Variable
            }
        }
        
        Local local = new Local();
        local.print();
    }
}
```

---

## 4. Anonyme Klasse (Anonymous Class)

**Erklärung:**  
Eine anonyme Klasse hat keinen Namen und wird direkt an der Verwendungsstelle erstellt. Sie wird häufig zur Implementierung von Interfaces oder zum Überschreiben von Methoden verwendet.

```java
public class Outer {
    
    interface Greeting {
        void sayHello();
    }
    
    void createAnonymous() {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hallo von anonymer Klasse!");
            }
        };
        
        greeting.sayHello();
    }
}
```

---

## 5. Statische verschachtelte Klasse (Static Nested Class)

**Erklärung:**  
Im Gegensatz zur inneren Klasse hat die statische verschachtelte Klasse **keinen Zugriff** auf nicht-statische Felder der äußeren Klasse. Sie verhält sich wie eine normale Klasse, die aus logischen Gründen innerhalb einer anderen Klasse deklariert wurde.

```java
public class Outer {
    private static String staticField = "Statisches Feld";
    private String nonStatic = "Nicht statisch";
    
    static class StaticNested {
        void print() {
            System.out.println(staticField); // ✅ möglich
            // System.out.println(nonStatic); // ❌ Fehler!
        }
    }
    
    public static void main(String[] args) {
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.print();
    }
}
```

---

## 6. Vollständiges Beispiel (alle Typen zusammen)

```java
public class Demo {
    private String outerField = "Außen";
    
    // 1. Innere Klasse
    class Inner {
        void show() {
            System.out.println("Inner: " + outerField);
        }
    }
    
    // 2. Statische verschachtelte Klasse
    static class StaticNested {
        void show() {
            System.out.println("Statisch verschachtelt");
        }
    }
    
    void demoMethod() {
        // 3. Lokale Klasse
        class Local {
            void show() {
                System.out.println("Lokale Klasse");
            }
        }
        
        Local local = new Local();
        local.show();
        
        // 4. Anonyme Klasse
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonyme Klasse");
            }
        };
        task.run();
    }
    
    public static void main(String[] args) {
        Demo demo = new Demo();
        
        Demo.Inner inner = demo.new Inner();
        inner.show();
        
        Demo.StaticNested nested = new Demo.StaticNested();
        nested.show();
        
        demo.demoMethod();
    }
}
```

---

## 7. Vergleichstabelle

| Eigenschaft | Inner | Local | Anonymous | Static Nested |
|-------------|-------|-------|-----------|---------------|
| Zugriff auf äußere Felder | ✅ | ✅ | ✅ | ❌ (nur static) |
| Benötigt äußere Instanz | ✅ | ❌ | ❌ | ❌ |
| Kann Konstruktor haben | ✅ | ✅ | ❌ | ✅ |
| Kann `private` sein | ✅ | ❌ | ❌ | ✅ |
| Kann statische Member haben | ❌ | ❌ | ❌ | ✅ |

---

## 8. Wann verwendet man was?

| Situation | Empfohlener Typ |
|-----------|-----------------|
| Zugriff auf äußeres Objekt + viel Logik | **Innere Klasse** |
| Klasse wird nur in einer Methode benötigt | **Lokale Klasse** |
| Einfache einmalige Implementierung eines Interfaces | **Anonyme Klasse** |
| Klasse benötigt keinen Zugriff auf äußeres Objekt | **Statische verschachtelte Klasse** |

---

## 9. Praxisbeispiel (GUI)

```java
JButton button = new JButton("Klick mich");
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button wurde geklickt!");
    }
});
```

---

## 10. Lambda (Java 8+)

Eine anonyme Klasse mit nur einer Methode kann durch ein Lambda ersetzt werden:

```java
button.addActionListener(e -> System.out.println("Button geklickt!"));
```

---

## Zusammenfassung

| Typ | Kurzbeschreibung |
|-----|------------------|
| **Innere Klasse** | Nicht-statische Klasse innerhalb einer anderen Klasse |
| **Lokale Klasse** | Klasse innerhalb einer Methode |
| **Anonyme Klasse** | Klasse ohne Namen, direkt bei der Verwendung erstellt |
| **Statische verschachtelte Klasse** | Statische Klasse innerhalb einer anderen Klasse |
