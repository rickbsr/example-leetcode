package com.rick.problems.easy;

import java.lang.reflect.Array;
import java.util.*;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 3, res;
        res = new CountPrimesBruteForce().countPrimes(n);
        res = new CountPrimesBruteForceOdd().countPrimes(n);
        res = new CountPrimesSieveOfEratosthenes().countPrimes(n);
        res = new CountPrimesSieveOfEratosthenesSet().countPrimes(n);
        System.out.println(res);

        System.out.println(new CountPrimesBruteForce().countPrimes(n));
        System.out.println(new CountPrimesBruteForceOdd().countPrimes(n));
    }
}

class CountPrimesBruteForce {
    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i < n; i++)
            if (isPrime(i)) res++;
        return res;
    }

    private boolean isPrime(int i) {
        for (int j = 2; j < i; j++)
            if (i % j == 0) return false;
        return true;
    }
}

class CountPrimesBruteForceOdd {
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

class CountPrimesSieveOfEratosthenes {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] notPrime = new boolean[n];
        int res = n / 2;
        for (int i = 3; i * i < n; i += 2)
            if (!notPrime[i])
                for (int j = i * i; j < n; j += i * 2)
                    if (!notPrime[j]) {
                        notPrime[j] = true;
                        res--;
                    }
        return res;
    }
}

class CountPrimesSieveOfEratosthenesSet {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        Set<Integer> notPrimesSet = new HashSet<>();
        for (int i = 3; i * i < n; i += 2)
            if (!notPrimesSet.contains(i))
                for (int j = i * i; j < n; j += i * 2) notPrimesSet.add(j);

        System.out.println(notPrimesSet);
        return n / 2 - notPrimesSet.size();
    }
}