// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if(sArr.length != pattern.length()) return false;
        HashMap<Character, String> mapping = new HashMap<Character, String>();
        HashMap<String, Character> rMapping = new HashMap<String, Character>();
        for(int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if(!mapping.containsKey(c)) {
                mapping.put(c, sArr[i]);
            } else if(!mapping.get(c).equals(sArr[i])) {
                    return false;
            }
            if(!rMapping.containsKey(sArr[i])) {
                rMapping.put(sArr[i], c);
            } else if(!rMapping.get(sArr[i]).equals(c)) {
                    return false;
            }
        }
        return true;
    }
}