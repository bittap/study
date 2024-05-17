package com.atcoder;

import java.util.Scanner;

public class CDayDream {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    StringBuilder S = new StringBuilder(scan.nextLine());
    S.reverse();

    // System.out.println(S.toString());

    String[] divide = new String[] {"dream", "dreamer", "erase", "eraser"};

    for (int i = 0; i < divide.length; i++) {
      divide[i] = new StringBuilder(divide[i]).reverse().toString();
    }

    boolean can = true;

    for (int i = 0; i < S.length();) {
      boolean can2 = false;

      for (int j = 0; j < divide.length; j++) {
        if (S.substring(i, i + 3).equals(divide[j].substring(0, 3))) {
          if (S.substring(i, i + divide[j].length()).equals(divide[j])) {
            i += divide[j].length();
            can2 = true;
            break;
          } else {
            break;
          }
        }
      }

      if (!can2) {
        can = false;
        break;
      }
    }

    if (can) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    scan.close();

  }

}
