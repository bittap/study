package com.my.study.paiza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B143 {
    public static void main(String[] args) {

        final String SPLIT_VALUE = " ";

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int[] firstLineBySplit = Arrays.stream(line.split(SPLIT_VALUE)).mapToInt(Integer::parseInt).toArray();
        int people = firstLineBySplit[0];
        // キー：先頭の出席番号、値：先頭に連れている列車
        Map<Integer, List<Integer>> winners = initWinners(people);

        int resultCount = firstLineBySplit[1];
        for (int i = 1; i <= resultCount; i++) {
            int[] resultVals = Arrays.stream(sc.nextLine().split(SPLIT_VALUE)).mapToInt(Integer::parseInt).toArray();
            int winnerKey = resultVals[0];
            int loserKey = resultVals[1];

            List<Integer> winnerVal = winners.get(winnerKey);
            List<Integer> loserVal = winners.remove(loserKey);

            List<Integer> collectedVal = Stream.of(winnerVal, loserVal).flatMap(x -> x.stream())
                    .collect(Collectors.toList());
            winners.put(winnerKey, collectedVal);
        }

        int maxPeople = 0;
        List<Integer> outputs = new ArrayList();
        winners.forEach((k, v) -> {
            int nowPeople = v.size();
            if (nowPeople > maxPeople) {
                outputs = new ArrayList();
                outputs.add(k);
            } else if (nowPeople == maxPeople) {
                outputs.add(k);
            }
        });

        outputs.stream().forEach(System.out::println);
    }

    private static Map<Integer, List<Integer>> initWinners(int count) {
        // キー：先頭の出席番号、値：先頭に連れている列車
        Map<Integer, List<Integer>> winners = new HashMap<>();
        for (int i = 1; i <= count; i++) {
            List<Integer> vals = new ArrayList<>();
            vals.add(i);
            winners.put(i, vals);
        }

        return winners;
    }
}
