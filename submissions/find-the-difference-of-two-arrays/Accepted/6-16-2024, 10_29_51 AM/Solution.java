// https://leetcode.com/problems/find-the-difference-of-two-arrays

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> uNums1 = new HashSet<Integer>();
        for (int num : nums1) {
            uNums1.add(num);
        }
        HashSet<Integer> temp = new HashSet<Integer>(uNums1);
        HashSet<Integer> uNums2 = new HashSet<Integer>();
        for (int num : nums2) {
            uNums2.add(num);
        }
        uNums1.removeAll(uNums2);
        uNums2.removeAll(temp);
        List<List<Integer>> answer = new ArrayList<List<Integer>>(2);
        answer.add(new ArrayList<Integer>(uNums1));
        answer.add(new ArrayList<Integer>(uNums2));
        return answer;
    }
}