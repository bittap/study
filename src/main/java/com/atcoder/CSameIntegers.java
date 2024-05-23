package com.atcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSameIntegers {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    List<Integer> nums = new ArrayList<Integer>();
    nums.add(scan.nextInt());
    nums.add(scan.nextInt());
    nums.add(scan.nextInt());

    int answer = 0;
    while ((nums.get(0) != nums.get(1)) || (nums.get(1) != nums.get(2))) {
      nums.sort(Integer::compare);
      long evenCount = nums.stream().filter((e) -> e % 2 == 0).count();

      if (evenCount == 3) {
        nums.set(0, nums.get(0) + 2);
      } else {
        if (nums.get(1) != nums.get(2)) {
          nums.set(0, nums.get(0) + 1);
          nums.set(1, nums.get(1) + 1);
        } else {
          nums.set(0, nums.get(0) + 2);
        }
      }

      answer++;

    }

    System.out.println(answer);
    scan.close();
  }

}
