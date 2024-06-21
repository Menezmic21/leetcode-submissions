// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for(int i = 0; i < ransomNote.length(); i++){
            char C = ransomNote.charAt(i);
            int index = magazine.indexOf(C);
            if(index==-1) return false;
            magazine = magazine.substring(0, index) + magazine.substring(index+1);
        }
        return true;
    }
}