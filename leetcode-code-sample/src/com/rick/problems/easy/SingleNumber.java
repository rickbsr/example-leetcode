package com.rick.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3, 2, 1, 2};
        int res;

        // 額外空間法
        res = new SingleNumber().singleNumberContainer(nums);

        // 排序法
        res = new SingleNumber().singleNumberSort(nums);

        // 互斥或法
        res = new SingleNumber().singleNumberXor(nums);

        System.out.println(res);
    }

    public int singleNumberContainer(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums)
            if (map.put(i, true) != null) map.remove(i);
        return map.keySet().iterator().next();
    }

    public int singleNumberSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length - 1; i += 2)
            if (nums[i] != nums[i + 1]) return nums[i];
        return nums[nums.length - 1];
    }

    public int singleNumberXor(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}
