package com.rick.problems.easy;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int flowerbed[] = {0}, n = 1;
        boolean res = new CanPlaceFlowers().canPlaceFlowers(flowerbed, n);
        System.out.println(res);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n != 0; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed.length == 1 ||
                        (i == 0 && flowerbed[i + 1] == 0) ||
                        (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) ||
                        (i != 0 && i != flowerbed.length - 1 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0)
                ) {
                    n--;
                    i++;
                }
            } else i++;
        }
        return n == 0;
    }

    public boolean canPlaceFlowersBF(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++)
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        return n <= 0;
    }
}