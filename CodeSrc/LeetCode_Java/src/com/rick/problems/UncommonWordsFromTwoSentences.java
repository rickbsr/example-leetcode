package com.rick.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UncommonWordsFromTwoSentences {

    public static void main(String[] args) {
        String A = "apple apple", B = "banana";
        String[] res = new UncommonWordsFromTwoSentences().uncommonFromSentences(A, B);
        for (String s : res) System.out.println(s);
    }

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String s : (A + " " + B).split(" "))
            count.put(s, count.getOrDefault(s, 0) + 1);
        ArrayList<String> res = new ArrayList<>();
        for (String s : count.keySet())
            if (count.get(s) == 1) res.add(s);
        return res.toArray(new String[0]);
    }
}
