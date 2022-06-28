package com.rick.problems;

import java.util.Arrays;

public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int res = new SingleNumberII().singleNumber(nums);
        System.out.println(res);
    }

    public int singleNumber(int[] nums) {
        int len = nums.length, i;
        Arrays.sort(nums);
        for (i = 0; i < len - 1 && nums[i] == nums[i + 1]; i += 3) ;
        return nums[i];
    }
}
