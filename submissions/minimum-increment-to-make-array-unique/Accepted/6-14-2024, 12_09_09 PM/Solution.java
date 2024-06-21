// https://leetcode.com/problems/minimum-increment-to-make-array-unique

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        int base = nums[0];
        int bi = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < base + (i - bi)) {
                moves += (base + (i - bi)) - nums[i];
            } else {
                base = nums[i];
                bi = i;
            }
        }
        return moves;
    }
}