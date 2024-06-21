// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

class Solution {
    public int countTriplets(int[] arr) {
        int n_equal = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length-1; i++) {
            a ^= arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                a ^= arr[j];
                b = arr[j];
                for (int k = j; k < arr.length; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        n_equal++;
                    }
                }
            }
            a = 0;
        }
        return n_equal;
    }
}