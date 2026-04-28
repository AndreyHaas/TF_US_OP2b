package aufgaben;
/* Schreiben Sie eine Klasse 'Calculator', die eine Methode 'calculate' enthält, mit zwei Zahlen und einem Objekt vom Typ 'Operation' als Parameter und das Ergebnis der Operation als Rückgabe.
 Erstellen Sie das Interface 'Operation' mit der Methode 'execute(int a, int b)'.
 Verwenden Sie anonyme Klassen, um für jede Operation ein Objekt zu erstellen und es der `calculate`-Methode zu übergeben.

 In der main-Methode erstellen Sie vier anonyme Klassen, die das Interface implementieren und 'execute' mit den vier Grundrechenarten überschreiben.
 Die Instanzen der vier anonymen Klassen übergeben sie dann an die `calculate`-Methode der Calculator-Klasse.
*/

public class Lösung_1
{
    public static void main(String[] args)
    {
        Operation o;

        o = new Operation()
        {
            @Override
            public int execute(int a, int b)
            {
                return a + b;
            }
        };

        System.out.println(Calculator.calculate(26,16, o));

        o = new Operation()
        {
            @Override
            public int execute(int a, int b)
            {
                return a - b;
            }
        };

        System.out.println(Calculator.calculate(55,13, o));

        o = new Operation()
        {
            @Override
            public int execute(int a, int b)
            {
                return a * b;
            }
        };

        System.out.println(Calculator.calculate(7,6, o));


        System.out.println(Calculator.calculate(126,3, new Operation()
        {
            @Override
            public int execute(int a, int b)
            {
                if (b != 0)
                    return a / b;
                else return 0;
            }
        }));

    }
}

class Calculator
{
    public static int calculate(int a, int b, Operation o)
    {
        return o.execute(a, b);
    }
}

interface Operation
{
    public abstract int execute(int a, int b);
}


