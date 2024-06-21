// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        long rLong = Long.valueOf(reverse(String.valueOf(x)));
        if(rLong > Math.pow(2, 31) - 1 || rLong < -Math.pow(2, 31)) return 0;
        return (int) rLong; 
    }
    public String reverse(String s) {
        String r = "";
        for(int i = s.length() - 1; i > 0; i--) {
            r += s.charAt(i);
        }
        return ("" + s.charAt(0)).equals("-") ? "-" + r : r + s.charAt(0);
    }
}