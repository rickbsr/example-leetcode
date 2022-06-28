package com.rick.problems;

import java.util.Arrays;

public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] nums = {3, 55, 5, 5, 5, 5, 2};
        int res = new ThirdMaximumNumber().thirdMax(nums);
        System.out.println(res);
    }

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 2, count = 1; i >= 0; i--)
            if (nums[i] < nums[i + 1] && (++count == 3)) return nums[i];
        return nums[nums.length - 1];
    }
}
