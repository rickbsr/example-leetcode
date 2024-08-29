package com.rick.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int[] res = new SetMismatch().findErrorNums(nums);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] findErrorNums(int[] nums) {
        int repeat = 0, lose, len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) if (!set.add(i)) repeat = i;
        lose = len * (len + 1) / 2 - (Arrays.stream(nums).sum() - repeat);
        return new int[]{repeat, lose};
    }
}