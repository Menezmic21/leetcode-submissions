// https://leetcode.com/problems/maximum-ice-cream-bars

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int bars = 0;
        while(bars < costs.length && coins > 0) {
            coins -= costs[bars];
            if(coins >= 0) bars++;
        }
        return bars;
    }
}