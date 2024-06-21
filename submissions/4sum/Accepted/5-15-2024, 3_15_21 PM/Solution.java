// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> quadLst = new ArrayList<List<Integer>>();
        for (int i = 0; i < n-3; ) {
            int A = nums[i];
            for (int j = i+1; j < n-2; ) {
                int B = nums[j];
                for (int left = j+1, right = n-1; left < right; ) {
                    int C = nums[left];
                    int D = nums[right];
                    long sum = (long) A + (long) B + (long) C + (long) D;
                    if (sum < target) { // sum is too small
                        left = incrUntilDiff(nums, C, left, 1);
                        if (left == -1) break;
                    } else if (sum > target) {
                        right = incrUntilDiff(nums, D, right, -1);
                        if (right == -1) break;
                    } else {
                        quadLst.add(makeQuad(A, B, C, D));
                        left = incrUntilDiff(nums, C, left, 1);
                        if (left == -1) break;
                    }
                }
                j = incrUntilDiff(nums, B, j, 1);
                if (j == -1) break;
            }
            i = incrUntilDiff(nums, A, i, 1);
            if (i == -1) break;
        } 
        return quadLst;
    }
    private List<Integer> makeQuad(int a, int b, int c, int d) {
        List<Integer> quad = new ArrayList<Integer>(4);
        quad.add(a);
        quad.add(b);
        quad.add(c);
        quad.add(d);
        return quad;
    }
    private int incrUntilDiff(int[] nums, int val, int idx, int step) {
        while (nums[idx] == val) {
            idx += step;
            if (idx < 0 || idx >= nums.length) {
                return -1;
            }
        }
        return idx;
    }
}