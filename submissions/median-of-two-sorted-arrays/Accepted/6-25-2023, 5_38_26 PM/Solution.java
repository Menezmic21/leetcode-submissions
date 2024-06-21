// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] lst = new int[nums1.length + nums2.length];
        for(int i = 0; i < nums1.length; i++) {
            lst[i] = nums1[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            lst[i+nums1.length] = nums2[i];
        }
        Arrays.sort(lst);
        int size = lst.length;
        if(size % 2 == 0) return (lst[size / 2 - 1] + lst[size / 2]) / 2.0; 
        return lst[size / 2];
    }
}