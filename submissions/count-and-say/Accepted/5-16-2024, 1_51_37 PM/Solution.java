// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = runLengthEncode(s);
        }
        return s;
    }
    private String runLengthEncode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int left = 0, right = 0; left <= right; ) {
            // System.out.println("(" + left + ", " + right + ")");
            if (s.charAt(left) != s.charAt(right)) {
                sb.append("" + (right - left));
                sb.append(s.charAt(left));
                left = right;
            }
            if (right == s.length()-1) {
                sb.append("" + (right - left + 1));
                sb.append(s.charAt(right));
                break;
            }
            right++;
        }
        // System.out.println("sb: " + sb.toString());
        return sb.toString();
    }
}