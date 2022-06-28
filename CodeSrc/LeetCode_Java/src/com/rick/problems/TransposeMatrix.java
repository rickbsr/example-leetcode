package com.rick.problems;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = new TransposeMatrix().transpose(A);
        for (int arr[] : res) for (int i : arr) System.out.print(i + " ");
    }

    public int[][] transpose(int[][] A) {
        int lenA = A.length, widA = A[0].length, res[][] = new int[widA][lenA];
        for (int i = 0; i < lenA; i++) for (int j = 0; j < widA; j++) res[j][i] = A[i][j];
        return res;
    }
}
