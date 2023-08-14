package com.rick.problems.medium;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        List<Integer> res;
        res = new SortAnArrayBubbleSort().sortArray(nums);
        res = new SortAnArraySinglePivotQuicksort().sortArray(nums);
        res = new SortAnArrayInsertionSort().sortArray(nums);
        for (int i : res) System.out.print(i + " ");
    }
}

class SortAnArrayBubbleSort {
    public List<Integer> sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
        return IntStream.of(nums).boxed().collect(Collectors.toList());
    }
}

class SortAnArraySinglePivotQuicksort {
    public List<Integer> sortArray(int[] nums) {
        singlePivotQuicksort(nums, 0, nums.length - 1);

        return IntStream.of(nums).boxed().collect(Collectors.toList());
    }

    private void singlePivotQuicksort(int[] nums, int start, int end) {
        if (start >= end) return;
        int i = start, j = end, // 起點、止點
                pivot = nums[i + (j - i) / 2]; // 軸心，取中間位
        while (i <= j) {
            while (i <= j && nums[i] < pivot) ++i; // i 向右逼近軸心
            while (i <= j && nums[j] > pivot) --j; // j 向左逼近軸心
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        singlePivotQuicksort(nums, i, end);
        singlePivotQuicksort(nums, start, j);
    }
}

class SortAnArrayInsertionSort {
    public List<Integer> sortArray(int[] nums) {
        for (int i = 1; i < nums.length; ++i)
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; --j) { // 單邊逼近
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        return IntStream.of(nums).boxed().collect(Collectors.toList());
    }
}
