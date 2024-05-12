package com.atcoder;

import java.util.Scanner;

public class COtoshidama {

    public static void main(String[] args) {

        // 10000円札の最大値から行く。
        // 0円になった時、札の数が合っていないと、10000円札を減らして調整していく。

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int y = scan.nextInt();

        int res10000 = -1;
        int res5000 = -1;
        int res1000 = -1;

        loop1: for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n - a; b++) {
                int c = n - a - b;
                int total = 10000 * a + 5000 * b + 1000 * c;
                if (total == y) {
                    res10000 = a;
                    res5000 = b;
                    res1000 = c;
                    break loop1;
                }
            }
        }

        System.out.print(res10000 + " " + res5000 + " " + res1000);

        scan.close();
    }
}
