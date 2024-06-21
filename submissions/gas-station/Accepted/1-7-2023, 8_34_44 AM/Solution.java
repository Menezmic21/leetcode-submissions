// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        PriorityQueue<Integer> validStarts = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i = 0; i < gas.length; i++) {
            if(gas[i] >= cost[i]) validStarts.offer(i);
            // if(gas[i] >= cost[i]) System.out.print(i + " ");
        }
        int index = 0;
        while(!validStarts.isEmpty()) {
            int start = validStarts.poll();
            int i = 0;
            int fuel = 0;
            for(; i <= gas.length && fuel >= 0; i++) {
                index = (i + start) % gas.length;
                fuel += gas[index] - cost[index];
                // System.out.print(fuel + " ");
            }
            // System.out.println();
            if(i == gas.length + 1) {
                return (index) % gas.length;
            }
        }
        return -1;
    }
}