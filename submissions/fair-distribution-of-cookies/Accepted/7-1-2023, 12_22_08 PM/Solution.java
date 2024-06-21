// https://leetcode.com/problems/fair-distribution-of-cookies

class Solution {
    public Integer best = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        return recurse(cookies, new int[k], 0);
    }
    public int recurse(int[] cookies, int[] kids, int idx) {
        if(idx == cookies.length) {
            int max = -1;
            for(int kid:kids) max = Math.max(max, kid);
            best = Math.min(best, max);
            return best;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < kids.length; i++) {
            if(kids[i] >= best) return best;
            int[] newKids = kids.clone();
            newKids[i] += cookies[idx];
            min = Math.min(min, recurse(cookies, newKids, idx+1));
        }
        return min;
    }
}