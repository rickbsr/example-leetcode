package com.rick.problems;

import java.util.Arrays;

public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 0};
        int res = new LargestNumberAtLeastTwiceOfOthers().dominantIndex(nums);
        System.out.println(res);
    }

    public int dominantIndex(int[] nums) {
        int res = -1, largest = Arrays.stream(nums).max().getAsInt(), second = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == largest) res = i;
            else second = Math.max(second, nums[i]);
        }
        return largest >= second * 2 ? res : -1;
    }
}
