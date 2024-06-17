package com.atcoder;

import java.util.Scanner;

public class CDayDream2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String S = scan.nextLine();

    String[] divide = new String[] {"dream", "dreamer", "erase", "eraser"};


    boolean[] dp = new boolean[S.length() + 1];
    dp[0] = true;

    for (int i = 0; i < S.length(); i++) {
      if (!dp[i])
        continue;

      for (String s : divide) {
        if (S.substring(i, Math.min(i + s.length(), S.length())).equals(s)) {
          dp[i + s.length()] = true;
        }
      }
    }

    if (dp[S.length()]) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    scan.close();

  }

}
