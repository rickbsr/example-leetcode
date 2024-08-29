package com.rick.problems;

public class StringWithoutAAAOrBBB {

    public static void main(String[] args) {
        int A = 1, B = 4;
        String res = new StringWithoutAAAOrBBB().strWithout3a3b(A, B);
        System.out.println(res);
    }

    public String strWithout3a3b(int A, int B) {
        return (A > B) ? combinChar(A, B, 'a') : combinChar(B, A, 'b');
    }

    private String combinChar(int A, int B, char C) {
        StringBuilder sb = new StringBuilder(A + B);
        while (A-- > 0) {
            // 先拼一次多的那個字元
            sb.append(C);
            // 如果 A 是多的那方，則再拼一個
            if (A > B) {
                sb.append(C);
                A--;
            }
            // 記得補上一個 B
            if (B-- > 0) sb.append((char) ('a' + 'b' - C));
        }
        return sb.toString();
    }
}
