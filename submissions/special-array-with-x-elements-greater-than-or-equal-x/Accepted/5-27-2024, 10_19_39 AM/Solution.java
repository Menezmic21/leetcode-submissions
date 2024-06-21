// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x

class Solution {
    public int specialArray(int[] nums) {
        int max = -1;
        int cnt = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            if (num >= 1) {
                cnt++;
            }
        }
        if (cnt == 1) {
            return 1;
        }
        for (int i = 2; i <= max; i++) {
            if (nGEQ(nums, i) == i) {
                return i;
            }
        }
        return -1;
    }
    private int nGEQ(int[] nums, int x) {
        int cnt = 0;
        for (int num : nums) {
            if (num >= x) {
                cnt++;
            }
        }
        return cnt++;
    }
}