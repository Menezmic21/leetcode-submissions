// https://leetcode.com/problems/hand-of-straights

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        HashMap<Integer, Integer> cardFreq = new HashMap<Integer, Integer>();
        for (int card : hand) {
            cardFreq.put(card, cardFreq.getOrDefault(card, 0) + 1);
        }

        List<Integer> uniqueVals = new ArrayList<Integer>(cardFreq.keySet());
        Collections.sort(uniqueVals);
        for (Integer uniqueVal : uniqueVals) {
            while (cardFreq.get(uniqueVal) != 0) {
                if (nextGroupValid(uniqueVal, groupSize, cardFreq)) {
                    decGroup(uniqueVal, groupSize, cardFreq);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean nextGroupValid(int i, int gs, HashMap<Integer, Integer> cardFreq) {
        for (int j = i; j < i + gs; j++) {
            if (cardFreq.getOrDefault(j, 0) == 0) {
                return false;
            }
        }
        return true;
    }
    private void decGroup(int i, int gs, HashMap<Integer, Integer> cardFreq) {
        for (int j = i; j < i + gs; j++) {
            cardFreq.put(j, cardFreq.get(j)-1);
        }
    }
}