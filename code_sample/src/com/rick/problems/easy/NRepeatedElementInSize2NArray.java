package com.rick.problems.easy;

import java.util.*;

public class NRepeatedElementInSize2NArray {

    public static void main(String[] args) {
        int res, nums[] = {3, 6, 1, 1};
        res = new NRepeatedElementInSize2NArrayList().repeatedNTimes(nums);
        res = new NRepeatedElementInSize2NArraySet().repeatedNTimes(nums);
        res = new NRepeatedElementInSize2NArrayMap().repeatedNTimes(nums);
        res = new NRepeatedElementInSize2NArraySort().repeatedNTimes(nums);
        res = new NRepeatedElementInSize2NArraySortNeighbor().repeatedNTimes(nums);
        System.out.println(res);
    }
}

class NRepeatedElementInSize2NBruteForce {
    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return nums[i];
            }
        return -1;
    }
}

class NRepeatedElementInSize2NArrayList {
    public int repeatedNTimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        do list.add(nums[i++]);
        while (!list.contains(nums[i]));
        return nums[i];
    }
}

class NRepeatedElementInSize2NArraySet {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        do set.add(nums[i++]);
        while (set.size() == i);
        return nums[i - 1];
    }
}

class NRepeatedElementInSize2NArrayMap {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            if (map.put(i, i) != null) return i;
        return -1;
    }
}

class NRepeatedElementInSize2NArraySort {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        return nums[nums[0] == nums[nums.length / 2 - 1] ? 0 : nums.length / 2];
    }
}

class NRepeatedElementInSize2NArraySortNeighbor {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++)
            if (nums[i] == nums[i + 1]) return nums[i];
        return nums[nums.length - 1];
    }
}