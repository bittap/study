package com.atcoder;

import java.util.Scanner;

public class CHalfandHalf {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int A = scan.nextInt();
    int B = scan.nextInt();
    int C = scan.nextInt();

    int X = scan.nextInt();
    int Y = scan.nextInt();

    int answer = Integer.MAX_VALUE;

    for (int i = 0; i <= Integer.max(X, Y); i++) {
      int total = i * C * 2;

      int x = X - i;
      int y = Y - i;

      if (x > 0)
        total += x * A;
      if (y > 0)
        total += y * B;

      answer = Integer.min(total, answer);
    }

    // totals.stream().forEach(System.out::println);

    System.out.println(answer);
    scan.close();
  }

}
