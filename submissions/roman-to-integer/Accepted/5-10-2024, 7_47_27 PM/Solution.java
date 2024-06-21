// https://leetcode.com/problems/roman-to-integer

class Solution {
    int[] vals = {1, 5, 10, 50, 100, 500, 1000};
    String chars = "IVXLCDM";
    public int romanToInt(String s) {
        int expected = 0;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = chars.indexOf(s.charAt(i));
            if (curr >= expected) {
                num += vals[curr];
                expected = curr;
            } else {
                num -= vals[curr];
            }
        }
        return num;
    }
}