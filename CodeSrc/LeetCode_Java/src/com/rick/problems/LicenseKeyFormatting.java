package com.rick.problems;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String S = "2-5g-3-J";
        int K = 2;
        String res = new LicenseKeyFormatting().licenseKeyFormatting(S, K);
        System.out.println(res);
    }

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--)
            if (S.charAt(i) != '-')
                sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }
}
