// https://leetcode.com/problems/maximize-happiness-of-selected-children

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // O(n log k + k)
        // int spots_filled = 0;
        // int[] topK = new int[k];
        // for (int i = 0; i < happiness.length; i++) {
        //     placeIfBig(topK, happiness[i], spots_filled);
        // }

        Arrays.sort(happiness);
        long sum = 0;
        for (int i = 0; i < k; i++) {
            if (happiness[happiness.length - 1 - i] <= i) { // rest are zero
                break;
            }
            sum += happiness[happiness.length - 1 - i] - i;
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