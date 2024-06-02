package com.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class CSkip {
  static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    long ans, X;
    X = scan.nextLong();
    long[] x = new long[N];

    for (int i = 0; i < N; i++) {
      x[i] = scan.nextLong();
    }

    Arrays.sort(x);

    ans = Math.abs(X - x[0]);

    for (int i = 1; i < N; i++) {
      ans = gcd(ans, x[i] - x[i - 1]);
    }

    System.out.println(ans);
  }
}

