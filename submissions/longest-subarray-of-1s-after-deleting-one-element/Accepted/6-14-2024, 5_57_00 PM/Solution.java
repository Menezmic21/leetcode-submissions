// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

class Solution {
    public int longestSubarray(int[] nums) {
        return Math.max(longestOnes(nums, 1) - 1, 0);
    }
    private int longestOnes(int[] nums, int k) {
        k++;
        int right = 0;
        for ( ; k > 0 && right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
        }
        int max = right;
        // System.out.println(max);
        for (int left = 0; right < nums.length; left++, right++) {
            while (right < nums.length && nums[right] != 0) {
                right++;
            }
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            max = Math.max(max, right - left);
            // System.out.println("" + left + ", " + right + ": " + (right - left));
        }
        return k == 0 ? max - 1 : max;
    }
}