package com.atcoder.beginner355;

import java.util.Arrays;
import java.util.Scanner;

public class B {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int M = scan.nextInt();

    int[] A = new int[N];
    int[] B = new int[M];

    for (int i = 0; i < A.length; i++) {
      A[i] = scan.nextInt();
    }

    for (int i = 0; i < A.length; i++) {
      B[i] = scan.nextInt();
    }


    Arrays.sort(A);
    Arrays.sort(B);



    boolean isPreA = A[0] < B[0] ? true : false;
    int n = 0;
    int m = 0;

    while (n >= N - 1 && m >= M - 1) {

      int nextA = 0;
      int nextB = 0;

      if (isPreA) {
        nextA = A[n + 1];
        nextB = B[m];

        if (nextA < nextB) {
          System.out.println("YES");
          return;
        } else {
          isPreA = false;
        }
      } else {
        nextA = A[n];
        nextB = B[m + 1];

        if (nextA < nextB) {
          isPreA = true;
        } else {
          m++;
        }
      }
    }

    System.out.println("NO");

    scan.close();

  }

}
