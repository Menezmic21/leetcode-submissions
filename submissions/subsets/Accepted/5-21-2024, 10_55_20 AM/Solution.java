// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> powerset = new ArrayList<List<Integer>>((int) Math.pow(2, nums.length));
        backtrace(powerset, new ArrayList<Integer>(nums.length), nums, 0);
        return powerset;
    }
    private void backtrace(List<List<Integer>> powerset, List<Integer> comb, int[] nums, int idx) {
        if (idx == nums.length) {
            powerset.add(new ArrayList<Integer>(comb));
            return;
        }
        backtrace(powerset, comb, nums, idx+1);
        comb.add(nums[idx]);
        backtrace(powerset, comb, nums, idx+1);
        comb.remove(Integer.valueOf(nums[idx]));
    }
}