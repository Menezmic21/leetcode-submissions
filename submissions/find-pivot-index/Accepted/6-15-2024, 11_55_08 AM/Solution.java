// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        int[] suffixes = new int[nums.length];
        for (int i = nums.length-2; i >= 0; i--) {
            suffixes[i] += nums[i+1] + suffixes[i+1];
        }
        if (suffixes[0] == 0) {
            return 0;
        }

        int prefix = 0;
        for (int i = 1; i < nums.length; i++) {
            prefix += nums[i-1];
            if (prefix == suffixes[i]) {
                return i;
            }
        }
        return -1;
    }
}