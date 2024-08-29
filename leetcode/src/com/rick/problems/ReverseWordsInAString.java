package com.rick.problems;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "   a   b ";
        String res = new ReverseWordsInAString().reverseWords(s);
        System.out.println(res);
    }

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        // 將字串拆成單字, " +" 代表一個或以上的「空格字元」
        for (String str : s.split(" +")) {
            // 從前面插入單字
            sb.insert(0, str).insert(0, " ");
        }
        return sb.toString().trim();
    }
}
