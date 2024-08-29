package com.rick.problems.easy;

import java.util.Arrays;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        boolean res;
        res = new CanPlaceFlowersBruteForce().canPlaceFlowers(flowerbed, n);
        res = new CanPlaceFlowers3Empty().canPlaceFlowers(flowerbed, n);
        System.out.println(res);
    }
}

/**
 * 方式一、暴力演算法
 */
class CanPlaceFlowersBruteForce {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n != 0; i++)
            if (flowerbed[i] == 0 && // 代表當前格為空
                    (i == 0 || flowerbed[i - 1] == 0) && // 第一格 or 前一格
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) { // 最後一格 or 後一格
                flowerbed[i++] = 1;
                n--;
            } else if (flowerbed[i] == 1) i++;
        return n == 0;
    }
}

/**
 * 方式二、連續空地計算法
 */
class CanPlaceFlowers3Empty {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] newFlowerbed = Arrays.copyOf(flowerbed, flowerbed.length + 1);

        for (int i = 0, flag = 1; i < newFlowerbed.length && n != 0; i++) {
            if (newFlowerbed[i] == 1) i++;
            else if (++flag == 3) n--;
            else continue;
            flag = 1;
        }
        return n == 0;
    }
}