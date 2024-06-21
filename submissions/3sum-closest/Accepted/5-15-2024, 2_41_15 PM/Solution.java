// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 100000;
        int argmin = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int left = i+1, right = nums.length-1; left < right; ) {
                int sum = nums[i] + nums[left] + nums[right];
                int dist = Math.abs(target - sum);
                if (dist < min) {
                    min = dist;
                    argmin = sum;
                } 
                if (sum < target) { // sum is smaller than target
                    left++;
                } else if (sum > target) {
                    right--;
                } else { // sum is target
                    return target;
                }
            }
        }
        return argmin;
    }
}