// https://leetcode.com/problems/score-after-flipping-matrix

class Solution {
    public int matrixScore(int[][] grid) {
        // System.out.println("Z");
        // printGrid(grid);
        // Ensure first bit of row is 1
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][0] == 0) {
                flipRow(grid, row);
            }
        }
        // System.out.println("A");
        // printGrid(grid);

        // Maximize columns
        for (int col = 0; col < grid[0].length; col++) {
            if (getNumOnesInCol(grid, col) <= (int) (grid.length / 2)) {
                flipCol(grid, col);
            }
        }
        // System.out.println("B");
        // printGrid(grid);
        return gridScore(grid);
    }
    private int getNumOnesInCol(int[][] grid, int col) {
        int sum = 0;
        for (int row = 0; row < grid.length; row++) {
            sum += grid[row][col];
        }
        return sum;
    }
    private int rowScore(int[][] grid, int row) {
        int score = 0;
        for (int i = grid[row].length-1, pow = 0; i >= 0; i--) {
            if (grid[row][i] == 1) {
                score += Math.pow(2, pow);
            }
            pow++;
        }
        return score;
    }
    private int gridScore(int[][] grid) {
        int score = 0;
        for (int row = 0; row < grid.length; row++) {
            score += rowScore(grid, row);
        }
        return score;
    }
    private void flipCol(int[][] grid, int col) {
        for (int row = 0; row < grid.length; row++) {
            grid[row][col] = 1 - grid[row][col];
        }
    }
    private void flipRow(int[][] grid, int row) {
        for (int col = 0; col < grid[row].length; col++) {
            grid[row][col] = 1 - grid[row][col];
        }
    }
    private void printGrid(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}