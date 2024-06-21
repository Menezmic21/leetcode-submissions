// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < magazine.length(); i++){
            Character character = magazine.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        for(int i = 0; i < ransomNote.length(); i++){
            Character character = ransomNote.charAt(i);
            int value = map.getOrDefault(character, 0) - 1;
            if(value < 0) return false;
            map.put(character, value);
        }
        return true;
    }
}