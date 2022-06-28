package com.rick.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups {

    public static void main(String[] args) {
        String S = "aaabbbbccc";
        List<List<Integer>> res = new PositionsOfLargeGroups().largeGroupPositions(S);
        System.out.println(res);
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        S = S.concat("$");
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, startIdx = 0, count = 0, currentChar = S.charAt(0); i < S.length(); i++)
            if (S.charAt(i) == currentChar) count++;
            else {
                if (count >= 3) res.add(Arrays.asList(startIdx, startIdx + count - 1));
                currentChar = S.charAt(i);
                startIdx = i;
                count = 1;
            }
        return res;
    }
}
