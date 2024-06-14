package com.atcoder.abc212;

import java.util.Scanner;

public class BWeakPassword {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int[] nums = new int[4];
    char[] chars = scan.next().toCharArray();

    scan.close();

    for (int i = 0; i < chars.length; i++) {
      nums[i] = Integer.parseInt(String.valueOf(chars[i]));
    }

    boolean same = true;
    boolean step = true;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] != nums[i + 1])
        same = false;
      if ((nums[i] + 1) % 10 != nums[i + 1])
        step = false;
    }

    if (!same && !step) {
      System.out.println("Strong");
    } else {
      System.out.println("Weak");
    }

  }

}
