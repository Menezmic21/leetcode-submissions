// https://leetcode.com/problems/find-common-characters

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> rarr = new ArrayList<String>();

        // find smallest word
        String sw = "";
        for (String word : words) {
            if (word.length() > sw.length()) {
                sw = word;
            }
        }

        // add all characters from sw to rarr if found in all words
        for (Character c : sw.toCharArray()) {
            boolean foundInAll = true;
            for (String word : words) {
                if (word.indexOf(c) == -1) {
                    foundInAll = false;
                    break;
                }
            }
            if (foundInAll) {
                rarr.add("" + c);
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    int j = word.indexOf(c);
                    words[i] = word.substring(0, j) + (j+1 < word.length() ? word.substring(j+1) : "");
                }
            }
        }

        return rarr;
    }
}