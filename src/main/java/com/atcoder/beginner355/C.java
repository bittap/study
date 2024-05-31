package com.atcoder.beginner355;

import java.util.Scanner;

public class C {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int T = scan.nextInt();

    int answer = -1;

    int[] row = new int[N];
    int[] column = new int[N];
    int diagonal1 = 0;
    int diagonal2 = 0;

    for (int turn = 1; turn <= T; turn++) {
      int target = scan.nextInt() - 1;

      int i = target / N;
      int j = target % N;

      row[i]++;
      column[i]++;

      if (i == j) {
        diagonal1++;
      }

      if (i + j == N - 1) {
        diagonal2++;
      }

      if (row[i] == N || column[i] == N || diagonal1 == N || diagonal2 == N) {
        answer = turn;
        break;
      }

    }

    System.out.println(answer);

    scan.close();
  }
}
