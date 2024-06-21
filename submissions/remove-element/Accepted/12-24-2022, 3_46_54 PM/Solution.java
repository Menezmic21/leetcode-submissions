// https://leetcode.com/problems/remove-element

class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        int numRmvd = 0;
        for(int i = 0; i + numRmvd < size; i++) {
            while((i + numRmvd) <= size - 1 && nums[i + numRmvd] == val) {
                numRmvd++;
            }
            nums[i] = nums[Math.min(i + numRmvd, size - 1)];
        }
        return size - numRmvd;
    }
}