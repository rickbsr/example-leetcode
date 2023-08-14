package com.rick.problems.easy;

public class ToLowCase {
    public static void main(String[] args) {
        String str = "Hello", res;

        // 「ASCII」加法
        res = new ToLowCaseAsciiAdd().toLowerCase(str);

        // 「ASCII」互斥或法
        res = new ToLowCaseAsciiXor().toLowerCase(str);

        // 原生「Java API」
        res = new ToLowCaseDefault().toLowerCase(str);
        System.out.println(res);
    }
}

/**
 * 方式一、「ASCII」加法
 */
class ToLowCaseAsciiAdd {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += 32;
        return String.valueOf(chars);
    }
}

/**
 * 方式二、「ASCII」互斥或法
 */
class ToLowCaseAsciiXor {
    public String toLowerCase(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray())
            builder.append((char) (Character.isUpperCase(c) ? c ^ ' ' : c));
        return builder.toString();
    }
}

/**
 * 方式三、原生「Java API」
 */
class ToLowCaseDefault {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
