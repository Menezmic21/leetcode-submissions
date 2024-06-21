// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];

            int temp = nums[i];
            nums[i] = pre;
            pre *= temp;
        }

        int suf = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            int temp = res[i];
            res[i] = suf;
            suf *= temp;
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] *= nums[i];
        }

        return res;
    }
}