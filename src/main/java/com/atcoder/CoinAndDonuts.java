package com.atcoder;

import java.util.Scanner;

// 私が出した答え
public class CoinAndDonuts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxK = 25;
        int maxD = 14;
        String anwser = "No";

        Loop1: for (int i = 0; i <= maxK; i++) {
            for (int j = 0; j <= maxD; j++) {
                int sum = 4 * i + 7 * j;
                if (n == sum) {
                    anwser = "Yes";
                    break Loop1;
                }
            }
        }

        System.out.println(anwser);
    }
}

// 他の正解

class CoinAndDonuts2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int change = n;
        while (change >= 0) {
            if (change % 7 == 0) {
                System.out.println("Yes");
                return;
            }
            change = change - 4;
        }

        System.out.println("No");
    }
}
