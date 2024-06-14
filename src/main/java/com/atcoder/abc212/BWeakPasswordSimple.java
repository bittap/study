package com.atcoder.abc212;

import java.util.Scanner;

public class BWeakPasswordSimple {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int[] nums = new int[4];
    char[] chars = scan.next().toCharArray();

    scan.close();

    for (int i = 0; i < chars.length; i++) {
      nums[i] = Integer.parseInt(String.valueOf(chars[i]));
    }

    boolean isStrong = true;

    if ((nums[0] == nums[1]) && (nums[1] == nums[2]) && (nums[2] == nums[3])) {
      isStrong = false;
    }

    if (((nums[0] + 1) % 10 == nums[1]) && ((nums[1] + 1) % 10 == nums[2])
        && ((nums[2] + 1) % 10 == nums[3])) {
      isStrong = false;
    }


    if (isStrong)
      System.out.println("Strong");
    else
      System.out.println("Weak");
  }

}
