package com.rick.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        List<Integer> res = new SortAnArray().sortArray(nums);
        for (int i : res) System.out.print(i + " ");
    }

    // By Arrays.sort()
    public List<Integer> sortArray(int[] nums) {
        Arrays.sort(nums);
        return changeArrayToList(nums);
    }

    // By Brute Force
    public List<Integer> sortArrayByBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] > nums[j]) swap(nums, i, j);
        return changeArrayToList(nums);
    }

    // By Single Pivot Quicksort
    public List<Integer> sortArrayBySinglePivotQuicksort(int[] nums) {
        singlePivotQuicksort(nums, 0, nums.length - 1);;
        return changeArrayToList(nums);
    }

    private void singlePivotQuicksort(int[] nums, int start, int end) {
        if (start >= end) return;
        int i = start, j = end, // 起點、止點
                pivot = nums[i + (j - i) / 2]; // 軸心，取中間位
        while (i <= j) {
            while (i <= j && nums[i] < pivot) ++i; // i 向右逼近軸心
            while (i <= j && nums[j] > pivot) --j; // j 向左逼近軸心
            if (i <= j) swap(nums, i++, j--);
        }
        singlePivotQuicksort(nums, i, end);
        singlePivotQuicksort(nums, start, j);
    }

    // By Insertion Sort
    public List<Integer> sortArrayByInsertionSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i)
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; --j) // 單邊逼近
                swap(nums, j, j - 1);
        return changeArrayToList(nums);
    }

    // 互換
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 將 Array 轉成 List
    private List<Integer> changeArrayToList(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) res.add(i);
        return res;
    }
}


