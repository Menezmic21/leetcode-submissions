// https://leetcode.com/problems/summary-ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        boolean consecutive = false;
        List<String> out = new ArrayList<String>();

        if(nums.length == 0) {
            return out;
        }

        if(nums.length == 1) {
            out.add(String.valueOf(nums[0]));
            return out;
        }

        int prev = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(consecutive) {
                if(nums[i-1] + 1 != nums[i]) { //was consecutive, now not e.g. 3 4 6 ~> "3->4" "6"
                    out.add(String.valueOf(prev) + "->" + String.valueOf(nums[i-1]));
                    consecutive = false;
                    prev = nums[i];
                }
            } else {
                if(nums[i-1] + 1 == nums[i]) { //start of consecutive e.g. 1 3 4 5 ~> "1" "3->5"
                    consecutive = true;
                } else {
                    out.add(String.valueOf(prev)); //still not consecutive; simply add lone num
                    prev = nums[i];
                }
            }
        }

        if(consecutive) {
            out.add(String.valueOf(prev) + "->" + String.valueOf(nums[nums.length-1]));
        } else {
            out.add(String.valueOf(prev));
        }

        return out;
    }
}