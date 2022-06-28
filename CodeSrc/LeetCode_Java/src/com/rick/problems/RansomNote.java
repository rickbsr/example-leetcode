package com.rick.problems;

public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aab", magazine = "aab";
        boolean res = new RansomNote().canConstruct(ransomNote, magazine);
        System.out.println(res);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);
        for (char c : ransomNote.toCharArray()) {
            int idx = sb.indexOf(String.valueOf(c));
            if (idx == -1) return false;
            else sb.deleteCharAt(idx);
        }
        return true;
    }
}
