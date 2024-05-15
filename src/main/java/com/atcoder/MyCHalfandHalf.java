package com.atcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCHalfandHalf {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();

    int x = scan.nextInt();
    int y = scan.nextInt();

    List<Integer> totals = new ArrayList<Integer>();
    totals.add(buyPizzaByAAndB(a, b, x, y));
    totals.add(buyPizzaByAAndC(a, c, x, y));
    totals.add(buyPizzaByBAndC(b, c, x, y));
    totals.add(buyPizzaByC(c, x, y));

    // totals.stream().forEach(System.out::println);

    System.out.println(totals.stream().min(Integer::compare).get());
    scan.close();
  }

  private static int buyPizzaByAAndB(int a, int b, int x, int y) {
    return a * x + b * y;
  }

  private static Integer buyPizzaByAAndC(int a, int c, int x, int y) {
    return a * Math.abs(x - y) + c * y * 2;
  }

  private static int buyPizzaByBAndC(int b, int c, int x, int y) {
    return b * Math.abs(y - x) + c * x * 2;
  }

  private static Integer buyPizzaByC(int c, int x, int y) {
    return c * Integer.max(x, y) * 2;
  }

}
