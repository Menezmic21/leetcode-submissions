// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c == '(') stack.add(0,')');
            else if(c == '[') stack.add(0,']');
            else if(c == '{') stack.add(0,'}');
            else if(!stack.isEmpty() && c == stack.get(0)) stack.remove(0);
            else return false;
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}