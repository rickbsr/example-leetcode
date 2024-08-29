package com.rick.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2,};
        int res;

        res = new SingleNumberContainer().singleNumber(nums);
        res = new SingleNumberSort().singleNumber(nums);
        res = new SingleNumberXor().singleNumber(nums);
        System.out.println(res);
    }
}

/**
 * 方式一、容器法
 */
class SingleNumberContainer {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums)
            if (map.put(i, true) != null) map.remove(i);
        return map.keySet().iterator().next();
    }
}

/**
 * 方式二、排序法
 */
class SingleNumberSort {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length - 1; i += 2)
            if (nums[i] != nums[i + 1]) return nums[i];
        return nums[nums.length - 1];
    }
}

/**
 * 方式三、互斥或法
 */
class SingleNumberXor {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}