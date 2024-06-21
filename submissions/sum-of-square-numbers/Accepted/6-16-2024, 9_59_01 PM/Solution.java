// https://leetcode.com/problems/sum-of-square-numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        for (int left = 0, right = (int) Math.sqrt(c); left <= right; ) {
            long sum = (long) Math.pow(left, 2) + (long) Math.pow(right, 2);
            if (sum < c) {
                left++;
            } else if (sum > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}