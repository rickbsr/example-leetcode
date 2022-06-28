package com.rick.problems;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] res = new IntersectionOfTwoArrays().intersection(nums1, nums2);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        // 建立樣板 Set
        Set<Integer> temp = new HashSet<>();
        for (int i : nums1) temp.add(i);

        // 用於存放交集元素
        Set<Integer> intersection = new HashSet<>();
        for (int i : nums2)
            // 如果 temp 陣列有這個元素，則將它放到 intersection 內
            if (temp.contains(i)) intersection.add(i);

        // 最後轉為 int[]
        int[] res = new int[intersection.size()];
        int i = 0;
        for (int n : intersection) res[i++] = n;
        return res;
    }
}