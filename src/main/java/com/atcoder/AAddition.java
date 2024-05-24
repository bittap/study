package com.atcoder;

import java.util.Scanner;

public class AAddition {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();

    int odd = 0;
    for (int i = 0; i < N; i++) {
      if (scan.nextInt() % 2 != 0) {
        odd++;
      }
    }

    if (odd % 2 == 0) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }


    scan.close();

  }
}
