package tag03.aufgaben.a1;

import java.lang.StackWalker.StackFrame;

public class Main {
    public static void bildschirm(String... daten) {

        for (String d : daten) {
            System.out.printf("Schreibe %s auf den " + getMethod() + "...%n", d);
        }
        System.out.println();
    }

    public static void datei(String... daten) {

        for (String d : daten) {
            System.out.printf("Schreibe %s in die " + getMethod() + "...%n", d);
        }
        System.out.println();
    }

    public static void datenbank(String... daten) {

        for (String d : daten) {
            System.out.printf("Schreibe %s in die " + getMethod() + "...%n", d);
        }
        System.out.println();
    }

    private static String getMethod() {
        String methodName = StackWalker.getInstance()
            .walk(frames -> frames.skip(1).findFirst()
                .map(StackFrame::getMethodName)
                .orElse("unknown"));

        if (methodName == null || methodName.isEmpty()) {
            return methodName;
        }

        return Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1);
    }

    static void main() {
        String[] daten = {"Hallo", "Welt", "und Lambda in Java"};

        Ausgabe[] ausgaben = {
            Main::bildschirm,
            Main::datei,
            Main::datenbank
        };

        for (Ausgabe ausgabe : ausgaben) {
            ausgabe.ausgeben(daten);
        }
    }
}