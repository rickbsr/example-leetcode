package com.rick.problems;

public class ShortestCompletingWord {

    public static void main(String[] args) {
        String licensePlate = "B687015", words[] = {"born", "give", "would", "nice", "in", "understand", "blue", "force", "have", "that"};
        String res = new ShortestCompletingWord().shortestCompletingWord(licensePlate, words);
        System.out.println(res);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] codePlate = encode(licensePlate);
        String res = null;
        for (String word : words) {
            int[] codeWord = encode(word);
            if (isFit(codePlate, codeWord) && (res == null || word.length() < res.length())) res = word;
        }
        return res;
    }

    private int[] encode(String s) {
        int[] code = new int[26];
        for (char c : s.toLowerCase().toCharArray()) if (Character.isLetter(c)) code[c - 'a']++;
        return code;
    }

    private boolean isFit(int[] plate, int[] word) {
        for (int i = 0; i < plate.length; i++) if (plate[i] > word[i]) return false;
        return true;
    }
}
