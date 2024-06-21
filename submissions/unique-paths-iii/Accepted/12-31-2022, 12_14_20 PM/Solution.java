// https://leetcode.com/problems/unique-paths-iii

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int row =  0;
        int column = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    row = i;
                    column = j;
                } else if(grid[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
        return dfs(row, column, grid, visited);
    }
    public int dfs(int row, int column, int[][] grid, boolean[][] visited) {
        if(!inBounds(row, 0, grid.length)) return 0;
        if(!inBounds(column, 0, grid[0].length)) return 0;

        if(grid[row][column] == -1) return 0;
        if(visited[row][column]) return 0;
        if(grid[row][column] == 2 && allVisited(row, column, visited)) return 1;

        boolean[][] visitedCopy = new boolean[visited.length][visited[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                visitedCopy[i][j] = visited[i][j];
            }
        }

        visitedCopy[row][column] = true;

        int north = dfs(row - 1, column, grid, visitedCopy);
        int east = dfs(row, column + 1, grid, visitedCopy);
        int south = dfs(row + 1, column, grid, visitedCopy);
        int west = dfs(row, column - 1, grid, visitedCopy);
        return north + east + south + west;
    }
    public boolean inBounds(int val, int min, int max) {
        return min <= val && val < max;
    }
    public boolean allVisited(int row, int column, boolean[][] visited) {
        boolean isAllVisited = true;
        exit: for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                if(i != row || j != column) {
                    if(!visited[i][j]) {
                        isAllVisited = false;
                        break exit;
                    }
                }
            }
        }
        return isAllVisited;
    }
}