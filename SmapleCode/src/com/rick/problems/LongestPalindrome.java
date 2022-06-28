package com.rick.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        int res = new LongestPalindrome().longestPalindrome(s);
        System.out.println(res);
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else set.add(c);
        }
        return count * 2 + (set.isEmpty() ? 0 : 1);
    }
}
