// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> mapping = new HashMap<Character, String>();
        HashMap<String, Character> rMapping = new HashMap<String, Character>();
        String[] sArr = s.split(" ");
        if(sArr.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if(mapping.getOrDefault(c, null) == null) {
                mapping.put(c, sArr[i]);
            } else if(!mapping.get(c).equals(sArr[i])) {
                    return false;
            }
            if(rMapping.getOrDefault(sArr[i], null) == null) {
                rMapping.put(sArr[i], c);
            } else if(!rMapping.get(sArr[i]).equals(c)) {
                    return false;
            }
        }
        return true;
    }
}