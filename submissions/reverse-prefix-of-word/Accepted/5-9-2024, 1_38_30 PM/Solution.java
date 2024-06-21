// https://leetcode.com/problems/reverse-prefix-of-word

class Solution {
    public String reversePrefix(String word, char ch) {
        if (word.indexOf(ch) == -1) return word;
        String front = word.substring(0, word.indexOf(ch) + 1);
        String back = word.substring(word.indexOf(ch) + 1);
        return reverse(front) + back;
    }
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}