package tag03.template.function.bsp2;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        int intEingabe = 0;
        Scanner scanner = new Scanner(System.in);
        Funktionen f = new Funktionen();
        boolean isOK = true;


        do {
            System.out.print("Quadratzahl berechnen. Bitte geben Sie eine Zahl ein: ");
            intEingabe = f.istEingabeInteger(scanner.nextLine());
            System.out.println(f.berechneQuadratZahl.andThen(f.speichereDaten).apply(intEingabe));
            do {
                System.out.println("Weitere Zahlen eingeben ? 1 <- Ja / 2 <- Nein");
                System.out.print("Eingabe: ");
                intEingabe = f.istEingabeInteger(scanner.nextLine());
                if(intEingabe == 2)
                {
                    isOK = false;
                }
            }while(intEingabe != 1 && intEingabe !=2 );
        }while(isOK);

        System.out.println();
        for (Daten d : Daten.datenListe)
        {
            System.out.println("ID: "+d.getId() +" QuadratZahl: "+d.getZahl() );
        }
    }


}
