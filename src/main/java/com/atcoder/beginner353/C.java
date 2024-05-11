
package com.atcoder.beginner353;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] aArr = new int[n];

        for (int i = 0; i < n; i++) {
            aArr[i] = scan.nextInt();
        }

        int mod = 100000000;
        int sum = 0;

        for (int i = 0; i < aArr.length; i++) {
            int a1 = aArr[i];
            for (int j = i + 1; j < aArr.length; j++) {
                int a2 = aArr[j];

                sum = sum + (a1 + a2) % mod;
            }
        }

        System.out.println(sum);
        scan.close();

    }
}
