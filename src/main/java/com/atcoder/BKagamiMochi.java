package com.atcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BKagamiMochi {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < n; i++) {
            nums.add(scan.nextInt());
        }

        System.out.println(nums.size());
        scan.close();

    }
}
