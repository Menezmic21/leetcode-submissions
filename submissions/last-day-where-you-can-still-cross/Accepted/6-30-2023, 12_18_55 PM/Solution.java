// https://leetcode.com/problems/last-day-where-you-can-still-cross

class Solution {
    public int latestDayToCross(int height, int width, int[][] cells) {
        int left = 0;
        int right = cells.length;
        int mid = getAvg(left, right);
        // System.out.println("" + left + ", " + right);
        while(true) {
            // System.out.println(mid);
            HashSet<String> fTiles = new HashSet<String>();
            for(int i = 0; i <= mid; i++) fTiles.add(Arrays.toString(cells[i]));
            // fTiles.forEach(System.out::print);
            // System.out.println();
            if(hasPath(height, width, fTiles)) left = mid;
            else right = mid;
            if(mid == getAvg(left, right)) return mid;
            mid = getAvg(left, right);
        }
    }
    public int getAvg(int a, int b) {
        return (a + b + 1) / 2;
    }
    public boolean hasPath(int height, int width, HashSet<String> fTiles) {
        HashMap<String, Boolean> mem = new HashMap<String, Boolean>();
        // fTiles.forEach(System.out::print);
        // System.out.println();
        for(int i = 0; i < width; i++) {
            if(dfs(height, width, fTiles, 0, i, mem)) return true;
            // System.out.println();
        }
        return false;
    }
    public boolean dfs(int height, int width, HashSet<String> fTiles, 
                        int row, int col, HashMap<String, Boolean> mem) {

        String hash = numsToStrArr(row+1, col+1);
        // System.out.println(hash);
        if(row < 0  || col < 0 || col >= width || fTiles.contains(hash)) return false;
        if(mem.get(hash) != null) return mem.get(hash);
        if(row == height-1) return true;
        mem.put(hash, false);
        Boolean rVal = dfs(height, width, fTiles, row+1, col, mem) || 
                       dfs(height, width, fTiles, row, col+1, mem) || 
                       dfs(height, width, fTiles, row, col-1, mem) || 
                       dfs(height, width, fTiles, row-1, col, mem);
        mem.put(hash, rVal);
        return rVal;
    }
    public String numsToStrArr(int row, int col) {
        int[] arr = {row, col};
        return Arrays.toString(arr);
    }
}