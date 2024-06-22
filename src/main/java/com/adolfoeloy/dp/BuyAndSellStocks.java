package com.adolfoeloy.dp;

public class BuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i=0; i<prices.length; i++) {
            int p = prices[i];
            if (p < minPrice) minPrice = p;
            else if (p - minPrice > profit) profit = p - minPrice;
        }
        return profit;
    }
}
