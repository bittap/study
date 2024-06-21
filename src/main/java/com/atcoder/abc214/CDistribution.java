package com.atcoder.abc214;

import java.util.Scanner;

public class CDistribution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();

    int[] S = new int[N];
    int[] T = new int[N];

    for (int i = 0; i < S.length; i++) {
      S[i] = scan.nextInt();
    }

    for (int i = 0; i < T.length; i++) {
      T[i] = scan.nextInt();
    }


    int[] answers = new int[N];
    answers[0] = T[0];
    int current = T[0];

    for (int i = 1; i < S.length; i++) {
      if (current + S[i - 1] <= T[i]) {
        current += S[i - 1];
        answers[i] = current;
      } else {
        current = T[i];
        answers[i] = T[i];
      }
    }


    scan.close();

    for (int i = 0; i < answers.length; i++) {
      if (i == answers.length - 1) {
        System.out.print(answers[i]);
      } else {
        System.out.println(answers[i]);
      }
    }
  }

}
