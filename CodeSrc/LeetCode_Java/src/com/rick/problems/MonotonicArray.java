package com.rick.problems;

import java.util.Arrays;

public class MonotonicArray {

    public static void main(String[] args) {
        int[] A = {6, 5, 4, 4};
        boolean res = new MonotonicArray().isMonotonic(A);
        System.out.println(res);
    }

    public boolean isMonotonic(int[] A) {
        boolean isDecreasingMonotonic = A[0] > A[A.length - 1];
        int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);
        if (isDecreasingMonotonic)
            for (int i = 0, j = A.length - 1; i < A.length / 2; i++, j--) {
                int temp = B[i];
                B[i] = B[j];
                B[j] = temp;
            }
        return Arrays.equals(A, B);
    }
}
