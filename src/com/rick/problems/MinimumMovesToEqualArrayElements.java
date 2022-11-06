package com.rick.problems;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = new MinimumMovesToEqualArrayElements().minMoves(nums);
        System.out.println(res);
    }

    public int minMoves(int[] nums) {
        if (nums.length <= 1) return 0;
        int res = 0, min = Arrays.stream(nums).min().getAsInt();
        for (int i = 0; i < nums.length; i++) res += nums[i] - min;
        return res;
    }
}
