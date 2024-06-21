// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int idx = 0;
        int max = 0;
        while(idx < s.length()) {
            max = Math.max(max, lengthOfLongestSubstringStartingAtIndex(s, idx));
            idx++;
        }
        return max;
    }
    public int lengthOfLongestSubstringStartingAtIndex(String s, int idx) {
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        int cnt = 0;
        while(idx < s.length() && map.get(s.charAt(idx)) == null) {
            map.computeIfAbsent(s.charAt(idx), (k) -> true);
            idx++;
            cnt++;
        }
        return cnt;
    }
}