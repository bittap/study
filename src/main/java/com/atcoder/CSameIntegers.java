package com.atcoder;

import java.util.Scanner;

public class CSameIntegers {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int[] nums = new int[3];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = scan.nextInt();
    }

    int odd = 0;
    int even = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0)
        even++;
      else
        odd++;
    }

    int answer = 0;
    if (odd == 2) {
      answer++;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] % 2 != 0)
          nums[i]++;
      }
    } else if (even == 2) {
      answer++;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] % 2 == 0)
          nums[i]++;
      }
    }

    int max = Integer.max(nums[0], Integer.max(nums[1], nums[2]));
    for (int i = 0; i < nums.length; i++) {
      answer += (max - nums[i]) / 2;
    }


    System.out.println(answer);
    scan.close();
  }

}
