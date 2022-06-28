package com.rick.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        String s = "fdfsdfsdfsdabgggg", p = "ab";
        List<Integer> res = new FindAllAnagramsInAString().findAnagrams(s, p);
        System.out.println(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++)
            if (p.contains(String.valueOf(s.charAt(i))) && isAnagrams(s.substring(i, i + p.length()), p)) res.add(i);
        return res;
    }

    private boolean isAnagrams(String s, String p) {
        int freq[] = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char c : p.toCharArray()) if (--freq[c - 'a'] < 0) return false;
        return true;
    }
}


