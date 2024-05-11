
package com.atcoder.beginner353;

import java.util.Scanner;

public class E {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] aArr = new String[n];

        for (int i = 0; i < n; i++) {
            aArr[i] = scan.next();
        }

        int sum = 0;

        for (int i = 0; i < aArr.length; i++) {
            String a1 = aArr[i];
            for (int j = i + 1; j < aArr.length; j++) {
                String a2 = aArr[j];

                sum = compare(a1, a2);
            }
        }

        System.out.println(sum);
        scan.close();

    }

    private static int compare(String a1, String a2) {
        int minLen = a1.length() < a2.length() ? a1.length() : a2.length();
        int sameCount = 0;

        for (int i = 0; i < minLen; i++) {
            if (a1.charAt(i) == a2.charAt(i)) {
                sameCount++;
            } else {
                break;
            }
        }

        return sameCount;
    }
}
