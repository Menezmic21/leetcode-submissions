// https://leetcode.com/problems/sum-of-all-subset-xor-totals

class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        sum = 0;
        backtrace(nums, new ArrayList<Integer>(), 0);
        return sum;
    }
    private void backtrace(int[] nums, List<Integer> subset, int idx) {
        if (idx == nums.length) {
            if (subset.size() == 0) {
                return;
            }
            int xor = subset.get(0);
            for (int i = 1; i < subset.size(); i++) {
                xor ^= subset.get(i);
            }
            // System.out.println("xor: " + xor);
            sum += xor;
            return;
        }
        subset.add(nums[idx]);
        backtrace(nums, subset, idx+1);
        subset.remove(Integer.valueOf(nums[idx]));
        backtrace(nums, subset, idx+1);
    }
}