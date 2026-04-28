package aufgaben.lösung_3v2;

public abstract class StringConverter<T>
{
    abstract String toString(T obj);
    abstract T fromString(String obj);

}
