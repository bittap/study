package com.my.study;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class TestHashSet {

  @Test
  public void test() {
    HashSet<Food> sets = new HashSet<>();

    Food food1 = new Food();
    food1.name = "food1";

    Food food2 = new Food();
    food2.name = "food2";

    System.out.println("================");
    sets.add(food1);
    sets.add(food2);

    System.out.println("================");

    System.out.println(sets);
  }
}



class Food {

  String name;

  @Override
  public boolean equals(Object obj) {
    System.out.println("equals");
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    System.out.println("hashCode");
    return 1;
  }
}
