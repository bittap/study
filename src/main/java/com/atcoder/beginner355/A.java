package com.atcoder.beginner355;

import java.util.Scanner;

public class A {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int A = scan.nextInt();
    int B = scan.nextInt();

    if (A == B) {
      System.out.println(-1);
    } else {
      for (int i = 1; i <= 3; i++) {
        if (i != A && i != B) {
          System.out.println(i);
        }

      }
    }

    scan.close();
  }

}
