package com.rick.problems;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int num1[] = {1, 2, 3, 0, 0, 0}, m = 3, num2[] = {2, 5, 6}, n = 3;
        new MergeSortedArray().merge(num1, m, num2, n);
        for (int i : num1) System.out.print(i + " ");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, nums2.length);
        Arrays.sort(nums1);
    }
}
