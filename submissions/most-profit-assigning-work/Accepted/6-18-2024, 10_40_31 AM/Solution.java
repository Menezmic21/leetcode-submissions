// https://leetcode.com/problems/most-profit-assigning-work

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        PriorityQueue<int[]> diffPQ = new PriorityQueue<>((int[] A, int[] B) -> (Integer.compare(A[0], B[0])));
        for (int i = 0; i < difficulty.length; i++) {
            int[] pair = new int[2];
            pair[0] = difficulty[i];
            pair[1] = profit[i];
            diffPQ.add(pair);
        }
        int maxProfit = 0;
        PriorityQueue<int[]> profPQ = new PriorityQueue<>((int[] A, int[] B) -> (Integer.compare(B[1], A[1])));
        for (int i = 0; i < worker.length; i++) {
            while (!diffPQ.isEmpty() && diffPQ.peek()[0] <= worker[i]) {
                profPQ.add(diffPQ.poll());
            }
            if (!profPQ.isEmpty()) {
                maxProfit += profPQ.peek()[1];
            }
        }
        return maxProfit;
    }
}