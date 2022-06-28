package com.rick.problems;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        String s = "ababa";
        boolean res = new RepeatedSubstringPattern().repeatedSubstringPattern(s);
        System.out.println(res);
    }

    public boolean repeatedSubstringPattern(String s) {
        List<String> patterns = new ArrayList<>();
        for (int i = 1; i <= s.length() / 2; i++)
            if (s.charAt(0) == s.charAt(i)) patterns.add(s.substring(0, i));
        for (String ptn : patterns) if (isPattern(s, ptn)) return true;
        return false;
    }

    private boolean isPattern(String s, String ptn) {
        int len_s = s.length(), len_ptn = ptn.length();
        if (len_s % len_ptn != 0) return false;
        ptn = new String(new char[len_s / len_ptn]).replace("\0", ptn);
        return s.equals(ptn);
    }
}
