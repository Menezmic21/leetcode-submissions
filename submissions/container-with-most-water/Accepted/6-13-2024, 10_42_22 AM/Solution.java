// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        for (int left = 0, right = height.length-1; left < right; ) {
            max_area = Math.max(max_area, Math.min(height[left], height[right]) * (right - left));
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max_area;
    }
}