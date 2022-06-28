package com.rick.problems;

import java.util.Arrays;

public class KeyboardRow {

    int[] ints = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] res = new KeyboardRow().findWords(words);
        System.out.println(res);
    }

    public String[] findWords(String[] words) {
        String[] res = new String[words.length];
        int index = 0;
        for (String str : words)
            if (checkWord(str.toLowerCase())) res[index++] = str;
        return Arrays.copyOfRange(res, 0, index);
    }

    private boolean checkWord(String word) {
        int standard = ints[word.charAt(0) - 'a'];
        for (char c : word.toCharArray())
            if (ints[c - 'a'] != standard) return false;
        return true;
    }
}
