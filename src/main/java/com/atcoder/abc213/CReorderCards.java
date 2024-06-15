package com.atcoder.abc213;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CReorderCards {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int H = scan.nextInt();
    int W = scan.nextInt();
    int N = scan.nextInt();

    int[] A = new int[N];
    int[] B = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = scan.nextInt();
      B[i] = scan.nextInt();
    }

    compress(A);
    compress(B);

    for (int i = 0; i < N; i++) {
      System.out.printf("%d %d\n", A[i], B[i]);
    }


    scan.close();
  }

  private static void compress(int[] a) {
    // 座標圧縮を行うためにマップを定義する。
    Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();

    // キーソート
    for (int i = 0; i < a.length; i++) {
      mp.put(a[i], 0);
    }

    // 圧縮したマップを作る キー : 以前の配列要素の値 , 値 : 圧縮後の値
    int compressedNum = 1;
    for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
      mp.put(m.getKey(), compressedNum++);
    }

    // マップからa[]をswapする。
    // a[i] = map(a[i])
    for (int i = 0; i < a.length; i++) {
      a[i] = mp.get(a[i]);
    }
  }
}

