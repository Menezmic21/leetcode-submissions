// https://leetcode.com/problems/buddy-strings

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false; 
        boolean identitySwappable = false;
        HashSet<Character> seen = new HashSet<Character>();
        HashSet<Character> sDiffChars = new HashSet<Character>();
        HashSet<Character> gDiffChars = new HashSet<Character>();
        int diffs = 0;
        for(int i = 0; i < goal.length(); i++) {
            if(seen.contains(s.charAt(i))) identitySwappable = true;
            seen.add(s.charAt(i));
            if(s.charAt(i) != goal.charAt(i)) {
                sDiffChars.add(s.charAt(i));
                gDiffChars.add(goal.charAt(i));
                diffs++;
            }
            if(diffs > 2) return false;
        }
        if(diffs == 0 && identitySwappable) return true;
        if(diffs != 2) return false;
        return sDiffChars.equals(gDiffChars);
    }
}