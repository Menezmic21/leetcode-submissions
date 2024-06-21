// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> nums = new HashSet<Integer>(9);
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(nums, board, i)) {
                return false;
            }
            nums.clear();
            if (!isValidCol(nums, board, i)) {
                return false;
            }
            nums.clear();
            if (!isValidBlock(nums, board, i)) {
                return false;
            }
            nums.clear();
        }
        return true;
    }
    private boolean isValidRow(HashSet<Integer> nums, char[][] board, int i) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') continue;
            int val = Integer.valueOf(board[i][j]);
            if (nums.contains(val)) return false;
            nums.add(val);
        }
        return true;
    }
    private boolean isValidCol(HashSet<Integer> nums, char[][] board, int j) {
        for (int i = 0; i < 9; i++) {
            if (board[i][j] == '.') continue;
            int val = Integer.valueOf(board[i][j]);
            if (nums.contains(val)) return false;
            nums.add(val);
        }
        return true;
    }
    private boolean isValidBlock(HashSet<Integer> nums, char[][] board, int k) {
        int i = k / 3;
        int j = k % 3;
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