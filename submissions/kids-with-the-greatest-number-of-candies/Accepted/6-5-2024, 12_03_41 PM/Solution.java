// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> rarr = new ArrayList<Boolean>(candies.length);
        // get max
        int max = -1;
        for (int n_candy : candies) {
            max = Math.max(max, n_candy);
        }

        for (int n_candy : candies) {
            rarr.add(n_candy + extraCandies >= max);
        }
        return rarr;
    }
}