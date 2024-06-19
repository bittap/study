package com.codility;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int solution(int N) {
    // 2進数に変換
    String decimal2 = decimal10To2Decimal(N);

    // 桁数分ループし、1からスタートして1までの0の数を保持しておく。
    List<Integer> binaryGap0Index = new ArrayList<Integer>();
    for (int i = 0; i < decimal2.length(); i++) {
      if ("1".equals(String.valueOf(decimal2.charAt(i)))) {
        binaryGap0Index.add(i);
      }
    }



    if (binaryGap0Index.size() <= 1) {
      return 0;
    } else {
      int result = 0;

      for (int i = 0; i < binaryGap0Index.size() - 1; i++) {
        result = Integer.max(result, binaryGap0Index.get(i + 1) - binaryGap0Index.get(i) - 1);
      }

      return result;
    }
  }

  private String decimal10To2Decimal(int n) {
    StringBuilder sb = new StringBuilder();

    while (n >= 1) {
      sb.append(n % 2);
      n /= 2;
    }

    sb = sb.reverse();
    return sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(1041));
  }
}
