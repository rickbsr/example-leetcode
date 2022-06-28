package com.rick.problems;

public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        boolean res = new LemonadeChange().lemonadeChange(bills);
        System.out.println(res);
    }

    public boolean lemonadeChange(int[] bills) {
        for (int i = 0, ints[] = new int[2]; i < bills.length; i++) {
            if (bills[i] == 5) ints[0]++;
            else if (bills[i] == 10) {
                ints[0]--;
                ints[1]++;
            } else if (bills[i] == 20 && ints[1] > 0) {
                ints[1]--;
                ints[0]--;
            } else ints[0] -= 3;
            if (ints[0] < 0) return false;
        }
        return true;
    }
}
