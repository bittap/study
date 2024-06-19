package com.codility;

class Solution2 {
  public int[] solution(int[] A, int K) {

    for (int i = 0; i < K; i++) {
      int[] temp = new int[A.length];
      for (int j = 0; j < A.length; j++) {
        if (j == A.length - 1) {
          temp[0] = A[j];
        } else {
          temp[j + 1] = A[j];
        }
      }
      A = temp;
    }

    return A;
  }
}
