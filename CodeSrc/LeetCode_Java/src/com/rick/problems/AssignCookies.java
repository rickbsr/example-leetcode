package com.rick.problems;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        int[] g = {1, 2, 3, 4, 3}, s = {2, 4, 5, 3, 9};
        int res = new AssignCookies().findContentChildren(g, s);
        System.out.println(res);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (s[j] >= g[i]) {
                i++;
                j++;
                res++;
            } else j++;
        }
        return res;
    }
}
