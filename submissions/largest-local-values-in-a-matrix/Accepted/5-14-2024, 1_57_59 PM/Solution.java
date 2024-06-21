// https://leetcode.com/problems/largest-local-values-in-a-matrix

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid.length-2];
        for (int i = 0; i < grid.length-2; i++) {
            for (int j = 0; j < grid.length-2; j++) {
                ans[i][j] = maxInBlock(grid, i, j);
            }
        }
        return ans;
    }
    public int maxInBlock(int[][] grid, int i, int j) {
        int max = 0;
        for (int x = i; x < i+3; x++) {
            for (int y = j; y < j+3; y++) {
                max = Math.max(max, grid[x][y]);
            }
        }
        return max;
    }
}