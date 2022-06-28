package com.rick.problems;


import java.util.Arrays;

public class HeightChecker {

    public static void main(String[] args) {
        int[] heights = {};
        int res = new HeightChecker().heightChecker(heights);
        System.out.println(res);
    }

    public int heightChecker(int[] heights) {
        int sorted[] = heights.clone(), count = 0;
        Arrays.sort(sorted);
        for (int i = 0; i < heights.length; i++)
            if (heights[i] != sorted[i]) count++;
        return count;
    }
}
