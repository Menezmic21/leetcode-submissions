// https://leetcode.com/problems/sum-of-square-numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; Math.pow(i, 2) <= c; i++) {
            nums.add((int) Math.pow(i, 2));
        }
        // System.out.println(nums);
        for (int left = 0, right = nums.size()-1; left <= right; ) {
            long sum = (long) nums.get(left) + nums.get(right);
            // System.out.println(sum);
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