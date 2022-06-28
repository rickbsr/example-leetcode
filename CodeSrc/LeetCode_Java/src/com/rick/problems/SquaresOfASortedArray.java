package com.rick.problems;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] A = {-7, -3, 2, 3, 11};
        int[] res = new SquaresOfASortedArray().sortedSquares(A);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) A[i] *= A[i];
        Arrays.sort(A);
        return A;
    }
}
