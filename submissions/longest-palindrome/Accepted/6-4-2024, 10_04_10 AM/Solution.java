// https://leetcode.com/problems/longest-palindrome

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        boolean has_single = false;
        int n_pairs = 0;

        for (int f : freq.values()) {
            n_pairs += f / 2;
            has_single |= f % 2 == 1;
        }
        return has_single ? 2 * n_pairs + 1 : 2 * n_pairs;
    }
}