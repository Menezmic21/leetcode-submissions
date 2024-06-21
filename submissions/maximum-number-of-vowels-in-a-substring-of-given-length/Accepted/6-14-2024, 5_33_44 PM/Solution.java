// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

class Solution {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int n_vowels = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                n_vowels++;
            }
        }
        int max = n_vowels;
        for (int i = k; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                n_vowels++;
            }
            if (vowels.indexOf(s.charAt(i-k)) != -1) {
                n_vowels--;
            }
            max = Math.max(max, n_vowels);
            if (max == k) {
                return k;
            }
        }
        return max;
    }
}