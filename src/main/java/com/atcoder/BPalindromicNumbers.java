package com.atcoder;

import java.util.Scanner;

public class BPalindromicNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();

        int count = 0;
        for (; start <= end; start++) {
            if (start == reverse(start)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int reverse(int n) {
        StringBuilder reverse = new StringBuilder();

        while (n > 0) {
            reverse.append(n % 10);
            n /= 10;
        }

        return Integer.parseInt(reverse.toString());
    }
}
