// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        String ns = "";
        for (int left = 0, right = 1; left < s.length(); ) {
            // get rid of space
            while (left < s.length() && s.charAt(left) == ' ') {
                left++;
            }
            right = left + 1;

            // move right to next space
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }

            if (left >= s.length()) {
                break;
            }

            // add word in reverse
            ns = s.substring(left, right) + (ns.equals("") ? "" : " ") + ns;
            left = right;
        }
        return ns;
    }
}