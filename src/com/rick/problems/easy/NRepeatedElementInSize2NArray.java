package com.rick.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 1};
        int res;
        res = new NRepeatedElementInSize2NBruteForce().repeatedNTimes(nums);
        res = new NRepeatedElementInSize2NArrayMap().repeatedNTimes(nums);
        res = new NRepeatedElementInSize2NArraySort().repeatedNTimes(nums);
        System.out.println(res);
    }
}

/**
 * 方式一、暴力演算法
 */
class NRepeatedElementInSize2NBruteForce {
    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return nums[i];
            }
        return -1;
    }
}

/**
 * 方式二、容器法
 */
class NRepeatedElementInSize2NArrayMap {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            if (map.put(i, i) != null) return i;
        return -1;
    }
}

/**
 * 方式三、排序法
 */
class NRepeatedElementInSize2NArraySort {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        return nums[nums[0] == nums[nums.length / 2 - 1] ? 0 : nums.length / 2];
    }
}