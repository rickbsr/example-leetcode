package com.rick.problems;

public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        int[] seats = {1, 0, 1};
        int res = new MaximizeDistanceToClosestPerson().maxDistToClosest(seats);
        System.out.println(res);
    }

    public int maxDistToClosest(int[] seats) {
        StringBuilder sb = new StringBuilder();
        for (int i : seats) sb.append(i);
        int i = sb.indexOf("1"), j = sb.lastIndexOf("1"), max = Math.max(i, sb.length() - j - 1), count = 0;
        if (i == j) return Math.max(i, sb.length() - i - 1);
        for (char c : sb.toString().substring(i, j + 1).toCharArray())
            if (c == '0') count++;
            else {
                max = Math.max(max, (count + 1) / 2);
                count = 0;
            }
        return max != 0 ? max : 1;
    }
}
