// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<List<Integer>>();
        buildPerms(perms, new ArrayList<Integer>(Arrays.stream(nums).boxed().toList()), new ArrayList<Integer>());
        return perms;
    }
    public void buildPerms(List<List<Integer>> perms, ArrayList<Integer> nums, ArrayList<Integer> perm) {
        if(nums.size() == 0) {
            perms.add(new ArrayList<Integer>(perm));
            return;
        }
        ArrayList<Integer> newNums = new ArrayList<Integer>(nums);
        for(Integer num : nums) {
            newNums.remove(num);
            perm.add(num);
            buildPerms(perms, newNums, perm);
            perm.remove(perm.size()-1);
            newNums.add(num);
        }
    }
}