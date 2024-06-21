// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int alt = 0;
        for (int diff : gain) {
            alt += diff;
            max = Math.max(max, alt);
        }
        return max;
    }
}