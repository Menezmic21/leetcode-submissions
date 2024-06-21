// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        if(target == nums[nums.length-1]) return nums.length-1;
        if(target == nums[0]) return 0;

        int pivot = getPivot(nums);
        // System.out.println(pivot);

        if(target < nums[nums.length-1]) { // target in second chunk
            for(int low = pivot, high = nums.length-1; low <= high;) {
                int mid = mean(low, high);
                if(nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        } else { //target in first chunk
            for(int low = 0, high = pivot-1; low <= high;) {
                int mid = mean(low, high);
                if(nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
    public int mean(int a, int b) {
        return (int) ((a + b) / 2);
    }
    public int getPivot(int[] nums) {
        if(nums[nums.length-1] >= nums[0]) return 0;
        for(int low = 0, high = nums.length-1; low <= high;) {
            int mid = mean(low, high);
            if(nums[mid] > nums[mid+1]) {
                return mid+1;
            } else if(nums[mid] < nums[nums.length-1]) { // in chunk 2
                high = mid-1;
            } else { // in chunk 1
                low = mid+1;
            }
        }
        return -1;
    }
}