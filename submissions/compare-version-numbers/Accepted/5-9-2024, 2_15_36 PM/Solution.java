// https://leetcode.com/problems/compare-version-numbers

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        int len1 = revisions1.length;
        String[] revisions2 = version2.split("\\.");
        int len2 = revisions2.length;
        // System.out.println(Arrays.toString(revisions1));
        // System.out.println(Arrays.toString(revisions2));
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int val = 0;
            if (len1 <= i) { // no left revision
                System.out.println("A");
                val = Integer.compare(0, Integer.valueOf(revisions2[i]));
            } else if (len2 <= i) { // no right revision
            
                val = Integer.compare(Integer.valueOf(revisions1[i]), 0);
            } else { // both have revisions
                val = Integer.compare(Integer.valueOf(revisions1[i]), Integer.valueOf(revisions2[i]));
            }
            // System.out.println("A: " + Integer.valueOf(revisions1[i]));
            // System.out.println("B: " + Integer.valueOf(revisions2[i]));
            if (val != 0) {
                return val > 0 ? 1 : -1;
            }
        }
        return 0;
    }
}