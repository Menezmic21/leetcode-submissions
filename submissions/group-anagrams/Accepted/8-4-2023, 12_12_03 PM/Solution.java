// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if(map.get(s) == null) groups.add(new ArrayList<String>());
            map.putIfAbsent(s, map.size());
            groups.get(map.get(s)).add(str);
        }
        return groups;
    }
}