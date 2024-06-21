// https://leetcode.com/problems/buddy-strings

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false; 
        HashSet<Character> sDiffChars = new HashSet<Character>();
        HashSet<Character> gDiffChars = new HashSet<Character>();
        int diffs = 0;
        for(int i = 0; i < goal.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                sDiffChars.add(s.charAt(i));
                gDiffChars.add(goal.charAt(i));
                diffs++;
            }
            if(diffs > 2) return false;
        }
        if(diffs != 2 && diffs != 0) return false;
        if(diffs == 0) {
            boolean identitySwappable = false;
            HashSet<Character> seen = new HashSet<Character>();
            for(int i = 0; i < goal.length(); i++) {
                if(seen.contains(s.charAt(i))) identitySwappable = true;
                seen.add(s.charAt(i));
            }   
            return identitySwappable;
        }
        return sDiffChars.equals(gDiffChars);
    }
}