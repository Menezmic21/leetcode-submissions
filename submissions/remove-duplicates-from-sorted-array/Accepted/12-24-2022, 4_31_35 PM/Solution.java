// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int numRmvd = 0;
        for(int i = 0; i + numRmvd < size; i++) {
            numRmvd += removeFollowingElements(nums, i+1, size - numRmvd, nums[i]);
        }
        return size - numRmvd;
    }
    public int removeFollowingElements(int[] nums, int start, int stop, int val) {
        int size = nums.length;
        int numRmvd = 0;
        for(int i = start; i + numRmvd < stop; i++) {
            while((i + numRmvd) <= stop - 1 && nums[i + numRmvd] == val) {
                numRmvd++;
            }
            nums[i] = nums[Math.min(i + numRmvd, stop - 1)];
        }
        return numRmvd;
    }
}