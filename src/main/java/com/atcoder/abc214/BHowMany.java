package com.atcoder.abc214;

import java.util.Scanner;

public class BHowMany {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int S = scan.nextInt();
    int T = scan.nextInt();

    scan.close();

    int answer = 0;
    int max = S;

    for (int a = 0; a <= max; a++) {
      for (int b = 0; b <= max - a; b++) {
        for (int c = 0; c <= max - a - b; c++) {
          if (a + b + c <= S && a * b * c <= T) {
            answer++;
          }
        }
      }
    }

    System.out.println(answer);
  }

}
