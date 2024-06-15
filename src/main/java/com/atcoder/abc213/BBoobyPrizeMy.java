package com.atcoder.abc213;

import java.util.Scanner;

public class BBoobyPrizeMy {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int[] A = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = scan.nextInt();
    }

    scan.close();

    for (int i = 0; i < 2; i++) {
      int maxIndex = 0;
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < A.length; j++) {
        if (max < A[j]) {
          maxIndex = j;
          max = A[j];
        }
      }

      A[maxIndex] = Integer.MIN_VALUE;

      if (i == 1) {
        System.out.println(maxIndex + 1);
        return;
      }
    }

  }

}
