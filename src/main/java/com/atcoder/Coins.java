package com.atcoder;

import java.util.Scanner;

public class Coins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;
        for (int x = 0; x <= a; x++) {
            for (int y = 0; y <= b; y++) {
                for (int z = 0; z <= c; z++) {
                    int sum = 500 * x + 100 * y + 50 * z;
                    if (k == sum) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
