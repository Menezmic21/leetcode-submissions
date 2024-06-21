// https://leetcode.com/problems/unique-number-of-occurrences

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> fMap = new HashMap<Integer, Integer>();
        for (int num : arr) {
            fMap.put(num, fMap.getOrDefault(num, 0)+1);
        }
        return fMap.values().size() == (new HashSet<Integer>(fMap.values())).size();
    }
}