package com.rick.problems;

import java.util.Arrays;

public class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, -1, -1, 0};
        int res = new FindPivotIndex().pivotIndex(nums);
        System.out.println(res);
    }

    public int pivotIndex(int[] nums) {
        for (int i = 0, sum = 0, total = Arrays.stream(nums).sum(); i < nums.length; i++) {
            if ((total - nums[i]) == sum * 2) return i;
            sum += nums[i];
        }
        return -1;
    }
}
