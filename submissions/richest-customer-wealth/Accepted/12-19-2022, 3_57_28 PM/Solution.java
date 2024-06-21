// https://leetcode.com/problems/richest-customer-wealth

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for(int[] customer:accounts){
            int wealth = 0;
            for(int money:customer) wealth += money;
            if(wealth > max) max = wealth;

        }
        return max;
    }
}