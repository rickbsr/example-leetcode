package com.rick.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionary {

    public static void main(String[] args) {
        String[] words = {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
        String res = new LongestWordInDictionary().longestWord(words);
        System.out.println(res);
    }

    public String longestWord(String[] words) {
        List<String> list = new ArrayList<>();
        Arrays.sort(words);
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || list.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                list.add(w);
            }
        }
        return res;
    }
}
