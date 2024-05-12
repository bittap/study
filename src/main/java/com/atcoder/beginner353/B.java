
package com.atcoder.beginner353;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] groups = new int[n];

        for (int i = 0; i < n; i++) {
            groups[i] = scan.nextInt();
        }

        int seat = k;
        int count = 0;

        for (int i = 0; i < groups.length; i++) {
            int curruntNum = groups[i];

            if (seat < groups[i]) {
                seat = k;
                count++;
            }

            seat -= curruntNum;
        }

        count++;

        System.out.println(count);
        scan.close();

    }
}
