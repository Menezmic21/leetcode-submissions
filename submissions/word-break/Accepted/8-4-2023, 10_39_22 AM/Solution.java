// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Collections.sort(wordDict, Collections.reverseOrder());
        HashMap<String, Boolean> mem = new HashMap<String, Boolean>();
        return backtrace(s, wordDict, mem);
    }
    public boolean backtrace(String s, List<String> wordDict, HashMap<String, Boolean> mem) {
        if(mem.get(s) != null) return mem.get(s);
        if(s.equals("")) return true;
        boolean valid = false;
        for(String word : wordDict) {
            if(valid) break;
            if(s.indexOf(word) == 0) valid |= backtrace(s.substring(word.length()), wordDict, mem);
        }
        mem.put(s, valid);
        return valid;
    }
}