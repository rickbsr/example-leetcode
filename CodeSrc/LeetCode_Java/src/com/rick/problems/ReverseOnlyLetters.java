package com.rick.problems;

public class ReverseOnlyLetters {

    public static void main(String[] args) {
        String S = "Test1ng-Leet=code-Q!";
        String res = new ReverseOnlyLetters().reverseOnlyLetters(S);
        System.out.println(res);
    }

    public String reverseOnlyLetters(String S) {
        if (S.length() < 2) return S;
        // 轉為陣列
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder(S.length());

        // 1st for
        for (char c : chars) {
            // 將字母字元收集起來
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        // 反轉
        sb.reverse();

        // 2nd for
        for (int i = 0, j = 0; i < chars.length; i++) {
            // 將「反轉」後的字母填回去
            if (Character.isLetter(chars[i])) {
                chars[i] = sb.charAt(j++);
            }
        }
        return new String(chars);
    }
}
