// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        for(; low <= high;) {
            int mid = high - ((high - low) / 2);
            if(nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        // System.out.println("low: " + low);
        // System.out.println("high: " + high);
        return low;
    }
}