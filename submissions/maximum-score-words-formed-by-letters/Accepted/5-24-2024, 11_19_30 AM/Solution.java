// https://leetcode.com/problems/maximum-score-words-formed-by-letters

class Solution {
    int maxScore = -1;
    public int maxScoreWords(String[] words, char[] letters, int[] scores) {
        maxScore = 0;
        // compute letter frequencies
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : letters) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // for (Character c : freqMap.keySet()) {
        //     System.out.println("" + c + " -> " + freqMap.get(c));
        // }
        backtrace(words, new ArrayList<String>(words.length), freqMap, scores, 0);
        return maxScore;
    }
    private void backtrace(String[] words, List<String> wordList, HashMap<Character, Integer> freqMap, int[] scores, int idx) {
        if (idx == words.length) {
            // compute score
            int score = 0;
            for (String word : wordList) {
                // System.out.print(word + " ");
                for (char c : word.toCharArray()) {
                    score += scores[c - 'a'];
                }
            }
            // System.out.println();
            maxScore = Math.max(maxScore, score);
            return;
        }
        backtrace(words, wordList, new HashMap<Character, Integer>(freqMap), scores, idx+1);
        for (char c : words[idx].toCharArray()) {
            Integer letterFreq = freqMap.get(c);
            if (letterFreq == null || letterFreq == 0) {
                return;
            }
            freqMap.put(c, letterFreq-1);
        }
        wordList.add(words[idx]);
        backtrace(words, wordList, new HashMap<Character, Integer>(freqMap), scores, idx+1);
        wordList.remove(words[idx]);
    }
}