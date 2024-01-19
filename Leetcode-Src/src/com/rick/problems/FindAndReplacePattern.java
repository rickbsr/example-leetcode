package com.rick.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public static void main(String[] args) {
        String words[] = {"abc", "deq", "mee", "aqq", "dkd", "ccc"}, pattern = "abb";
        List<String> res = new FindAndReplacePattern().findAndReplacePattern(words, pattern);
        System.out.println(res);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) if (isIsomorphic(word, pattern)) res.add(word);
        return res;
    }

    public boolean isIsomorphic(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char a = word.charAt(i), b = pattern.charAt(i);
            if (map.containsKey(a) && map.get(a).equals(b)) continue;
            else if (!map.containsKey(a) && !map.containsValue(b)) map.put(a, b);
            else return false;
        }
        return true;
    }
}
