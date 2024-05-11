
package com.atcoder.beginner353;

import java.util.Scanner;

public class D {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] aArr = new int[n];

        for (int i = 0; i < n; i++) {
            aArr[i] = scan.nextInt();
        }

        int mod = 998244353;
        int sum = 0;

        for (int i = 0; i < aArr.length; i++) {
            int a1 = aArr[i];
            for (int j = i + 1; j < aArr.length; j++) {
                int a2 = aArr[j];

                sum = sum + (concat(a1, a2)) % mod;
            }
        }

        System.out.println(sum);
        scan.close();

    }

    private static int concat(int a1, int a2) {
        String aStr1 = String.valueOf(a1);
        String aStr2 = String.valueOf(a2);

        return Integer.valueOf(aStr1.concat(aStr2));
    }
}
