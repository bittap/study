package com.atcoder;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CBigArray {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    long K = scan.nextLong();

    Map<Integer, Long> nums = new TreeMap<Integer, Long>();


    for (int i = 0; i < N; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      if (nums.containsKey(a)) {
        nums.put(a, b + nums.get(a));
      } else {
        nums.put(a, (long) b);
      }
    }

    long current = 0;
    Integer answer = 0;

    for (Integer num : nums.keySet()) {
      current += nums.get(num);

      if (current >= K) {
        answer = num;
        break;
      }
    }

    System.out.println(answer);
    scan.close();
  }

}
