package com.rick.problems;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "aab", t = "aba";
        boolean res = new ValidAnagram().isAnagram(s, t);
        System.out.println(res);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length(), freq[] = new int[26];
        for (int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++) if (freq[t.charAt(i) - 'a']-- == 0) return false;
        return true;
    }
}
