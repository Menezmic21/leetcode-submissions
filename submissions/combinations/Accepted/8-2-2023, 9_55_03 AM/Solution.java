// https://leetcode.com/problems/combinations

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        backtrace(combs, n, k, 1, new ArrayList<Integer>());
        return combs;
    }

    public void backtrace(List<List<Integer>> combs, int n, int k, int start, ArrayList<Integer> comb) {
        if(comb.size() == k) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i = start; i <= n; i++) {
            ArrayList<Integer> newComb = new ArrayList<Integer>(comb);
            newComb.add(i);
            backtrace(combs, n, k, i+1, newComb);
            newComb.remove(newComb.size()-1);
        }

    }
}