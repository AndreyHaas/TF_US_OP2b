package tag01.hausAufgaben.a2;

import java.util.ArrayList;
import java.util.List;

public class Application {

  public static void main(String[] args) {
    List<GerauscheMacher> gerauscheMacherList = new ArrayList<>();
    Auto auto = new Auto();
    Hund hund = new Hund();
    Mensch mensch = new Mensch();
    gerauscheMacherList.add(auto);
    gerauscheMacherList.add(hund);
    gerauscheMacherList.add(mensch);

    for (GerauscheMacher gerauscheMacher : gerauscheMacherList) {
      gerauscheMacher.macheGerausch();
    }
  }
}