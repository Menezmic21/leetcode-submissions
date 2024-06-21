// https://leetcode.com/problems/roman-to-integer

class Solution {
    int[] vals = {1, 5, 10, 50, 100, 500, 1000};
    HashMap<String, Integer> map = new HashMap<String, Integer>(7);
    public Solution() {
        map.put("I", 0);
        map.put("V", 1);
        map.put("X", 2);
        map.put("L", 3);
        map.put("C", 4);
        map.put("D", 5);
        map.put("M", 6);
    }
    public int romanToInt(String s) {
        int expected = 0;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get("" + s.charAt(i));
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