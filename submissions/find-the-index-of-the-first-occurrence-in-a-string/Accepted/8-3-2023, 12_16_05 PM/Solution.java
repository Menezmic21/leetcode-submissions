// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean match = true;
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if(match) return i;
        }
        return -1;
    }
}