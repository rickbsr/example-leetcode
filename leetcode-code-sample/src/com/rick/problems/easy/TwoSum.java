package com.rick.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        int nums[] = {3, 2, 4}, target = 6, res[];

        res = new TwoSumMap().twoSum(nums, target);
        res = new TwoSumBruteForce().twoSum(nums, target);

        for (int i : res) System.out.print(i + " ");
    }
}

class TwoSumBruteForce {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if (i != j && (nums[i] + nums[j] == target))
                    return new int[]{i, j};
        return null;
    }
}

class TwoSumMap {
    public int[] twoSum(int[] nums, int target) {

        if (nums.length == 2) return new int[]{0, 1}; // 可有可無，其實對效能影響不大

        Map<Integer, Integer> map = new HashMap<>();
        // 『值』當作 key，『順序』當作 value
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 所需數值 = 目標值 - 當前值
            // 判斷 Map 中是否有符合的值且不為同一元素
            if (map.containsKey(complement) && map.get(complement) != i)
                return new int[]{i, map.get(complement)}; // 若符合條件則為答案
        }
        return null;
    }
}