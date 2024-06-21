// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] lst = new int[nums1.length + nums2.length];
        int first = 0;
        int second = 0;
        for(int i = 0; i < lst.length; i++) {
            if(first < nums1.length && second < nums2.length) {
                if(nums1[first] <= nums2[second]) {
                    lst[i] = nums1[first];
                    first++;
                } else {
                    lst[i] = nums2[second];
                    second++;
                }
            } else if(first < nums1.length) {
                lst[i] = nums1[first];
                first++;
            } else {
                lst[i] = nums2[second];
                second++;
            }
            
        }
        int size = lst.length;
        if(size % 2 == 0) return (lst[size / 2 - 1] + lst[size / 2]) / 2.0; 
        return lst[size / 2];
    }
}