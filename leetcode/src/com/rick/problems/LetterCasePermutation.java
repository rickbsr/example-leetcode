package com.rick.problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    private List<String> res;

    public static void main(String[] args) {
        String S = "a1b2";
        List<String> res = new LetterCasePermutation().letterCasePermutation(S);
        System.out.println(res);
    }

    public List<String> letterCasePermutation(String S) {
        res = new ArrayList<>();
        recursive(S.toCharArray(), 0);
        return res;
    }

    private void recursive(char[] chars, int i) {

        // 代表已經判斷至最後一位
        if (i == chars.length) {
            res.add(new String(chars));
            return;
        }
        recursive(chars, i + 1);

        // 如果該字元是英文數字
        if (chars[i] > '9') {

            // 大寫轉小寫，小寫轉大寫
            chars[i] ^= (1 << 5);

            // 另外一個分支
            recursive(chars, i + 1);
        }
    }
}
