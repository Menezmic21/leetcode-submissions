// https://leetcode.com/problems/equal-row-and-column-pairs

class Solution {
    public int equalPairs(int[][] grid) {
        int n_pairs = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boolean all_same = true;
                for (int k = 0; k < grid.length; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        all_same = false;
                        break;
                    }
                }
                if (all_same) {
                    n_pairs++;
                }
            }
        }
        return n_pairs;
    }
}