// https://leetcode.com/problems/ipo

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Make Tree Map of capital-> profits in O(n log n)
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < capital.length; i++) {
            List<Integer> vals = map.get(capital[i]);
            boolean missing = false;
            if (vals == null) {
                vals = new ArrayList<>();
                missing = true;
            }
            vals.add(profits[i]);
            if (missing) {
                map.put(capital[i], vals);
            }
        }

        // print map
        // for (int key : map.keySet()) {
        //     System.out.println("key: " + key);
        //     System.out.print("\t");
        //     for (int val : map.get(key)) {
        //         System.out.print("" + val + " ");
        //     }
        //     System.out.println();
        // }

        // Compute maximum profit O(k * n)
        int prev_w = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (k > 0) {
            NavigableMap<Integer, List<Integer>> subMap = map.subMap(prev_w, false, w, true);
            for (List<Integer> vals : subMap.values()) {
                // System.out.print("Adding: ");
                // for (int val : vals) {
                //     System.out.print("" + val + " ");
                // }
                // System.out.println();
                pq.addAll(vals);
            }
            k--;
            prev_w = w;
            if (pq.isEmpty()) {
                break;
            }
            // int max = pq.poll();
            // System.out.println(max);
            w += pq.poll();
        }
        return w;
    }
}