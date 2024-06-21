// https://leetcode.com/problems/increasing-triplet-subsequence

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int v1 = nums[0];
        int v2 = 0;

        int i = 1;
        for ( ; i < nums.length; i++) {
            if (v1 < nums[i]) {
                v2 = nums[i];
                break;
            }
            v1 = nums[i];
        }

        // System.out.println("Start: (" + v1 + ", " + v2 + ")");

        int pv1 = v1;
        for ( ; i < nums.length; i++) {
            int v3 = nums[i];
            // System.out.println("Mid: (" + v1 + ", " + v2 + ", " + v3 + ")");
            // System.out.println("pv1: " + pv1);
            if (v2 < v3) {
                // System.out.println("End: (" + v1 + ", " + v2 + ", " + v3 + ")");
                return true;
            }
            if (v3 < pv1) {
                pv1 = v3;
            }
            if (pv1 < v3) { // v3 <= v2 otherwise would've returned
                v1 = pv1;
                v2 = v3;
            }
        }
        return false;
    }
}