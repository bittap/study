package com.atcoder;

import java.util.Scanner;

public class B81 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (n == i * j) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");

    }
}
