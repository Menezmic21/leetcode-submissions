// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> targetCombs = new ArrayList<List<Integer>>();
        backtrace(targetCombs, candidates, new ArrayList<Integer>(), 0, 0, target);
        return targetCombs;
    }
    private void backtrace(List<List<Integer>> targetCombs, int[] candidates, List<Integer> currComb, int currIdx, int sum, int target) {
        if (sum > target) {
            // System.out.println("too big");
            return;
        }
        if (sum == target) {
            // System.out.println("adding a comb");
            targetCombs.add(new ArrayList<Integer>(currComb));
            return;
        }
        for (int i = currIdx; i < candidates.length; i++) {
            currComb.add(candidates[i]);
            backtrace(targetCombs, candidates, currComb, i, sum + candidates[i], target);
            currComb.remove(Integer.valueOf(candidates[i]));
        }
    }
}