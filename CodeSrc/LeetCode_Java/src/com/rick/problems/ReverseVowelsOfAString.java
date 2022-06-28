package com.rick.problems;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        String s = "leetcode";
        String res = new ReverseVowelsOfAString().reverseVowels(s);
        System.out.println(res);
    }

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        StringBuilder vowels = new StringBuilder();

        // 1st for
        for (char c : chars) if (isVowel(c)) vowels.append(c);

        // 翻轉
        vowels.reverse();

        // 2st for
        for (int i = 0, j = 0; i < chars.length; i++) if (isVowel(chars[i])) chars[i] = vowels.charAt(j++);
        return new String(chars);
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
