// https://leetcode.com/problems/longest-arithmetic-subsequence

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        // HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>();
        ArrayList<Integer> seen = new ArrayList<Integer>();
        for(int i = 0; i < nums.length-1; i++) {
            if(!seen.contains(nums[i])) {
                seen.add(nums[i]);
                for(int j = i+1; j < nums.length; j++) {
                    int m = nums[j] - nums[i];
                    max = Math.max(max, getCoincident(nums, nums[i], nums[j] - nums[i]));
                }
            }
        }
        return max;
    }

    public int getCoincident(int[] nums, int num1, int m) {
        int cnt = 0;
        for(int num:nums) {
            if(num == num1 + m * cnt) cnt++;
            
        }
        return cnt;
    }
}