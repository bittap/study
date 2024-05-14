package com.atcoder;

import java.util.Scanner;

public class CTakahashisInformation {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[][] c = new int[3][3];

    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c[i].length; j++) {
        c[i][j] = scan.nextInt();
      }
    }

    final int MAX = 100;

    int[] a = new int[3];
    int[] b = new int[3];


    for (int a1 = 0; a1 <= MAX; a1++) {
      a[0] = a1;
      for (int a2 = 0; a2 <= MAX; a2++) {
        a[1] = a2;
        for (int a3 = 0; a3 <= MAX; a3++) {
          a[2] = a3;
          b[0] = c[0][0] - a[0];
          b[1] = c[1][1] - a[1];
          b[2] = c[2][2] - a[2];

          boolean existed = true;

          loopI: for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
              if (c[i][j] != a[i] + b[j]) {
                existed = false;
                break loopI;
              }
            }
          }

          if (existed) {
            System.out.println("Yes");
            scan.close();
            return;
          }
        }
      }
    }

    System.out.println("No");

    scan.close();


  }

}
