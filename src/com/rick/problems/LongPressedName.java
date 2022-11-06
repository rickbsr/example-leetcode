package com.rick.problems;

public class LongPressedName {
    public static void main(String[] args) {
        String name = "saeed", typed = "ssaaedd";
        boolean res = new LongPressedName().isLongPressedName(name, typed);
        System.out.println(res);
    }

    public boolean isLongPressedName(String name, String typed) {
        // 若第一個字元不符，則排除
        if (name.charAt(0) != typed.charAt(0)) return false;
        // 若最後一個字元不符，則排除
        if (name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1)) return false;
        int i = 0;
        for (char c : typed.toCharArray()) {
            if (i < name.length()) {
                if (c != name.charAt(i)) {
                    if (c == name.charAt(i - 1)) continue; // 代表是長案的產物
                    else return false;
                } else i++; // 代表字元相同
            } else { // 代表已經判斷最後一字元
                if (c != name.charAt(i - 1)) return false;
            }
        }
        return true;
    }
}
