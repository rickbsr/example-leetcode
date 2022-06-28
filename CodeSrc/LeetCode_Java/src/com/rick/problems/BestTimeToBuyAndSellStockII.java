package com.rick.problems;

public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = new BestTimeToBuyAndSellStockII().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            profit += Math.max(prices[i] - prices[i - 1], 0);
        return profit;
    }
}
