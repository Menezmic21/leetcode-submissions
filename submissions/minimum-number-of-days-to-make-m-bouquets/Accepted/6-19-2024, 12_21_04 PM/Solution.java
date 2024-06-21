// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m*k) {
            return -1;
        }
        // System.out.println(isValid(bloomDay, 1, m, k));
        // System.out.println(isValid(bloomDay, 2, m, k));
        // System.out.println(isValid(bloomDay, 3, m, k));
        // System.out.println(isValid(bloomDay, 4, m, k));
        // System.out.println(isValid(bloomDay, 11, m, k));
        // System.out.println(isValid(bloomDay, 12, m, k));
        // System.out.println(isValid(bloomDay, 13, m, k));

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : bloomDay) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // binary search
        int left = min, right = max;
        int minDay = -1;
        if (isValid(bloomDay, left, m, k)) {
            return left;
        }
        if (isValid(bloomDay, right, m, k)) {
            minDay = right;
        }
        for ( ; left <= right; ) {
            int day = (left + right) / 2;
            if (isValid(bloomDay, day, m, k)) {
                minDay = day;
                right = day - 1;
            } else {
                left = day + 1;
            }
        }
        return minDay;
        // return backtrace(bloomDay, 0, m, k, 0, 0);
    }
    private boolean isValid(int[] bloomDay, int day, int m, int k) {
        int end = 0;
        for (int w = 0; w < m; w++) {
            // System.out.println("start: " + end);
            end = getNextEnd(bloomDay, day, k, end);
            // System.out.println("end: " + end);
            // System.out.println();
            if (end == -1) {
                return false;
            } else {
                end++;
            }
        }
        return true;
    }
    private int getNextEnd(int[] bloomDay, int day, int k, int start) {
        for (int left = start, right = start; right < bloomDay.length; right++) {
            if (bloomDay[right] > day) {
                while (right < bloomDay.length && bloomDay[right] > day) {
                    right++;
                }
                left = right;
            }
            if (right < bloomDay.length && right - left == k-1) {
                return right;
            }
        }
        return -1;
    }
    // private int backtrace(int[] bloomDay, int val, int m, int k, int i, int j) {
    //     if (i == m) {
    //         return val;
    //     }
    //     if (j >= bloomDay.length) {
    //         return Integer.MAX_VALUE;
    //     } 
    //     int min = Integer.MAX_VALUE;
    //     for (int w = j; w <= bloomDay.length - (m-i) * k; w++) {
    //         int max = bloomDay[w];
    //         for (int x = 0; x < k; x++) {
    //             max = Math.max(max, bloomDay[w+x]);
    //         }
    //         // System.out.println("max[" + w + ", " + (w+k) + "): " + max);
    //         min = Math.min(min, backtrace(bloomDay, Math.max(val, max), m, k, i+1, w+k));
    //     }
    //     return min;
    // }
}