// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        if(n > 0) {
            for(int i = 0; i < nums1.length; i++) {
                if(p2 >= n || (nums1[p1] < nums2[p2] && p1 < m)) {
                    nums.add(nums1[p1]);
                    if(p1 + 1 <= m) p1++;
                } else if(p2 < n) {
                    nums.add(nums2[p2]);
                    if(p2 + 1 <= n) p2++;
                }
            }
            for(int i = 0; i < m + n; i++) {
                nums1[i] = nums.get(i);
            }
        }
    }
}