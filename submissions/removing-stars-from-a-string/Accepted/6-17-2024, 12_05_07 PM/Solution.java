// https://leetcode.com/problems/removing-stars-from-a-string

class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.removeFirst();
            } else {
                stack.addFirst(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.reverse().toString();
    }
}