// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int high = matrix.length-1;
        int low = 0;
        int mid = mean(high, low);
        if(target > matrix[matrix.length-1][matrix[matrix.length-1].length-1] 
            || target < matrix[0][0]) return false;

        int prev = mid;
        while((mid < 0 ? Integer.MIN_VALUE : matrix[mid][0]) > target 
            || target > (mid+1 >= matrix.length ? Integer.MAX_VALUE : matrix[mid+1][0])) {
            
            if((mid < 0 ? Integer.MIN_VALUE : matrix[mid][0]) > target) {
                high = mid;
            } else {
                low = mid;
            }
            mid = mean(high, low);
            if(mid == prev) break;
            else prev = mid;
            // System.out.println("low: " + low);
            // System.out.println("mid: " + mid);
            // System.out.println("high: " + high);
            // System.out.println();
        }

        if(mid+1 < matrix.length ? matrix[mid+1][0] <= target : false) mid++;

        System.out.println("row: " + mid);

        int row = mid;
        high = matrix[row].length-1;
        low = 0;
        mid = mean(high, low);

        prev = mid;
        while((mid < 0 ? Integer.MIN_VALUE : matrix[row][mid]) > target 
            || target > (mid+1 >= matrix[row].length ? Integer.MAX_VALUE : matrix[row][mid+1])) {
            
            if((mid < 0 ? Integer.MIN_VALUE : matrix[row][mid]) > target) {
                high = mid;
            } else {
                low = mid;
            }
            mid = mean(high, low);
            if(mid == prev) break;
            else prev = mid;
            // System.out.println("low: " + low);
            // System.out.println("mid: " + mid);
            // System.out.println("high: " + high);
            // System.out.println();
        }
        if(matrix[row][mid] != target) mid++;

        // System.out.println("row: " + row);
        // System.out.println("col: " + mid);

        return mid < matrix[row].length ? matrix[row][mid] == target : false;
    }
    public int mean(int a, int b) {
        return (int) ((a + b) / 2);
    }
}