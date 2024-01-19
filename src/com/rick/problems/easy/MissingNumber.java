package com.rick.problems.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        int res;
        res = new MissingNumberContainer().missingNumber(nums);
        res = new MissingNumberSoft().missingNumber(nums);
        res = new MissingNumberSub().missingNumber(nums);
        res = new MissingNumberXor().missingNumber(nums);
        System.out.println(res);
    }
}

/**
 * 方式一、容器法
 */
class MissingNumberContainer {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) set.add(i);
        for (int i : nums) set.remove(i);
        return set.iterator().next();
    }
}

/**
 * 方式二、排序法
 */
class MissingNumberSoft {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) if (i != nums[i]) return i;
        return nums.length;
    }
}

/**
 * 方式三、扣除法
 */
class MissingNumberSub {
    public int missingNumber(int[] nums) {
        return (nums.length + 1) * nums.length / 2 - IntStream.of(nums).sum();
    }
}

/**
 * 方式四、互斥或法
 */
class MissingNumberXor {
    public int missingNumber(int[] nums) {
        int check = 0;
        for (int i = 0; i < nums.length; i++) check ^= nums[i] ^ (i + 1);
        return check;
    }
}