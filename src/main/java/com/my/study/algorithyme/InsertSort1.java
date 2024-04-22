package com.my.study.algorithyme;

import java.util.Arrays;

public class InsertSort1 {

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 50, 30, 20, 40 };
        int[] sortedNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (i == 0) {
                sortedNums[i] = currentNum;
            } else {
                int insertedIndex = 0;
                for (int j = 0; sortedNums[j] > 0 && j < sortedNums.length; j++) {
                    if (sortedNums[j] < currentNum) {
                        insertedIndex = j;
                    } else {
                        sortedNums[j + 1] = sortedNums[j];
                        sortedNums[j] = currentNum;
                    }
                }
                if (insertedIndex == 0) {
                    sortedNums[1] = sortedNums[0];
                    sortedNums[0] = currentNum;
                } else {

                }

            }
            Arrays.stream(sortedNums).forEach((e) -> System.out.print(e + " "));
            System.out.println();
        }

        Arrays.stream(sortedNums).forEach((e) -> System.out.println());

    }
}
