// https://leetcode.com/problems/longest-subsequence-with-limited-sum

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        // for(int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        for(int i = 0; i < queries.length; i++) {
            int length = 0;
            int sum = nums[0];
            while(sum <= queries[i] && length < nums.length) {
                length++;
                if(length < nums.length) sum += nums[length];
            }
            queries[i] = length;
        }
        return queries;
    }
}