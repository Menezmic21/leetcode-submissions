// https://leetcode.com/problems/magnetic-force-between-two-balls

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        System.out.println(forceIsAtLeast(position, m, 3));
        int left = 1, right = (position[position.length-1] + position[0]) / (m - 1) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!forceIsAtLeast(position, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left-1;
    }
    private boolean forceIsAtLeast(int[] position, int m, int force) {
        int prev = Integer.MIN_VALUE;
        for (int pos : position) {
            if (pos >= prev + force) {
                m--;
                prev = pos;
            }
            if (m == 0) {
                return true;
            }
        }
        return false;
    }
}