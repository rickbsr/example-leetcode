package com.rick.problems;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", str = "dog f cat dog";
        boolean res = new WordPattern().wordPattern(pattern, str);
        System.out.println(res);
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> map = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i))
                return false;
        return true;
    }
}
