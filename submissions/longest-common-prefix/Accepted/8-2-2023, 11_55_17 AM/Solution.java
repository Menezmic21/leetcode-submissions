// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix = "";
        for(int i = 0; i < strs[0].length(); i++) {
            Character letter = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length()) return longestPrefix;
                if(letter != strs[j].charAt(i)) return longestPrefix;
            }
            longestPrefix += letter;
        }
        return longestPrefix;
    }
}