package com.rick.problems.easy;

public class ToLowCase {
    public static void main(String[] args) {
        String str = "Hello", res;
        res = new ToLowCaseAsciiAdd().toLowerCase(str);
//        res = new ToLowCaseAsciiXor().toLowerCase(str);
        System.out.println(res);
    }
}

class ToLowCaseAsciiAdd {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += 32;
        return String.valueOf(chars);
    }
}

class ToLowCaseAsciiXor {
    public String toLowerCase(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray())
            builder.append((char) (Character.isUpperCase(c) ? c ^ ' ' : c));
        return builder.toString();
    }
}

class ToLowCaseJDK {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}


