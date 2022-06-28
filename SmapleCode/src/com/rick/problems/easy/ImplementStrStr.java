package com.rick.problems.easy;

public class ImplementStrStr {

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "pi";
        int res = new ImplementStrStr().strStr(haystack, needle);
        System.out.println(res);
    }

    public int strStr(String haystack, String needle) {
        // 排除 needle 是空字串的情況
        if (needle.isEmpty()) return 0;
        // Outer For-Loop
        for (int i = 0, j; i < haystack.length(); i++) {
            // 排除 needle 字串的長度大於「比對字串」的長度
            if (i + needle.length() > haystack.length()) return -1;
            if (haystack.charAt(i) == needle.charAt(0)) { // 僅比對第一個字元
                // 逐一字元進行比對
                for (j = 1; j < needle.length(); j++)
                    // 若有一項比對失敗，則直接中斷
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                // 若 j 等於 needle 的長度，代表著比對成功，返回索引 i
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }

    public int strStrByEquals(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        if (nLen == 0) return 0;
        else if (hLen >= nLen) {
            for (int i = 0; i <= hLen - nLen; i++)
                if (haystack.substring(i, i + nLen).equals(needle)) return i;
        }
        return -1;
    }

    public int strStrByKmp(String haystack, String needle) {
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

