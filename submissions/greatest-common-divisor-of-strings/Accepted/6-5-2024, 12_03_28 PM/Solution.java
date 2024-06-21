// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String ss = str1;
        String ls = str2;
        if (str1.length() > str2.length()) {
            ls = str1;
            ss = str2;
        }
        for (int i = ss.length()-1; i >= 0; i--) {
            if (isCD(ss.substring(0, i+1), ss, ls)) {
                // System.out.println("str: " + ss.substring(0, i+1) + " -> true");
                return ss.substring(0, i+1);
            } 
            // else System.out.println("str: " + ss.substring(0, i+1) + " -> false");
        }
        return "";
    }
    private boolean isCD(String s, String str1, String str2) {
        if (str1.length() % s.length() != 0) return false;
        if (str2.length() % s.length() != 0) return false;
        // System.out.println("valid length");
        for (int i = 0; i < str1.length() / s.length(); i++) {
            if (!s.equals(str1.substring(i * s.length(), (i+1) * s.length()))) {
                // System.out.println("" + s + " vs " + str1.substring(i * s.length(), (i+1) * s.length()));
                return false;
            }
        }
        for (int i = 0; i < str2.length() / s.length(); i++) {
            if (!s.equals(str2.substring(i * s.length(), (i+1) * s.length()))) {
                // System.out.println("" + s + " vs " + str2.substring(i * s.length(), (i+1) * s.length()));
                return false;
            }
        }
        return true;
    }
}