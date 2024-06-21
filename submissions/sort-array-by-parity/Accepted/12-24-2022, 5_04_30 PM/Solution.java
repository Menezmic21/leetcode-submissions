// https://leetcode.com/problems/sort-array-by-parity

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[left] % 2 == 1) {
                //swap
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }
}