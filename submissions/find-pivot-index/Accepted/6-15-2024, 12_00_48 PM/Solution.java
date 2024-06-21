// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        int right_sum = 0;
        for (int i = 1; i < nums.length; i++) {
            right_sum += nums[i];
        }

        int left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (right_sum == left_sum) {
                return i;
            }
            left_sum += nums[i];
            if (i+1 < nums.length) right_sum -= nums[i+1];
        }
        return -1;
    }
}