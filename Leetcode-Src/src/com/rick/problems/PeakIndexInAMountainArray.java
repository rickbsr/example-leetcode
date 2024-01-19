package com.rick.problems;

public class PeakIndexInAMountainArray {

    public static void main(String[] args) {
        int[] A = {0, 2, 1, 0};
        int res = new PeakIndexInAMountainArray().peakIndexInMountainArray(A);
        System.out.println(res);
    }

    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        for (; i < A.length - 1; i++) if (A[i] > A[i + 1]) break;
        return i;
    }
}
