// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

class Solution {
    public int maxProfit(int[] prices) {
       int[][] memory = new int[prices.length][2];
       boolean[][] computed = new boolean[prices.length][2];
        return optimize(0, false, prices, memory, computed);
    }

    public int optimize(int day, boolean isOwned, int[] prices, int[][] memory, boolean[][] computed) {
        if(day >= prices.length) return 0;
        int state = isOwned ? 0 : 1;
        if(computed[day][state]) return memory[day][state];
        int profit = 0;
        if(!isOwned) {
            //buy or nothing1
            profit = Math.max(-prices[day] + optimize(day+1, true, prices, memory, computed), optimize(day+1, false, prices, memory, computed));
        } else {
            //sell or nothing 2
            profit = Math.max(prices[day] + optimize(day+2, false, prices, memory, computed), optimize(day+1, true, prices, memory, computed));
        }
        computed[day][state] = true;
        memory[day][state] = profit;
        return profit;
    }
}