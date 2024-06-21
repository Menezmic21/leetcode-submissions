// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<String>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> combs = new ArrayList<String>();
        backtrace(combs, map, 0, digits, "");
        return combs;
    }
    public void backtrace(List<String> combs, HashMap<Integer, String> map, int start, String digits, String comb) {
        if(comb.length() == digits.length()) {
            combs.add(comb);
            return;
        }
        String chars = map.get(Integer.valueOf("" + digits.charAt(start)));
        for(int i = 0; i < chars.length(); i++) {
            Character c = chars.charAt(i);
            backtrace(combs, map, start+1, digits, comb+c);
        }
    }
}