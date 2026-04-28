package tag02.aufgaben.a1;

public class Calculator {

  private Calculator() {}

  static int calculate(int zahl1, int zahl2, Operation operation) {
    return operation.execute(zahl1, zahl2);
  }
}