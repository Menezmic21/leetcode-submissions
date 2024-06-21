// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        String longestPalindrome = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length() - i; j++) {
                if(i == 0) dp[j][j] = 1; 
                else if(s.charAt(j) == s.charAt(i+j)) {
                    dp[j][i+j] = dp[j+1][i+j-1] + ((i == 1 || dp[j+1][i+j-1] != 0) ? 2 : 0);
                    // System.out.println("i: " + j + "; j: " + (i+j) + "; l: " + dp[j][i+j] + "; str: " + s.substring(j, i+j+1));
                }
                if(dp[j][i+j] > longestPalindrome.length()) {
                    longestPalindrome = s.substring(j, i+j+1);
                    // System.out.println("i: " + i + "; j: " + j + "; str: " + longestPalindrome);
                }
            }
        }
        return longestPalindrome;
    }
}