package com.rick.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 3, res;
        res = new CountPrimesBruteForce().countPrimes(n);
        res = new CountPrimesSieveOfEratosthenes().countPrimes(n);
        System.out.println(res);
    }
}

/**
 * 方式一、暴力演算法
 */
class CountPrimesBruteForce {
    public int countPrimes(int n) {
        int res = 0;
        if (n < 3) return res;
        for (int i = 3; i < n; i += 2) // 從 3 開始, 一次加 2
            if (isPrime(i)) res++;
        return res + 1; // 因為 2 也為質數，故須加 1
    }

    public boolean isPrime(int i) {
        for (int j = 2; j < i; j++)
            if (i % j == 0) return false;
        return true;
    }
}

/**
 * 方式二、埃拉托斯特尼篩法
 */
class CountPrimesSieveOfEratosthenes {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        Set<Integer> notPrimesSet = new HashSet<>();
        for (int i = 3; i * i < n; i += 2)
            if (!notPrimesSet.contains(i))
                for (int j = i * i; j < n; j += i * 2) notPrimesSet.add(j);
        return n / 2 - notPrimesSet.size();
    }
}