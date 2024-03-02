package com.my.study.paiza;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class B036 {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // 候補者数を取得する
        int candidatorCount = Integer.parseInt(line);
        // キー：政党名、値：候補者リスト
        Map<String, List<Candidator>> candidatorMaps = new HashMap<>();
        for (int i = 1; i <= candidatorCount; i++) {
            // 政党
            String politicalParty = sc.nextLine();
            if (candidatorMaps.containsKey(candidatorMaps)) {
                List<Candidator> candidators = candidatorMaps.get(politicalParty);
                candidators.add(new Candidator(i));
                candidatorMaps.put(politicalParty, candidators);
            } else {
                List<Candidator> candidators = List.of(new Candidator(i));
                candidatorMaps.put(politicalParty, candidators);
            }

        }
        // 投票者数
        int voterSize = Integer.parseInt(sc.nextLine());
        // キー：投票者の番号、値：投票者の投票リスト
        Map<Integer, List<String>> voterMaps = new HashMap<>();
        for (int i = 1; i <= voterSize; i++) {
            // 投票リスト
            List<String> voteVals = Arrays.asList(sc.nextLine().split(" "));
            voterMaps.put(i, voteVals);
        }
        // 予備選挙
        voterMaps.forEach((k, v) -> {
            int allPoliticalPartyCount = candidatorMaps.size();
            // キー：政党名、値：true(投票計算完了)、flase(投票計算未完了)
            Map<String, Boolean> votedMaps = new HashMap<>();
            candidatorMaps.forEach((k2, v2) -> {
                votedMaps.put(k2, false);
            });
            AtomicInteger nowVotedEcahPoliticalPartyCount = new AtomicInteger();
            AtomicBoolean completed = new AtomicBoolean();
            v.forEach(e -> {
                candidatorMaps.forEach((k2, v2) -> {
                    if (!votedMaps.get(k2)) {
                        Candidator candidator = v2.stream().filter(e1 -> e1.number == Integer.parseInt(e)).findFirst()
                                .get();
                        if (candidator.number == Integer.parseInt(e)) {
                            votedMaps.put(k2, true);
                            candidator.votedCount = candidator.votedCount + 1;
                        }
                    }
                });
            });
        });
        // 本番選挙
        // 候補者リスト
        List<Candidator> finals = candidatorMaps.entrySet().stream()
        // 該当の政党の最初に見つけた候補者番号を取得する
        System.out.println("XXXXXX");
    }

    public static class Candidator {
        int number;
        int votedCount;

        /**
         * @param number
         */
        public Candidator(int number) {
            this.number = number;
        }

    }
}
