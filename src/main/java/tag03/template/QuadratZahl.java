package tag03.template;

// Erstes funktionales Interface:
// Ein funktionales Interface ist ein Interface, das nur eine (1) abstrakte Methode bereitstellt.
// Funktionale Interfaces können beliebig viele default-Methoden beinhalten, aber nur eine abstrakte Methode!
@FunctionalInterface
public interface QuadratZahl
{
    public abstract int berechneQuadratZahl(int zahl);
}
