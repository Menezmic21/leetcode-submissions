// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(char c:magazine.toCharArray()){
            arr[c - 'a'] += 1;
        }
        for(char c:ransomNote.toCharArray()){
            arr[c - 'a'] -= 1;
            if(arr[c - 'a'] < 0)
            return false;
        }
        return true;
    }
}