package com.atcoder.beginner355;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int M = scan.nextInt();

    List<Integer> A = new ArrayList<Integer>();
    List<Integer> B = new ArrayList<Integer>();

    for (int i = 0; i < N; i++) {
      A.add(scan.nextInt());
    }

    for (int i = 0; i < M; i++) {
      B.add(scan.nextInt());
    }

    List<Integer> C = new ArrayList<Integer>(A);
    C.addAll(B);

    Collections.sort(A);
    Collections.sort(C);

    boolean can = false;

    for (int i = 0; i < C.size() - 1; i++) {
      if (A.contains(C.get(i)) && A.contains(C.get(i + 1))) {
        can = true;
        break;
      }
    }

    if (can) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    scan.close();

  }

}
