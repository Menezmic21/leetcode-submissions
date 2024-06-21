// https://leetcode.com/problems/the-kth-factor-of-n

class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            // if (n % i == 0) System.out.println("fac: " + i);
            if (n % i == 0 && --k == 0) {
                return i;
            }
        }
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            // System.out.println("i: " + i);
            // if (n % i == 0) System.out.println("fac: " + n/i);
            if (n % i == 0 && n / i == i) k++;
            if (n % i == 0 && --k == 0) {
                return n / i;
            }
        }
        return -1;
    }
}