package com.my.study.algorithyme;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 50, 30, 20, 40 };

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < (nums.length - 1) - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        for (int num : nums) {
            System.out.printf(num + " ");
        }
    }
}
