package com.rick.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] res = new IntersectionOfTwoArraysII().intersect(nums1, nums2);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        // 宣告存放結果的容器
        List<Integer> intersect = new ArrayList<>();

        // 將陣列排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0, j = 0; (i < nums1.length && j < nums2.length); ) {

            // 小的往前走
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else { // 相同就把值加入 List 內，並一起走
                intersect.add(nums1[i]);
                i++;
                j++;
            }
        }

        // 最後轉為 int[]
        int[] res = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) res[i] = intersect.get(i);
        return res;
    }
}
