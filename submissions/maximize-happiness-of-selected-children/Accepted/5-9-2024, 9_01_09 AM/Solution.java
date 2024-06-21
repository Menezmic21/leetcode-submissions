// https://leetcode.com/problems/maximize-happiness-of-selected-children

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // O(n log k + k)
        // int spots_filled = 0;
        // int[] topK = new int[k];
        // for (int i = 0; i < happiness.length; i++) {
        //     placeIfBig(topK, happiness[i], spots_filled);
        // }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int happy : happiness) {
            pq.add(happy);
        }
        long sum = 0;
        int i = 0;
        for ( ; i < k; i++) {
            int elt = pq.poll();
            if (elt <= i) { // rest are zero
                break;
            }
            sum += elt - i;
        }
        return sum;
    }

    // private void placeIfBig(int[] topK, int happiness, int spots_filled) {
    //     if (spots_filled < topK.length) {
    //         topK[spots_filled] = happiness;
    //     }

    //     for (int i = 0; i < topK.length; i++) {
    //         if (topK[i] < happiness) {
    //             topK[i] = happiness;
    //         }
    //     }
    // }
}