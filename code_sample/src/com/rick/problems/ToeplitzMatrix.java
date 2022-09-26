package com.rick.problems;

public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
        boolean res = new ToeplitzMatrix().isToeplitzMatrix(matrix);
        System.out.println(res);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
        return true;
    }
}
