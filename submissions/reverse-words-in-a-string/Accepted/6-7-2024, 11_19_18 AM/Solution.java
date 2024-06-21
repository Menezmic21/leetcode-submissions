// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\s+");
        // for (int left = 0, right = words.length-1; left < right; left++, right--) {
        //     String temp = words[left];
        //     words[left] = words[right];
        //     words[right] = temp;
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}