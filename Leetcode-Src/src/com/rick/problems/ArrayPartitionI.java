package com.rick.problems;

import java.util.Arrays;

public class ArrayPartitionI {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        int res = new ArrayPartitionI().arrayPairSum(nums);
        System.out.println(res);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) sum += nums[i];
        return sum;
    }
}
