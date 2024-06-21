// https://leetcode.com/problems/reverse-prefix-of-word

class Solution {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if (i == -1) return word;
        i++;
        String front = word.substring(0, i);
        String back = word.substring(i);
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