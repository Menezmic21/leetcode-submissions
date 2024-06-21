// https://leetcode.com/problems/max-number-of-k-sum-pairs

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n_pairs = 0;
        for (int left = 0, right = nums.length-1; left < right; ) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                n_pairs++;
                left++;
                right--;
            }
        }
        return n_pairs;
    }
}