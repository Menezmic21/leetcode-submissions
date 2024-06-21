// https://leetcode.com/problems/equal-row-and-column-pairs

class Solution {
    public String arrToStr(int[] arr) {
        String rStr = "";

        for(int i : arr) {
            rStr += String.valueOf(i) + ",";
        }

        return rStr;
    }

    public int equalPairs(int[][] grid) {
        // 12:42
        HashMap<String, Integer> colFreq = new HashMap<String, Integer>();
        HashMap<String, Integer> rowFreq = new HashMap<String, Integer>();

        for(int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
            String key = arrToStr(grid[rowIdx]);
            rowFreq.put(key, rowFreq.getOrDefault(key, 0) + 1);
        }
        
        for(int colIdx = 0; colIdx < grid.length; colIdx++) {
            int[] col = new int[grid.length];
            for(int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
                col[rowIdx] = grid[rowIdx][colIdx];
            }
            String key = arrToStr(col);
            colFreq.put(key, colFreq.getOrDefault(key, 0) + 1);
        }

        // for(String key : colFreq.keySet()) {
        //     System.out.println(key);
        // }

        // System.out.println();

        // for(String key : rowFreq.keySet()) {
        //     System.out.println(key);
        // }

        int pairs = 0;
        for(String key : colFreq.keySet()) {
            pairs += colFreq.get(key) * rowFreq.getOrDefault(key, 0);
        }

        return pairs;
    }
}