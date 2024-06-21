// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums.length > 0) {
            res[0] = binarySearchA(nums, target);
            res[1] = binarySearchB(nums, target);
        }
        return res;
    }
    private int binarySearchA(int[] nums, int target) {
        int idx = -1;
        int left = 0, right = nums.length-1;
        for ( ; left <= right; ) {
            int mid = (left + right) / 2;
            int val = nums[mid];
            if (val < target) { // val is smaller, move right
                left = mid + 1;
            } else if (val > target) {
                right = mid - 1;
            } else { // val is target
                right = mid - 1;
                idx = mid;
            }
        }
        return idx;
    }
    private int binarySearchB(int[] nums, int target) {
        int idx = -1;
        int left = 0, right = nums.length-1;
        for ( ; left <= right; ) {
            int mid = (left + right) / 2;
            int val = nums[mid];
            if (val < target) { // val is smaller, move right
                left = mid + 1;
            } else if (val > target) {
                right = mid - 1;
            } else { // val is target
                left = mid + 1;
                idx = mid;
            }
        }
        return idx;
    }
}