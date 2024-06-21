// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        // try {
        //     System.out.print("ans: " + ds(s));
        // } catch(Exception e) {

        // }
        // return "";
        return ds(s);
    }
    private String ds(String s) {
        // System.out.println("ds: " + s);
        if (s.equals("")) {
            return s;
        }
        String nonlets = "[]0123456789";
        int i = 0;
        while (i < s.length() && nonlets.indexOf(s.charAt(i)) == -1) {
            i++;
        }
        if (i == s.length()) {

            return s;
        }
        String letPref = s.substring(0, i);

        String nums = "0123456789";
        int j = i;
        while (nums.indexOf(s.charAt(j)) != -1) {
            j++;
        }
        int multi = Integer.valueOf(s.substring(i, j));

        int k = j+1;
        int depth = 1;
        while (depth != 0) {
            if (s.charAt(k) == ']') {
                depth--;
            }
            if (s.charAt(k) == '[') {
                depth++;
            }
            k++;
        }
        k--;
        String inner = ds(s.substring(j+1, k));

        String ns = "";
        for (int w = 0; w < multi; w++) {
            ns += inner;
        }
        return letPref + ns + ds(s.substring(k+1));
    }
}