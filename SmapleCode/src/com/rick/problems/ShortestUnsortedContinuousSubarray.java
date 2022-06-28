package com.rick.problems;

public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int res = new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums);
        System.out.println(res);
    }

    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE, end = -2;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) end = i;
        }

        int min = Integer.MAX_VALUE, start = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) start = i;
        }
        return end - start + 1;
    }
}
