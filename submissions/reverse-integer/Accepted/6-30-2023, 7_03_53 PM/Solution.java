// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        java.math.BigInteger rNum = new java.math.BigInteger(reverse(String.valueOf(x)));
        if(rNum.compareTo(
                new java.math.BigInteger("" + 
                    ((int) Math.pow(2, 31) - 1)
                )) == 1 || 
            rNum.compareTo(
                new java.math.BigInteger("" + 
                    ((int) -Math.pow(2, 31))
                )) == -1
        ) return 0;

        return rNum.intValue(); 
    }
    public String reverse(String s) {
        String r = "";
        for(int i = s.length() - 1; i > 0; i--) r += s.charAt(i);
        return ("" + s.charAt(0)).equals("-") ? "-" + r : r + s.charAt(0);
    }
}