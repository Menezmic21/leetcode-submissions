// https://leetcode.com/problems/the-number-of-beautiful-subsets

class Solution {
    int n_sets;
    public int beautifulSubsets(int[] nums, int k) {
        n_sets = 0;
        backtrace(new HashMap<Integer, Integer>(), nums, k, 0);
        return n_sets;
    }
    private void backtrace(HashMap<Integer, Integer> multiset, int[] nums, int k, int idx) {
        if (idx == nums.length) {
            if (!multiset.isEmpty()) {
                n_sets++;
            }
            return;
        }
        // backtrace(set, nums, k, idx+1);
        // if (!set.contains(nums[idx] - k) && !set.contains(nums[idx] + k)) {
        //     return;
        // }
        // set.add(nums[idx]);
        // if (!set.contains(nums[idx] - k) && !set.contains(nums[idx] + k)) {
        //     backtrace(set, nums, k, idx+1);
        //     // return;
        // }
        // // backtrace(set, nums, k, idx+1);
        // set.remove(Integer.valueOf(nums[idx]));
        // backtrace(set, nums, k, idx+1);

        if (multiset.get(nums[idx]-k) == null && multiset.get(nums[idx]+k) == null) {
            multiset.putIfAbsent(nums[idx], 0);
            multiset.compute(nums[idx], (key, v) -> v+1);
            backtrace(multiset, nums, k, idx+1);
            multiset.compute(nums[idx], (key, v) -> v-1);
            if (multiset.get(nums[idx]) == 0) {
                multiset.remove(nums[idx]);
            }
        }
        backtrace(multiset, nums, k, idx+1);
    }
}