package com.rick.problems;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public static void main(String[] args) {
        int[] candies = {1, 1, 2, 2, 3, 3};
        int res = new DistributeCandies().distributeCandies(candies);
        System.out.println(res);
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) set.add(i);
        return Math.min(set.size(), candies.length / 2);
    }
}