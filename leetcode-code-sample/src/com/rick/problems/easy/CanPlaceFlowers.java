package com.rick.problems.easy;

import java.util.Arrays;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int flowerbed[] = {1, 0, 0, 0, 1}, n = 1;
        boolean res;
        res = new CanPlaceFlowersBruteForce().canPlaceFlowers(flowerbed, n);
        res = new CanPlaceFlowers3Empty().canPlaceFlowers(flowerbed, n);
        res = new CanPlaceFlowers3EmptyAdd1().canPlaceFlowers(flowerbed, n);
        System.out.println(res);
    }
}

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

class CanPlaceFlowers3Empty {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int idx = 0, flag = 1; // 起點
        do {
            if (flowerbed[idx] == 1) { // 代表空格有花
                idx++;
                flag = 1;
            } else if (++flag == 3) { // 代表空格無花且已經累積連續三塊空地
                n--; // 種花
                flag = 1;
            }
        } while (++idx < flowerbed.length && n != 0);
        // 末端
        if (n == 1 && flowerbed[flowerbed.length - 1] == 0 && flag > 1) return true;
        return n == 0;
    }
}

class CanPlaceFlowers3EmptyAdd1 {
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