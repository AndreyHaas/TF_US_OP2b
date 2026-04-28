package tag02.aufgaben.a3;

public abstract class StringConverter<T> {

  abstract String toString(T obj);

  abstract T fromString(String obj);
}