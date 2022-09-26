package com.rick.problems.medium;

import java.util.Arrays;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "dgsdsfgdsgdsgsdgdsgsdf", needle = "dds";
        int res;
        res = new FindTheIndexOfTheFirstOccurrenceInAStringBruteForce().strStr(haystack, needle);
        res = new FindTheIndexOfTheFirstOccurrenceInAStringStartsWith().strStr(haystack, needle);
        res = new FindTheIndexOfTheFirstOccurrenceInAStringSum().strStr(haystack, needle);
        res = new FindTheIndexOfTheFirstOccurrenceInAStringKmp().strStr(haystack, needle);
        res = new FindTheIndexOfTheFirstOccurrenceInAStringBm().strStr(haystack, needle);
        res = new FindTheIndexOfTheFirstOccurrenceInAStringDefault().strStr(haystack, needle);
        System.out.println(res);
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
        buildBadCharTable(needle);
        buildGoodSuffixTable(needle);

        int idx = 0; // 指向 Text

        while (idx <= haystack.length() - needle.length()) {

            int subtextIdx;
            for (subtextIdx = needle.length() - 1; subtextIdx >= 0; subtextIdx--) {

                if (haystack.charAt(idx + subtextIdx) != needle.charAt(subtextIdx)) break;
                if (subtextIdx == 0) return idx;
            }

            int bcMove = subtextIdx - badCharTable[haystack.charAt(idx + subtextIdx) - 'a'];

            int gsMove = 0;

            if (subtextIdx < needle.length() - 1) gsMove = getGsMove(subtextIdx, needle.length());

            idx += Math.max(bcMove, gsMove);

        }
        return -1;
    }

    int[] badCharTable;  // 記錄每個字元在模式串中最後出現的位置，作為壞字元散列表

    private void buildBadCharTable(String pattern) {
        badCharTable = new int[26]; // 因為英文字母只需要 26 個
        Arrays.fill(badCharTable, -1); // 預設為 -1，代表該字元不存在於陣列
        for (int i = 0; i < pattern.length(); i++) badCharTable[pattern.charAt(i) - 'a'] = i;
    }

    int[] suffix;
    boolean[] prefix;

    private void buildGoodSuffixTable(String pattern) {
        suffix = new int[pattern.length()]; // Key 是好後綴的長度，Val 是長度後綴在 pattern 中的起始位置
        prefix = new boolean[pattern.length()];

        Arrays.fill(suffix, -1);

        for (int i = 0; i < pattern.length() - 1; i++) { // abcab, bcab, cab, ab, b

            int startCount = i;
            int endCount = 0;

            while (startCount >= 0 &&
                    pattern.charAt(startCount) == pattern.charAt(pattern.length() - 1 - endCount)) {
                startCount--;
                endCount++;
            }

            if (endCount != 0) suffix[endCount] = startCount + 1; // 公共字尾子串的起始位置
            if (startCount == -1) prefix[endCount] = true; // 公共字尾子串同時也是模式串的字首子串
        }
    }

    int getGsMove(int subtextIdx, int patternLen) {
        int goodSuffixLen = patternLen - subtextIdx - 1; // 好後綴長度
        if (suffix[goodSuffixLen] != -1) return subtextIdx + 1 - suffix[goodSuffixLen]; // 完全相符

        for (int overlapping = subtextIdx + 2; overlapping < patternLen; overlapping++) {
            if (prefix[patternLen - overlapping]) return overlapping;
        }
        return patternLen;
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringDefault {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
