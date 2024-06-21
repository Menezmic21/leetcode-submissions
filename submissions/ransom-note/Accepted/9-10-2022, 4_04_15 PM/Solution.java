// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for(int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            try{
                int pos = magazine.indexOf(c);
                magazine = magazine.substring(0, pos)+magazine.substring(pos+1);
            }catch(Exception e){
                
                // System.out.println(e);
                return false;
            }
            
        }
        return true;
    }
}