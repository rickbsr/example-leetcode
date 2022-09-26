package com.rick.problems;

public class TeemoAttacking {

    public static void main(String[] args) {
        int timeSeries[] = {1, 4}, duration = 2;
        int res = new TeemoAttacking().findPoisonedDuration(timeSeries, duration);
        System.out.println(res);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int total = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int interval = timeSeries[i] - timeSeries[i - 1];
            total += interval < duration ? interval : duration;
        }
        return total + duration;
    }
}
