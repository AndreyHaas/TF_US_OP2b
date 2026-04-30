package tag04.aufgaben.a0;

import java.util.Arrays;

public class Application {

  static void main() {
    Pair<Double, String> tuple = new Pair<>();
    tuple.setValue0(1D);
    tuple.setValue1("Jan");

    System.out.println(tuple);

    Object[] tupleArray = tuple.toArray();
    System.out.println(Arrays.toString(tupleArray));

    Pair<Double, String> tuple2 = Pair.of(2D, "Andreas");
    System.out.println(tuple2);

    Object[] tuple2Array = tuple2.toArray();
    System.out.println(Arrays.toString(tuple2Array));

    System.out.println(tuple.getValue0());
    System.out.println(tuple2.getValue1());
  }
}