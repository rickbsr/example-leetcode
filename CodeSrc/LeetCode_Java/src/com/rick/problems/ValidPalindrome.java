package com.rick.problems;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "0P";
        boolean res = new ValidPalindrome().isPalindrome(s);
        System.out.println(res);
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            if (Character.isLetter(c) || Character.isDigit(c)) sb.append(c);
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }
}
