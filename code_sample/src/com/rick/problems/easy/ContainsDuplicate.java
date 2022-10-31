package com.rick.problems.easy;

import java.util.*;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4};
        boolean res;
        res = new ContainsDuplicateSort().containsDuplicate(nums);
        res = new ContainsDuplicateSet().containsDuplicate(nums);
        res = new ContainsDuplicateOneLine().containsDuplicate(nums);
        res = new ContainsDuplicateMap().containsDuplicate(nums);
        System.out.println(res);
    }
}

class ContainsDuplicateSort {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; )
            if (nums[i] == nums[++i]) return true; // 相鄰判斷
        return false;
    }
}

class ContainsDuplicateSet {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        return set.size() != nums.length; // 判斷個數是否相同
    }
}

class ContainsDuplicateOneLine {
    public boolean containsDuplicate(int[] nums) {
        return nums.length != new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList())).size();
    }
}

class ContainsDuplicateMap {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) if (map.put(i, 0) != null) return true;
        return false;
    }
}