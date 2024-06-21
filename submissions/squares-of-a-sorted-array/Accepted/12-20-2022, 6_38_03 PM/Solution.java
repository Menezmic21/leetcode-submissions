// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int lPointer = 0;
        int rPointer = n-1;
        int[] rArr = new int[n];
        for(int i = 0; i < n; i++){
            int left = nums[lPointer];
            int right = nums[rPointer];
            if(Math.abs(left) > right){
                rArr[n-i-1] = left * left;
                lPointer++;
            }
            else{
                rArr[n-i-1] = right * right;
                rPointer--;
            }
        }
        return rArr;
    }
}