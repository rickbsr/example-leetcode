package com.rick.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned[] = {"hit"};
        String res = new MostCommonWord().mostCommonWord(paragraph, banned);
        System.out.println(res);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");

        Set<String> set = new HashSet<>();
        for (String word : banned) set.add(word);

        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            if (!set.contains(word)) map.put(word, map.getOrDefault(word, 0) + 1);

        int frequencyMax = 0;
        String res = "";
        for (String str : map.keySet())
            if (map.get(str) > frequencyMax) {
                frequencyMax = map.get(str);
                res = str;
            }

        return res;
    }
}
