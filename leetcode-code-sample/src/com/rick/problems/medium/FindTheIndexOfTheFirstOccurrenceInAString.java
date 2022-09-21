package com.rick.problems.medium;

import java.util.Arrays;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        String haystack = "abcdefghij", needle = "hij";
        int res;
//        res = new FindTheIndexOfTheFirstOccurrenceInAStringBruteForce().strStr(haystack, needle);
//        res = new FindTheIndexOfTheFirstOccurrenceInAStringStartsWith().strStr(haystack, needle);
//        res = new FindTheIndexOfTheFirstOccurrenceInAStringSum().strStr(haystack, needle);
//        res = new FindTheIndexOfTheFirstOccurrenceInAStringKmp().strStr(haystack, needle);
        res = new FindTheIndexOfTheFirstOccurrenceInAStringBm().strStr(haystack, needle);
//        res = new FindTheIndexOfTheFirstOccurrenceInAStringDefault().strStr(haystack, needle);
        System.out.println(res);

        System.out.println(haystack.substring(res, res + needle.length()));
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringBruteForce {
    public int strStr(String haystack, String needle) {
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

class FindTheIndexOfTheFirstOccurrenceInAStringStartsWith {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i).startsWith(needle)) return i;
        return -1;
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringSum {
    public int strStr(String haystack, String needle) {
        int needleSum = 0, haystackBaseSum = 0;
        if (needle.isEmpty()) return 0;
        if (haystack.length() >= needle.length()) {
            for (int i = 0; i < needle.length(); i++) {
                needleSum += needle.charAt(i);
                haystackBaseSum += haystack.charAt(i);
            }

            for (int i = 0; i <= haystack.length() - needle.length(); i++)
                if (haystackBaseSum == needleSum && haystack.substring(i).startsWith(needle)) return i;
                else if (i == haystack.length() - needle.length()) break;
                else haystackBaseSum += (haystack.charAt(i + needle.length()) - haystack.charAt(i));
        }
        return -1;
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringKmp {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() <= haystack.length()) {
            int[] f = failureFunction(needle);
            for (int i = 0, j = 0; i < haystack.length(); ) {
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

    private int[] failureFunction(String patternStr) {
        int[] pmt = new int[patternStr.length() + 1];
        char[] chars = patternStr.toCharArray();
        for (int i = 2; i < pmt.length; i++) {
            int j = pmt[i - 1];
            while (j > 0 && chars[j] != chars[i - 1]) j = pmt[j];
            if (j > 0 || chars[j] == chars[i - 1]) pmt[i] = j + 1;
        }
        return pmt;
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringBm {

    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) return -1;

        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();

        for (int haystackIdx = 0; haystackIdx <= haystack.length() - needle.length(); haystackIdx++) {

            int badCharacterShift = getBadCharacter(haystack, needle, haystackIdx);

            if ((badCharacterShift) == 0) {
                return haystackIdx;
            }

//            int goodSuffixShift = getGoodSuffix(haystack, needle, haystackIdx);


        }
        return -1;
    }

    private int getBadCharacter(String haystack, String needle, int index) {
        for (int haystackIdx = index + needle.length() - 1, needleIdx = needle.length() - 1; needleIdx >= 0; haystackIdx--, needleIdx--) {
            if (haystack.charAt(haystackIdx) != needle.charAt(needleIdx)) {
                char badChar = haystack.charAt(haystackIdx);
                int idxOfNeedle = needle.indexOf(badChar);
                return haystackIdx - index - idxOfNeedle;
            }
        }
        return 0;
    }

//    private int getGoodSuffix(String haystack, String needle, int index) {
//        for (int haystackIdx = index + needle.length() - 1, needleIdx = needle.length() - 1; needleIdx >= 0; haystackIdx--, needleIdx--) {
//            if (haystack.charAt(haystackIdx) != needle.charAt(needleIdx)) {
//
////                String goodSuffix = needle.substring(needleIdx);
////
////                String temp = haystack.substring(index, index + needle.length() - goodSuffix.length());
////                System.out.println(temp);
////
////                if (temp.contains(goodSuffix)) {
////                    return haystackIdx - index + temp.indexOf(goodSuffix);
////                }
////
////                for (int i = goodSuffix.length() - 2; i >= 0; i--) {
////                    haystack.indexOf(haystackIdx)
////                }
////
//////                int idxOfNeedle = needle.indexOf(badChar);
////
////                return haystackIdx - index - idxOfNeedle;
//            }
//        }
//    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringDefault {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

