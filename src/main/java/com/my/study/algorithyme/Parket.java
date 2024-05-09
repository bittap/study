package com.my.study.algorithyme;

public class Parket {

    public static void main(String[] args) {
        int[] N = new int[] { 10, 8, 8, 6 };
        int[] num = new int[110]; // バケット
        for (int i = 0; i < N.length; ++i) {
            num[N[i]]++; // d[i] が 1 個増える
        }

        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
