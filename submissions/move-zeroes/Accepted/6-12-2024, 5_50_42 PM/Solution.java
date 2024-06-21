// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
            } else {
                nums[left] = nums[right];
                left++;
            }
        }
        for ( ; left < nums.length; left++) {
            nums[left] = 0;
        }
    }
}