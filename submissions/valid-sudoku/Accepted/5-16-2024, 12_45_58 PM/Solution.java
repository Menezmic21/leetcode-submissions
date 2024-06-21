// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
            if (!isValidCol(board, i)) {
                return false;
            }
            if (!isValidBlock(board, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean isValidRow(char[][] board, int i) {
        HashSet<Integer> nums = new HashSet<Integer>(9);
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') continue;
            int val = Integer.valueOf(board[i][j]);
            if (nums.contains(val)) return false;
            nums.add(val);
        }
        return true;
    }
    private boolean isValidCol(char[][] board, int j) {
        HashSet<Integer> nums = new HashSet<Integer>(9);
        for (int i = 0; i < 9; i++) {
            if (board[i][j] == '.') continue;
            int val = Integer.valueOf(board[i][j]);
            if (nums.contains(val)) return false;
            nums.add(val);
        }
        return true;
    }
    private boolean isValidBlock(char[][] board, int k) {
        int i = k / 3;
        int j = k % 3;
        HashSet<Integer> nums = new HashSet<Integer>(9);
        for (int row = i * 3; row < i * 3 + 3; row++) {
            for (int col = j * 3; col < j * 3 + 3; col++) {
                if (board[row][col] == '.') continue;
                int val = Integer.valueOf(board[row][col]);
                if (nums.contains(val)) return false;
                nums.add(val);
            }
        }
        return true;
    }
}