// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] DP = new int[n];
        DP[0] = 1;
        for(int i = 1; i < n; i++) {
            DP[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    DP[i] = Math.max(DP[i], 1 + DP[j]);
                }
            }
        }
        int lis = 0;
        for(int i = 0; i < n; i++) {
            // System.out.println(DP[i]);
            lis = Math.max(lis, DP[i]);
        }
        return lis;
    }
}