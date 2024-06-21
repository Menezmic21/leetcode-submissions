// https://leetcode.com/problems/delete-columns-to-make-sorted

class Solution {
    public int minDeletionSize(String[] strs) {
        int deletions = 0;
        for(int j = 0; j < strs[0].length(); j++) {
            for(int i = 1; i < strs.length; i++) {
                if(((Character) strs[i-1].charAt(j)).compareTo(strs[i].charAt(j)) > 0) {
                    deletions++;
                    break;
                }
            }
        }
        return deletions;
    }
}