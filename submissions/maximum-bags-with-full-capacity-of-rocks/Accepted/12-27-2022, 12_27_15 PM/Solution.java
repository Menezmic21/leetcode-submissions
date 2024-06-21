// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] space = new int[rocks.length];
        for(int i = 0; i < rocks.length; i++) {
            space[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(space);
        // for(int[] bag:space) {
        //     System.out.print(bag[0] + " ");
        // }
        int fullBags = 0;
        while(fullBags < rocks.length && additionalRocks > 0) {
            additionalRocks -= space[fullBags];
            if(additionalRocks >= 0) {
                fullBags++;
            }
        }
        return fullBags;
    }
}