package tag02.aufgaben.a1;

public class Application {

  public static void main(String[] args) {
    Operation plus = new Operation() {
      @Override
      public int execute(int a, int b) {
        return a + b;
      }
    };

    System.out.println(Calculator.calculate(10, 37, plus));

    Operation minus = new Operation() {
      @Override
      public int execute(int a, int b) {
        return a - b;
      }
    };

    System.out.println(Calculator.calculate(111, 11, minus));

    Operation multiplication = new Operation() {
      @Override
      public int execute(int a, int b) {
        return a * b;
      }
    };

    System.out.println(Calculator.calculate(25, 25, multiplication));

    Operation divide = new Operation() {
      @Override
      public int execute(int a, int b) {
        if (b != 0) {
          return a / b;
        } else {
          return 0;
        }
      }
    };

    System.out.println(Calculator.calculate(12, 4, divide));
  }
}