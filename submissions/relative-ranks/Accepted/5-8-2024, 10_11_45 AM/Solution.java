// https://leetcode.com/problems/relative-ranks

class Solution {
    public String[] findRelativeRanks(int[] scores) {
        int nElts = scores.length;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < nElts; i++) {
            hmap.put(scores[i], i);
            pq.add(scores[i]);
        }
        String[] placements = new String[nElts];
        int rank = 1;
        while (!pq.isEmpty()) {
            int score = pq.poll();
            placements[hmap.get(score)] = convertRank(rank++);
        }
        return placements;
    }
    private String convertRank(int rank) {
        if (rank == 1) {
            return "Gold Medal";
        } else if (rank == 2) {
            return "Silver Medal";
        } else if (rank == 3) {
            return "Bronze Medal";
        } else {
            return "" + rank;
        }
    }
}