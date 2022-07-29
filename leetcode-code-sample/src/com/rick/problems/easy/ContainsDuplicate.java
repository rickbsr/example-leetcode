package com.rick.problems.easy;

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4};
        boolean res = new ContainsDuplicate().containsDuplicate(nums);
        System.out.println(res);
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; )
            if (nums[i] == nums[++i]) return true; // 相鄰判斷
        return false;
    }

    public boolean containsDuplicateBySet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        return set.size() != nums.length; // 判斷個數是否相同
    }

    public boolean containsDuplicateByMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) if (map.put(i, 0) != null) return true;
        return false;
    }
}
