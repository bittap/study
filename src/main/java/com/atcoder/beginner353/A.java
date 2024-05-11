
package com.atcoder.beginner353;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int h1 = scan.nextInt();

        int max = h1;
        int answer = -1;

        for (int i = 2; i <= n; i++) {
            int currentNum = scan.nextInt();
            if (currentNum > max) {
                max = currentNum;
                answer = i;
                break;
            }
        }

        System.out.println(answer);
        scan.close();

    }
}
