package com.atcoder;

import java.util.Scanner;

public class BDigits {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        System.out.println(calDigits(n, k).length());
    }

    public static String calDigits(int n, int k) {
        StringBuilder digits = new StringBuilder();

        while (n > 0) {
            digits.append(n % k);
            n /= k;
        }

        return digits.toString();
    }
}
