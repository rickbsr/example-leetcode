package com.rick.problems.medium;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        int res;
//        res = new FindTheIndexOfTheFirstOccurrenceInAStringBruteForce().strStr(haystack, needle);
        res = new FindTheIndexOfTheFirstOccurrenceInAStringEquals().strStr(haystack, needle);
        System.out.println(res);
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringBruteForce {
    public int strStr(String haystack, String needle) {
        // 排除 needle 是空字串的情況
        if (needle.isEmpty()) return 0;
        outer:
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++)
                if (haystack.charAt(i + j) != needle.charAt(j)) continue outer;
            return i;
        }
        return -1;
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringEquals {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i).startsWith(needle)) return i;
        return -1;
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringKmp {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() <= haystack.length()) {
            int[] f = failureFunction(needle.toCharArray());
            int i = 0, j = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                    if (j == needle.length()) return i - j;
                } else if (j > 0) j = f[j];
                else i++;
            }
        }
        return -1;
    }

    private int[] failureFunction(char[] str) {
        int[] f = new int[str.length + 1];
        for (int i = 2; i < f.length; i++) {
            int j = f[i - 1];
            while (j > 0 && str[j] != str[i - 1]) j = f[j];
            if (j > 0 || str[j] == str[i - 1]) f[i] = j + 1;
        }
        return f;
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringDefault {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}