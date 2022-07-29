package com.rick.problems;

import java.util.Arrays;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] num1 = {4, 1, 2}, num2 = {1, 3, 4, 2};
        int[] res = new NextGreaterElementI().nextGreaterElement(num1, num2);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) isFound = true;
                else if (isFound && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
