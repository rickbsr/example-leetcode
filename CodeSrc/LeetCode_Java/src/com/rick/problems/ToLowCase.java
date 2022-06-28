package com.rick.problems;

public class ToLowCase {
    public static void main(String[] args) {
        String str = "Hello";
        String res = new ToLowCase().toLowerCase(str);
        System.out.println(res);
    }

    public String toLowerCase(String str) {

        StringBuilder sb = new StringBuilder(str.length());
        for (int c : str.toCharArray()) {

            // 如果該字元介於 A ~ Z 之前，則轉成小寫
            if (c >= 'A' && c <= 'Z') c ^= (1 << 32);

            sb.append((char) c);
        }
        return sb.toString();
    }
}
