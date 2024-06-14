package com.atcoder.abc212;

import java.util.Arrays;
import java.util.Scanner;

public class CMinDifference {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int M = scan.nextInt();

    int[] A = new int[N];
    int[] B = new int[M];

    for (int i = 0; i < A.length; i++) {
      A[i] = scan.nextInt();
    }

    for (int i = 0; i < B.length; i++) {
      B[i] = scan.nextInt();
    }

    scan.close();

    Arrays.sort(A);
    Arrays.sort(B);

    int aCursor = 0;
    int bCursor = 0;
    int answer = Integer.MAX_VALUE;

    while (aCursor < A.length && bCursor < B.length) {
      answer = Integer.min(answer, Math.abs(A[aCursor] - B[bCursor]));

      if (A[aCursor] < B[bCursor])
        aCursor++;
      else
        bCursor++;
    }

    System.out.println(answer);
  }
}
