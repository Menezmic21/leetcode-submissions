// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid

class Solution {
    public int countPaths(int[][] grid) {
        int paths = 0;
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                paths = (paths + dfs(i, j, grid, memo)) % ((int) 1e9 + 7);
            }
        }
        return paths;
    }

    public int dfs(int i, int j, int[][] grid, HashMap<Integer, Integer> memo) {

        if(memo.getOrDefault(coordToNum(i, j, grid), null) != null) {
            return memo.get(coordToNum(i, j, grid));
        }

        int[] coord = {i, j};
        int[] north = {coord[0] - 1, coord[1]};
        int[] east = {coord[0], coord[1] - 1};
        int[] south = {coord[0] + 1, coord[1]};
        int[] west = {coord[0], coord[1] + 1};

        int paths = 1;
        
        if(isValidCoord(north, grid) && grid[coord[0]][coord[1]] < grid[north[0]][north[1]]) {
            paths = (paths + dfs(north[0], north[1], grid, memo)) % ((int) 1e9 + 7);
        }
        if(isValidCoord(east, grid) && grid[coord[0]][coord[1]] < grid[east[0]][east[1]]) {
            paths = (paths + dfs(east[0], east[1], grid, memo)) % ((int) 1e9 + 7);
        }
        if(isValidCoord(south, grid) && grid[coord[0]][coord[1]] < grid[south[0]][south[1]]) {
            paths = (paths + dfs(south[0], south[1], grid, memo)) % ((int) 1e9 + 7);
        }
        if(isValidCoord(west, grid) && grid[coord[0]][coord[1]] < grid[west[0]][west[1]]) {
            paths = (paths + dfs(west[0], west[1], grid, memo)) % ((int) 1e9 + 7);
        }

        memo.put(coordToNum(i, j, grid), paths);
        return paths;
    }

    public int coordToNum(int i, int j, int[][] grid) {
        return j + i * grid[0].length;
    }

    public int[] numToCoord(int v, int[][] grid) {
        int[] coord = {(int) v / grid[0].length, v % grid[0].length};
        return coord;
    }

    public boolean isValidCoord(int[] coord, int[][] grid) {
        int gridWidth = grid[0].length - 1;
        int gridHeight = grid.length - 1;
        if(coord[0] < 0 || coord[0] > gridHeight) {
            return false;
        }
        if(coord[1] < 0 || coord[1] > gridWidth) {
            return false;
        }
        return true;
    }
}