// https://leetcode.com/problems/integer-to-roman

class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        num = handlePlace(num, 1000, "M", sb);
        num = handlePlace(num, 900, "CM", sb);
        num = handlePlace(num, 500, "D", sb);
        num = handlePlace(num, 400, "CD", sb);
        num = handlePlace(num, 100, "C", sb);
        num = handlePlace(num, 90, "XC", sb);
        num = handlePlace(num, 50, "L", sb);
        num = handlePlace(num, 40, "XL", sb);
        num = handlePlace(num, 10, "X", sb);
        num = handlePlace(num, 9, "IX", sb);
        num = handlePlace(num, 5, "V", sb);
        num = handlePlace(num, 4, "IV", sb);
        num = handlePlace(num, 1, "I", sb);
        return sb.toString();
    }
    private int handlePlace(int num, int amt, String c, StringBuilder sb) {
        while (num >= amt) {
            sb.append(c);
            num -= amt;
        }
        return num;
    }
}