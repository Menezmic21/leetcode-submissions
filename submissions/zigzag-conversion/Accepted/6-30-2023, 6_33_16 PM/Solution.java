// https://leetcode.com/problems/zigzag-conversion

class Solution {
    public String convert(String s, int numRows) {
        String[] whiteboard = new String[numRows];
        for(int i = 0; i < numRows && i < s.length(); i++) {
            whiteboard[i] = "" + s.charAt(i);
        }
        int idx = numRows;
        while(idx < s.length()) {
            for(int i = numRows-2; i > 0 && idx < s.length(); i--, idx++) {
                whiteboard[i] += s.charAt(idx);
            }
            for(int i = 0; i < numRows && idx < s.length(); i++, idx++) {
                whiteboard[i] += s.charAt(idx);
            }
        }
        String r = "";
        for(String w : whiteboard) {
            if(w == null) break;
            r += w;
        }
        return r;
    }
}