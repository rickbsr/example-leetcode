package com.rick.problems.easy;

public class RepeatedStringMatch {

    public static void main(String[] args) {
        String a = "bb", b = "bbbbbbb";
        int res = new RepeatedStringMatch().repeatedStringMatch(a, b);
        System.out.println(res);
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        return sb.toString().contains(b) ? count : sb.append(a).toString().contains(b) ? count + 1 : -1;
    }

    public int repeatedStringMatchOS(String a, String b) {
        String str = a;
        for (int i = 1; i <= b.length() / a.length() + 2; i++, str = a.concat(str))
            if (str.contains(b)) return i;
        return -1;
    }

    public int repeatedStringMatchMath(String a, String b) {
        int n = b.length() / a.length();
        if (b.length() % a.length() == 0 && a.repeat(n).equals(b)) {
            return n;
        } else if (a.repeat(n + 1).contains(b)) {
            return n + 1;
        } else if (a.repeat(n + 2).contains(b)) {
            return n + 2;
        } else return -1;
    }
}
