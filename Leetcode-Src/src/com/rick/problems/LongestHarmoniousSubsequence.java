package com.rick.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int res = new LongestHarmoniousSubsequence().findLHS(nums);
        System.out.println(res);
    }

    public int findLHS(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        for (long key : map.keySet())
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key + 1) + map.get(key));
        return res;
    }
}
