package com.rick.problems;

import java.util.Arrays;

public class Heaters {

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4}, heaters = {1, 4};
        int res = new Heaters().findRadius(houses, heaters);
        System.out.println(res);
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 &&
                    heaters[i] + heaters[i + 1] <= house * 2) i++;
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }
}
