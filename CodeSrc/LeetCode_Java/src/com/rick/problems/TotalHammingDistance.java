package com.rick.problems;

public class TotalHammingDistance {

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        int res = new TotalHammingDistance().totalHammingDistance(nums);
        System.out.println(res);
    }

    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                total += Integer.bitCount(nums[i] ^ nums[j]);
        return total;
    }
}
