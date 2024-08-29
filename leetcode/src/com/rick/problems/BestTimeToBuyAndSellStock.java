package com.rick.problems;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        int res = new BestTimeToBuyAndSellStock().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else if (prices[i] > min) max = Math.max(prices[i] - min, max);
        }
        return max;
    }
}
