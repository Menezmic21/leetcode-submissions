// https://leetcode.com/problems/height-checker

class Solution {
    public int heightChecker(int[] heights) {
        List<Integer> sHeights = new ArrayList<Integer>(heights.length);
        for (int height : heights) {
            sHeights.add(height);
        }
        Arrays.sort(heights);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sHeights.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}