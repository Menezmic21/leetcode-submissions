// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence

class Solution {
    public int appendCharacters(String s, String t) {
        int subseqlen = 0;
        for (int i = 0; i < s.length() && subseqlen < t.length(); i++) {
            if (s.charAt(i) == t.charAt(subseqlen)) {
                subseqlen++;
            }
        }
        return t.length() - subseqlen;
    }
}