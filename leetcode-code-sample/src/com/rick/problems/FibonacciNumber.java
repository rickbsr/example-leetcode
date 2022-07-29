package com.rick.problems;

public class FibonacciNumber {

    public static void main(String[] args) {
        int N = 10;
        int res = new FibonacciNumber().fib(N);
        System.out.println(res);
    }

    public int fib(int N) {
        if (N <= 1) return N;

        // 用來裝 f(N - 1) 與 f(N - 2)
        int[] f = new int[]{0, 1};

        // f(N)
        int sum = 0;

        for (int i = 2; i <= N; i++) {

            // f(N) =  f(N - 1) + f(N - 2)
            sum = f[0] + f[1];

            // 用 f(N) 取代 f(N - 2)
            f[i % 2] = sum;
        }
        return sum;
    }
}
