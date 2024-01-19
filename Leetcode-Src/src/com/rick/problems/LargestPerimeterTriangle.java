package com.rick.problems;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] A = {3, 6, 2, 3};
        int res = new LargestPerimeterTriangle().largestPerimeter(A);
        System.out.println(res);
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--)
            if (A[i] < A[i - 1] + A[i - 2]) return A[i] + A[i - 1] + A[i - 2];
        return 0;
    }
}
