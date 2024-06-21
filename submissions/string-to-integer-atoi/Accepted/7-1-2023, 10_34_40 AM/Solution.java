// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        int left = 0;
        int right = 0;
        int idx = 0;
        boolean negative = false;
        String allowed = " 0123456789+-";
        while(idx < s.length() && allowed.indexOf(s.charAt(idx)) == 0) {
            left++;
            idx++;
        }
        if(idx < s.length() && allowed.indexOf(s.charAt(idx)) > 10) {
            if(allowed.indexOf(s.charAt(idx)) == 12) negative = true;
            left++;
            idx++;
        } 
        while(idx < s.length() && allowed.indexOf(s.charAt(idx)) == 1) {
            left++;
            idx++;
        }
        while(idx < s.length() && 
            allowed.indexOf(s.charAt(idx)) > 0 && 
            allowed.indexOf(s.charAt(idx)) < 11) {

            right++;
            idx++;
        }
        right += left;
        String r = (negative ? "-" : "") + s.substring(left, right);
        System.out.println(r);
        if(r.length() > 11) return (("" + r.charAt(0)).equals("-") ? (int) -Math.pow(2, 31) : (int) (Math.pow(2, 31)-1));
        long lNum;
        try {
            lNum = Long.valueOf(r);
        } catch(Exception e) {
            return 0;
        }
        if(lNum > Math.pow(2, 31)-1) return (int) (Math.pow(2, 31)-1);
        if(lNum < -Math.pow(2, 31)) return (int) -Math.pow(2, 31);
        return (int) lNum;
    }
}