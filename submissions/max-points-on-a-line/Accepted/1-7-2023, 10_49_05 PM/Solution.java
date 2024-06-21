// https://leetcode.com/problems/max-points-on-a-line

class Solution {
    public int maxPoints(int[][] points) {
        if(points.length < 2) return points.length;
        int max = -1;
        for(int i = 0; i < points.length - 1; i++) {
            int miniMax = -1;
            HashMap<Double, Integer> freq = new HashMap<Double, Integer>();
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;
                int[] pointA = points[i];
                int[] pointB = points[j];
                double slope = Math.atan2(pointA[1] - pointB[1], pointA[0] - pointB[0]); //(pointA[1] - pointB[1]) / (pointA[0] - pointB[0]);
                int val = freq.getOrDefault(slope, 1) + 1;
                if(val > miniMax) miniMax = val;
                freq.put(slope, val);
            }
            if(miniMax > max) max = miniMax;
        }
        return max;
    }
}