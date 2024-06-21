// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        return isPalindromeHelper("" + x);
    }
    public boolean isPalindromeHelper(String s) {
        if(s.length() <= 2) return s.charAt(0) == s.charAt(s.length()-1);
        if(s.charAt(0) == s.charAt(s.length()-1)) return isPalindromeHelper(s.substring(1, s.length()-1));
        return false;
    }
}