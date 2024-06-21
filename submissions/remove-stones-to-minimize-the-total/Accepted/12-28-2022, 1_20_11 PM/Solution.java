// https://leetcode.com/problems/remove-stones-to-minimize-the-total

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(piles.length, Collections.reverseOrder());
        for(int pile:piles) pq.add(pile);
        while(k > 0 && pq.peek() > 1) {
            int head = pq.poll();
            // System.out.print(head - head / 2 + " ");
            pq.add(head - head / 2);
            k--;
        }

        int sum = 0;
        for(int i = 0; i < piles.length; i++) sum += pq.poll();
        return sum;
    }
}