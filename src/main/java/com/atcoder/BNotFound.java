package com.atcoder;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BNotFound {

    public static void main(String[] args) {
        // ソートする。
        Scanner scan = new Scanner(System.in);
        String sStr = scan.nextLine();
        Set<Character> s = new TreeSet<>((a, b) -> a.compareTo(b));

        for (int i = 0; i < sStr.length(); i++) {
            s.add(sStr.charAt(i));
        }

        String alpabet = "abcdefghijklmnopqrstuvwxyz";
        char[] comozi = new char[alpabet.length()];

        for (int i = 0; i < comozi.length; i++) {
            comozi[i] = alpabet.charAt(i);
        }

        for (int i = 0; i < comozi.length; i++) {
            if (!s.contains(comozi[i])) {
                System.out.println(comozi[i]);
                return;
            }
        }

        System.out.println("None");
    }
}
