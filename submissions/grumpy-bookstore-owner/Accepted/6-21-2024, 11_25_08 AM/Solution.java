// https://leetcode.com/problems/grumpy-bookstore-owner

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ppl_satisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                ppl_satisfied += customers[i];
            }
        }
        int i = 0;
        for ( ; i < minutes; i++) {
            if (grumpy[i] == 1) {
                ppl_satisfied += customers[i];
            }
        }
        int max = ppl_satisfied;
        for ( ; i < customers.length; i++) {
            if (grumpy[i-minutes] == 1) {
                ppl_satisfied -= customers[i-minutes];
            }
            if (grumpy[i] == 1) {
                ppl_satisfied += customers[i];
            }
            max = Math.max(max, ppl_satisfied);
        }
        return max;
    }
}