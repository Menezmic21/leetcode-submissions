// https://leetcode.com/problems/height-checker

class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        qs(0, heights.length-1, expected);
        // for(int i = 0; i < heights.length; i++) {
        //     System.out.print(expected[i] + " ");
        // }
        int cnt = 0;
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != expected[i]) cnt++;
        }
        return cnt;
    }
    public void qs(int left, int right, int[] array) {
        //pivot = start value
        if(left == right) return;
        int pivot = array[right];
        int i = left;
        for(int j = left; j < right; j++) {
            if(array[j] < pivot) {
                //swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        //swap
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;
        // for(int k = 0; k < array.length; k++) {
        //     System.out.print(array[k] + " ");
        // }
        // System.out.println();
        qs(left, Math.max(left, i-1), array);
        qs(Math.min(i+1, right), right, array);
    }
}