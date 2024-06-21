// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        for(int i = arr.length - 1; i >= 0; i--) {
            int newMax = max;
            if(newMax < arr[i]) {
                newMax = arr[i];
            }
            arr[i] = max;
            max = newMax;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}