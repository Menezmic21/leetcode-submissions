// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int max_area = -1;
        for(int left = 0, right = height.length-1; left < right;) {
            int area = Math.min(height[left], height[right]);
            area *= right - left;
            max_area = Math.max(max_area, area);
            if(height[left] < height[right]) left++;
            else right--; 
        }
        return max_area;
    }
}