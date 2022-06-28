package com.rick.problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        int res = new UniqueMorseCodeWords().uniqueMorseRepresentations(words);
        System.out.println(res);
    }

    public int uniqueMorseRepresentations(String[] words) {

        final String[] MORSE_CODE = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        // 利用 Set 的特性來過濾重覆字串
        Set<String> set = new HashSet<>();
        for (String s : words) {
            // 用來拼摩斯密碼的容器
            StringBuilder sb = new StringBuilder(s.length());

            // 逐字轉換
            for (int c : s.toCharArray()) {
                // 取得對應表
                sb.append(MORSE_CODE[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
