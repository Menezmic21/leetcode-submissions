// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for(char c:ransomNote.toCharArray()){
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