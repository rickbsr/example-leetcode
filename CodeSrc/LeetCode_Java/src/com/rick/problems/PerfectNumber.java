package com.rick.problems;

public class PerfectNumber {

    public static void main(String[] args) {
        int num = 7;
        boolean res = new PerfectNumber().checkPerfectNumber(num);
        System.out.println(res);
    }

    public boolean checkPerfectNumber(int num) {
        if (num < 2) return false;
        int sum = 1;
        for (int i = 2; i <= (int) Math.sqrt(num); i++)
            // 如果是因數的話，將其加起來
            if (num % i == 0) sum = sum + i + num / i;
        return num == sum;
    }
}
