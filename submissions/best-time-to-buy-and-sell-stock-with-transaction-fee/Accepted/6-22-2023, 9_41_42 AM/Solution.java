// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int ownProfit = -prices[0];
        int soldProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            ownProfit = Math.max(soldProfit - prices[i], ownProfit);
            soldProfit = Math.max(soldProfit, ownProfit + prices[i] - fee);
        }
        return soldProfit;
    }
}