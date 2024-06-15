package com.atcoder.abc213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BBoobyPrize {

  static class BoobyPrize implements Comparable<BoobyPrize> {
    private int score;
    private int position;

    public BoobyPrize(int score, int position) {
      this.score = score;
      this.position = position;
    }

    @Override
    public int compareTo(BoobyPrize o) {
      return Integer.valueOf(this.score).compareTo(o.score);
    }

  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    List<BoobyPrize> boobyPrizes = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      boobyPrizes.add(new BoobyPrize(scan.nextInt(), i + 1));
    }

    scan.close();

    Collections.sort(boobyPrizes);

    System.out.println(boobyPrizes.get(boobyPrizes.size() - 2).position);
  }

}
