// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative

class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for (int left = 0, right = nums.length-1; left < right; ) {
            int lv = Math.abs(nums[left]);
            int rv = Math.abs(nums[right]);
            if (lv > rv) { // left bigger
                left++;
            } else if (rv > lv) { // right bigger
                right--;
            } else { // same size
                return nums[left] == nums[right] ? -1 : nums[right];
            }
        }
        return -1;
    }
}