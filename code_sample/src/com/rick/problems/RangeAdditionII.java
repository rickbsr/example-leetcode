package com.rick.problems;

public class RangeAdditionII {

    public static void main(String[] args) {
        int m = 3, n = 3, ops[][] = new int[][]{{2, 2}, {3, 3}};
        int res = new RangeAdditionII().maxCount(m, n, ops);
        System.out.println(res);
    }

    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(op[0], m);
            n = Math.min(op[1], n);
        }
        return m * n;
    }
}
