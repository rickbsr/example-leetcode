package com.rick.problems.easy;

import java.util.BitSet;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 5;
        int res = new CountPrimes().countPrimes(n);
        System.out.println(res);
    }

    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n]; // 紀錄表
        for (int i = 2; i < n; i++) // 從 2 至 n 遍訪
            if (!notPrime[i]) { // 查詢對照表
                count++;
                for (int j = 2; i * j < n; j++) notPrime[i * j] = true;
            }
        return count;
    }

    public int countPrimesByOptimizedStandard(int n) {
        if (n < 3) return 0;
        boolean[] notPrime = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (notPrime[i]) continue;
            for (int j = i * i; j < n; j += i * 2)
                if (!notPrime[j]) {
                    count--;
                    notPrime[j] = true;
                }
        }
        return count;
    }

    public int countPrimesByBigSet(int n) {
        int count = 0;
        BitSet primes = new BitSet(n);
        for (int i = 2; i < n; i++)
            if (!primes.get(i)) {
                count++;
                for (int j = i + i; j < n; j += i) primes.set(j);
            }
        return count;
    }
}
