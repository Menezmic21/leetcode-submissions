// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // Copy nums to res and store prefixes in nums
        int val = 1;
        int temp;
        int i = 0;
        for (; i < nums.length; i++) {
            res[i] = nums[i];

            temp = nums[i];
            nums[i] = val;
            val *= temp;
        }

        // Store suffixes in res;
        val = 1;
        for (--i; i >= 0; i--) {
            temp = res[i];
            res[i] = val;
            val *= temp;
        }

        // Multiply prefix and suffix to get answer
        for (++i; i < nums.length; i++) {
            res[i] *= nums[i];
        }

        return res;
    }
}