package com.atcoder;

import java.util.Scanner;

public class CTraveling {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] t = new int[N + 1];
    int[] x = new int[N + 1];
    int[] y = new int[N + 1];

    t[0] = x[0] = y[0] = 0;

    for (int i = 1; i <= N; i++) {
      t[i] = scan.nextInt();
      x[i] = scan.nextInt();
      y[i] = scan.nextInt();
    }

    boolean can = true;

    for (int i = 0; i < N; i++) {
      int j = i + 1;

      int dt = t[j] - t[i];
      int dx = Math.abs(x[i + 1] - x[i]);
      int dy = Math.abs(y[i + 1] - y[i]);

      if (dt < dx + dy || (dt - dy - dx) % 2 != 0) {
        can = false;
        break;
      }
    }

    if (can) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    scan.close();
  }


}
