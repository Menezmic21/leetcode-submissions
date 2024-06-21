// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        Comparator<int[]> order = (int[] a, int[] b) -> {
            if(a[0] != b[0]) {
                return ((Integer) a[0]).compareTo(b[0]);
            } else {
                return ((Integer) a[1]).compareTo(b[1]);
            }
        };
        Arrays.sort(points, order);
        int shots = 0;
        for(int i = 0; i < points.length;) {
            int startX = points[i][0];
            int endX = points[i][1];
            int j = i + 1;
            int minX = endX;
            while(j < points.length && points[j][0] <= endX && minX >= points[j][0]) {
                if(points[j][1] < minX) minX = points[j][1];
                j++;
            }
            shots++;
            i = j;
        }
        return shots;
    }
}