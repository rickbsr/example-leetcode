package com.rick.problems;

public class ReshapeTheMatrix {

    public static void main(String[] args) {
        int nums[][] = {{1, 2, 3}, {4, 5, 6}}, r = 2, c = 3;
        int[][] res = new ReshapeTheMatrix().matrixReshape(nums, r, c);
        for (int[] arr : res) {
            for (int i : arr) System.out.print(i);
            System.out.println();
        }
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int len = nums.length, arr0Len = nums[0].length, total = len * arr0Len, res[][] = new int[r][c];
        if (r * c != total) return nums;
        for (int i = 0; i < total; i++) res[i / c][i % c] = nums[i / arr0Len][i % arr0Len];
        return res;
    }
}
