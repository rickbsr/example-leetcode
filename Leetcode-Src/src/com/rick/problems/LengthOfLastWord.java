package com.rick.problems;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "aaa";
        int res = new LengthOfLastWord().lengthOfLastWord(s);
        System.out.println(res);
    }

    public int lengthOfLastWord(String s) {

        // 去頭尾空白符號
        s = s.trim();

        // 排除例外狀況
        if (s == null) return 0;

        // 字串長度
        int len = s.length();

        // 找出最後 " " 的位置
        int idx = s.lastIndexOf(" ");

        return idx != -1 ? len - idx - 1 : len;
    }
}
