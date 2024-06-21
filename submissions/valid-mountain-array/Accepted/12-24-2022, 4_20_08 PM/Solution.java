// https://leetcode.com/problems/valid-mountain-array

class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int i = 0;
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        while(i+1 < arr.length && arr[i] < arr[i+1]) {
            i++;
            isIncreasing = true;
        }
        while(i+1 < arr.length && arr[i] > arr[i+1]) {
            i++;
            isDecreasing = true;
        }
        return isIncreasing && isDecreasing && i == arr.length - 1;
    }
}