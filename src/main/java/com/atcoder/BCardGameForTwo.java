package com.atcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BCardGameForTwo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cards.add(scan.nextInt());
        }

        cards = cards.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> aliceCards = new ArrayList<>();
        List<Integer> bobCards = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++) {
            int card = cards.get(i);
            if (i % 2 == 0) {
                aliceCards.add(card);
            } else {
                bobCards.add(card);
            }
        }

        System.out
                .println(aliceCards.stream().reduce(0, (a, b) -> a + b) - bobCards.stream().reduce(0, (a, b) -> a + b));

    }
}
