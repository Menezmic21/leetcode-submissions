// https://leetcode.com/problems/determine-if-two-strings-are-close

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        HashMap<Character, Integer> fMap1 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            fMap1.put(c, fMap1.getOrDefault(c, 0)+1);
        }
        HashMap<Character, Integer> fMap2 = new HashMap<>();
        for (char c : word2.toCharArray()) {
            fMap2.put(c, fMap2.getOrDefault(c, 0)+1);
        }
        if (!fMap1.keySet().equals(fMap2.keySet())) return false;
        HashMap<Integer, Integer> ffMap1 = new HashMap<>();
        for (Integer i : fMap1.values()) {
            ffMap1.put(i, ffMap1.getOrDefault(i, 0)+1);
        }
        HashMap<Integer, Integer> ffMap2 = new HashMap<>();
        for (Integer i : fMap2.values()) {
            ffMap2.put(i, ffMap2.getOrDefault(i, 0)+1);
        }
        return ffMap1.equals(ffMap2);
    }
}