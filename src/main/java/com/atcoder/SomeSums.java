package com.atcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//私の答え⇒正解
public class SomeSums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();
        List<Integer> outputs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int target = i;

            int num10000 = target / 10000;
            target = target - (num10000 * 10000);

            int num1000 = target / 1000;
            target = target - (num1000 * 1000);

            int num100 = target / 100;
            target = target - (num100 * 100);

            int num10 = target / 10;
            target = target - (num10 * 10);

            int num1 = target;

            int sumLength = num10000 + num1000 + num100 + num10 + num1;

            if (sumLength >= min && sumLength <= max) {
                outputs.add(i);
            }
        }

        System.out.println(outputs.stream().reduce(0, Integer::sum));
    }
}

// 他の人の正解
class SomeSums1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();
        int total = 0;

        for (int i = 1; i <= n; i++) {
            int sumDegits = findSumDegits(i);

            if (sumDegits >= min && sumDegits <= max) {
                total += i;
            }
        }

        System.out.println(total);
    }

    private static int findSumDegits(int n) {
        int sumDegits = 0;

        while (n > 0) {
            sumDegits += n % 10;
            n /= 10;
        }

        return sumDegits;
    }

}
