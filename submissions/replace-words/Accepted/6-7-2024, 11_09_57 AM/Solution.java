// https://leetcode.com/problems/replace-words

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean flag = false;
            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    sb.append(root);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append(word);
            }
            if (i+1 < words.length) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}