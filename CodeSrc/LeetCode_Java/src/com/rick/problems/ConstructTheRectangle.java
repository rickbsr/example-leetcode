package com.rick.problems;

public class ConstructTheRectangle {

    public static void main(String[] args) {
        int area = 4;
        int[] res = new ConstructTheRectangle().constructRectangle(area);
        System.out.println(res);
    }

    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        while (area % width != 0) width--;
        return new int[]{area / width, width};
    }
}
