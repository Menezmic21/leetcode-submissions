// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {
    public int findNumbers(int[] nums) {

        return (int) Arrays.stream(nums).filter(x -> String.valueOf(x).length() % 2 == 0).count();
    }
}