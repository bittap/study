
package com.atcoder.beginner353;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int seat = k;
        int count = 0;

        int[] groups = new int[n];

        for (int i = 0; i < n; i++) {
            groups[i] = scan.nextInt();
        }

        for (int i = 0; i < groups.length;) {
            int curruntNum = groups[i];

            if (seat - curruntNum >= 0) {
                seat = seat - curruntNum;
                i++;
                if (i == groups.length - 1) {
                    count++;
                }
            } else {
                count++;
                seat = k;
            }
        }

        System.out.println(count);
        scan.close();

    }
}
