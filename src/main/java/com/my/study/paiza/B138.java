package com.my.study.paiza;

import java.util.Arrays;
import java.util.Scanner;

public class B138 {

    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] chars1Size = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        // H W分配列サイズを生成しておく
        // 文字を全部配列に格納
        char[][] chars1 = new char[chars1Size[0]][chars1Size[1]];
        for (int i = 0; i < chars1.length; i++) {
            char[] lineChars = sc.nextLine().toCharArray();
            for (int j = 0; j < chars1[i].length; j++) {
                chars1[i][j] = lineChars[j];
            }
        }
        // 正解の数
        int result = 0;
        // 正解の配列
        char[][] chars2 = {
                { '#', '#', '#' },
                { '#', '.', '#' },
                { '#', '#', '#' }
        };

        for (int i1 = 0; i1 < chars1.length; i1++) {
            j1: for (int j1 = 0; j1 < chars1[i1].length; j1++) {
                System.out.printf("i1 : %d, j1 : %d\n", i1, j1);
                for (int i2 = 0; i2 < chars2.length; i2++) {
                    for (int j2 = 0; j2 < chars2[i2].length; j2++) {
                        if (i1 + i2 < chars1.length && j1 + j2 < chars1[i1 + i2].length) {
                            char char1 = chars1[i1 + i2][j1 + j2];
                            char char2 = chars2[i2][j2];
                            System.out.printf("%s ⇔ %s\n", char1, char2);
                            if (char1 != char2) {
                                System.out.println("文字が違うため、次の比較に行く");
                                continue j1;
                            }
                        } else {
                            System.out.printf("i1 : %d, j1 : %d, i2 : %d, j2 : %d\n", i1, j1, i1, j2);
                            continue j1;
                        }
                    }
                }
                System.out.println("成功");
                result++;
            }
        }
        System.out.println(result);

    }
}
