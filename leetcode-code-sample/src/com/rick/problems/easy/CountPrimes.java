package com.rick.problems.easy;

import java.lang.reflect.Array;
import java.util.*;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 1000000;
        int res = new CountPrimesMulSkipEven().countPrimes(n);
        System.out.println(res);

//        System.out.println(new Solution().countPrimes(n));
    }

    public int countPrimesMul(int n) {
        if (n < 3) return 0;
        boolean[] notPrime = new boolean[n];
        int count = n / 2;
        for (int i = 2; i * i < n; i += 2) {
            if (notPrime[i]) continue;
            for (int j = i * i; j < n; j += i * 2)
                if (!notPrime[j]) {
                    count--;
                    notPrime[j] = true;
                }
        }
        return count;
    }
}

class CountPrimesMul {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++)
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) notPrime[i * j] = true;
            }
        return count;
    }
}

class CountPrimesMulSkipEven {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        Set<Integer> notPrimes = new HashSet<>(n);
        for (int i = 3; i * i < n; i += 2)
            if (!notPrimes.contains(i))
                for (int j = i * i; j < n; j += i * 2) notPrimes.add(j);
        return n / 2 - notPrimes.size();
    }
}

class CountPrimesMulSkipEvenSet {
    public int countPrimes(int n) {
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
}
