// https://leetcode.com/problems/max-consecutive-ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = -1;
        boolean consec = true;
        int val = 0;
        for(int num:nums) {
            if(num == 1) {
                val++;
                consec = true;
            } else {
                consec = false;
            }
            if(!consec){
                if(val > max) max = val;
                val = 0;
            }
        }
        if(val > max) max = val;
        return max;
    }
}