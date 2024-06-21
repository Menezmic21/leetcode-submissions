// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(right < s.length()) {
            left = Math.max(left, map.get(s.charAt(right)) == null ? 0 : map.get(s.charAt(right)) + 1);
            // System.out.println("left: " + left + "; right: " + right + "; " + s.charAt(right));
            max = Math.max(max, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }
        return max;
    }
}