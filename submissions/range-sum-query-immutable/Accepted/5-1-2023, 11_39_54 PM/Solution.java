// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {

    int[] pref;

    public NumArray(int[] nums) {
        pref = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) { 
            pref[i+1] = pref[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        //System.out.println(pref[right]);
        return pref[right+1] - pref[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

