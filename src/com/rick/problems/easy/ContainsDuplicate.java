package com.rick.problems.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4};
        boolean res;
        res = new ContainsDuplicateSort().containsDuplicate(nums);
        res = new ContainsDuplicateSet().containsDuplicate(nums);
        System.out.println(res);
    }
}

/**
 * 方式一、容器法
 */
class ContainsDuplicateSet {
    public boolean containsDuplicate(int[] nums) {
        return nums.length !=
                new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList())).size();
    }
}

/**
 * 方式二、排序法
 */
class ContainsDuplicateSort {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; )
            if (nums[i] == nums[++i]) return true;
        return false;
    }
}



