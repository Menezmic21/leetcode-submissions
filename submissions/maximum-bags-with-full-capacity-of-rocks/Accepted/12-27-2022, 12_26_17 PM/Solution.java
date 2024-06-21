// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[][] space = new int[rocks.length][2];
        for(int i = 0; i < rocks.length; i++) {
            space[i][0] = capacity[i] - rocks[i];
            space[i][1] = i;
        }
        Comparator<int[]> sorter = (int[] bag1, int[] bag2) -> Integer.valueOf(bag1[0]).compareTo(Integer.valueOf(bag2[0]));
        Arrays.sort(space, sorter);
        // for(int[] bag:space) {
        //     System.out.print(bag[0] + " ");
        // }
        int fullBags = 0;
        while(fullBags < rocks.length && additionalRocks > 0) {
            additionalRocks -= space[fullBags][0];
            if(additionalRocks >= 0) {
                fullBags++;
            }
        }
        return fullBags;
    }
}