package com.atcoder;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShiftOnly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        // 黒板に書いてある数字を取得する。
        List<Integer> nums = Stream.of(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int count = 0;

        while (true) {
            boolean hasOdd = nums.stream().anyMatch((e) -> e % 2 == 1);
            if (hasOdd)
                break;
            nums = nums.stream().map(e -> e / 2).collect(Collectors.toList());

            count++;
        }

        System.out.println(count);
    }
}
