package com.atcoder;

import java.util.Scanner;

public class BKagamiMochi2 {

    public static void main(String[] args) {
        // バケットで解く場合
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        int[] nums = new int[100];
        for (int i = 0; i < n; i++) {
            nums[d[i] - 1]++;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
