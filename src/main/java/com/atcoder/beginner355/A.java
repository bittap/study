package com.atcoder.beginner355;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Set<Integer> peopel = new HashSet<Integer>(Set.of(1, 2, 3));

    peopel.remove(scan.nextInt());
    peopel.remove(scan.nextInt());

    if (peopel.size() > 1) {
      System.out.println("-1");
    } else {
      for (Integer hannin : peopel) {
        System.out.println(hannin);
      }
    }

    scan.close();
  }

}
