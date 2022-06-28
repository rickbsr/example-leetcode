package com.rick.problems;

public class LargestTriangleArea {

    public static void main(String[] args) {
        int[][] points = {{-35, 19}, {40, 19}, {35, -3}, {44, 20}, {22, -21}, {35, 33}, {-19, 42}, {11, 47}, {11, 37}};
        double res = new LargestTriangleArea().largestTriangleArea(points);
        System.out.println(res);
    }

    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int[] i : points)
            for (int[] j : points)
                for (int[] k : points)
                    res = Math.max(res, clacTriangleArea(i, j, k));
        return res;
    }

    private double clacTriangleArea(int[] i, int[] j, int[] k) {
        double sideIJ = Math.sqrt(Math.pow(i[0] - j[0], 2) + Math.pow(i[1] - j[1], 2)),
                sideJK = Math.sqrt(Math.pow(j[0] - k[0], 2) + Math.pow(j[1] - k[1], 2)),
                sideIK = Math.sqrt(Math.pow(i[0] - k[0], 2) + Math.pow(i[1] - k[1], 2)),
                s = (sideIJ + sideJK + sideIK) / 2;
        return Math.sqrt((s * Math.abs(s - sideIJ) * Math.abs(s - sideJK) * Math.abs(s - sideIK)));
    }
}