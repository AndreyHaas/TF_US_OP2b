package template;

// Die Annotation '@FunctionalInterface' ist nicht zwingend erforderlich, aber best practice, um das versehentliche Hinzufügen weiterer abstrakter Methoden zu verhindern.
@FunctionalInterface
public interface EtwasAusgebend
{
    public abstract void ausgabe();
}
