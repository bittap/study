package com.atcoder.beginner355;

import java.util.Scanner;

public class C {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int T = scan.nextInt();
    int[][] NN = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        NN[i][j] = N * (i) + j + 1;
      }
    }

    int atehamaru = 0;
    int answer = -1;

    for (int a = 1; a <= T; a++) {
      int i = 0;
      int j = 0;

      int A = scan.nextInt();

      for (int k = 0; k < N; k++) {
        for (int v = 0; v < N; v++) {
          if (NN[k][v] == A) {
            i = k;
            j = v;
          }
        }
      }

      NN[i][j] = atehamaru;

      boolean rowCan = true;

      for (int k = 0; k < N; k++) {
        int temp = NN[i][k];
        if (temp != atehamaru) {
          rowCan = false;
        }
      }

      boolean columnCan = true;

      for (int k = 0; k < N; k++) {
        int temp = NN[k][j];
        if (temp != atehamaru) {
          columnCan = false;
        }
      }

      boolean nanameCan1 = true;

      for (int k = 0; k < N; k++) {
        int temp = NN[k][k];
        if (temp != atehamaru) {
          nanameCan1 = false;
        }
      }

      boolean nanameCan2 = true;

      for (int k = 0; k < N; k++) {
        int temp = NN[k][N - 1 - k];
        if (temp != atehamaru) {
          nanameCan2 = false;
        }
      }

      if (rowCan || columnCan || nanameCan1 || nanameCan2) {
        answer = a;
        break;
      }

    }

    System.out.println(answer);
    scan.close();
  }
}
