// https://leetcode.com/problems/domino-and-tromino-tiling

class Solution {
    public int numTilings(int n) {
        int[] sequence = new int[Math.max(n, 3)];
        int mod = 1000000007;
        sequence[0] = 1;
        sequence[1] = 2;
        sequence[2] = 5;
        for(int i = 3; i < n; i++) {
            sequence[i] = ((2 * sequence[i-1])  % mod + sequence[i-3]) % mod;
        }
        return sequence[n-1];
    }
}