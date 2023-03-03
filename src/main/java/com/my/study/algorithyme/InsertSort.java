package com.my.study.algorithyme;

import java.util.Arrays;

public class InsertSort {

  public static void main(String[] args) {
    int[] numbers = new int[] {10, 50, 30, 20, 40};
    int[] sortedNumbers = new int[numbers.length];

    // 未整列要素をループ
    for (int i = 0; i < numbers.length; i++) {
      int currentNumber = numbers[i];
      sortedNumbers[i] = currentNumber;
      // 整列済み配列をループ
      for (int j = i; (0 < j && currentNumber < sortedNumbers[j - 1]); j--) {
        sortedNumbers[j] = sortedNumbers[j - 1];
        sortedNumbers[j - 1] = currentNumber;
      }
    }

    Arrays.stream(sortedNumbers).forEach((i) -> System.out.print(i + " "));
  }
}
