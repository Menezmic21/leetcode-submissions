// https://leetcode.com/problems/path-with-maximum-gold

class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                max = Math.max(max, getGold(grid, row, col));
            }
        }
        return max;
    }
    private int getGold(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) {
            return 0;
        }
        if (col < 0 || col >= grid[0].length) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 0;
        }
        int amt = grid[row][col];
        grid[row][col] = 0;
        int max = 0;
        max = Math.max(max, getGold(grid, row+1, col));
        max = Math.max(max, getGold(grid, row-1, col));
        max = Math.max(max, getGold(grid, row, col+1));
        max = Math.max(max, getGold(grid, row, col-1));
        grid[row][col] = amt;
        return amt + max;
    }
}