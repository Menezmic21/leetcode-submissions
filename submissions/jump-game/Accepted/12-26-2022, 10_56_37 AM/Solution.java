// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        boolean[] memory = new boolean[nums.length];
        return jump(0, nums, visited, memory);
    }

    public boolean jump(int pos, int[] nums, boolean[] visited, boolean[] memory) {
        if(pos >= nums.length - 1) return true;
        if(visited[pos]) return memory[pos];
        boolean reachedEnd = false;
        for(int l = 1; l <= nums[pos]; l++) {
            reachedEnd = reachedEnd || jump(pos + l, nums, visited, memory);
            if(reachedEnd) break;
        }
        visited[pos] = true;
        memory[pos] = reachedEnd;
        return reachedEnd;
    }
}