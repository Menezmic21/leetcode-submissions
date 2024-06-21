// https://leetcode.com/problems/maximum-average-subarray-i

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double average = 0;
        for (int i = 0; i < k; i++) {
            average += nums[i] / (double) k;
        }
        double max = average;
        for (int i = k; i < nums.length; i++) {
            average -= nums[i-k] / (double) k;
            average += nums[i] / (double) k;
            max = Math.max(max, average);
        }
        return max;
    }
}