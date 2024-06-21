// https://leetcode.com/problems/running-sum-of-1d-array

class Solution {
    public int[] runningSum(int[] nums) {
        int[] rArr = new int[nums.length];
        rArr[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            rArr[i] = rArr[i-1] + nums[i];
        }
        return rArr;
    }
}