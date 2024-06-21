// https://leetcode.com/problems/path-with-maximum-probability

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, ArrayList<double[]>> neighbors = new HashMap<Integer, ArrayList<double[]>>();
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            // System.out.println("" + edge[0] + ", " + edge[1]);
            ArrayList<double[]> lst = neighbors.getOrDefault(edge[0], new ArrayList<double[]>());
            double[] pair = {edge[1], -Math.log(succProb[i])};
            lst.add(pair);
            neighbors.put(edge[0], lst);

            ArrayList<double[]> lst2 = neighbors.getOrDefault(edge[1], new ArrayList<double[]>());
            double[] pair2 = {edge[0], -Math.log(succProb[i])};
            lst2.add(pair2);
            neighbors.put(edge[1], lst2);
        }

        HashMap<Integer, Double> distMap = new HashMap<Integer, Double>();
        distMap.put(start, 0.0);
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(
            new Comparator<double[]>() {
                @Override
                public int compare(double[] pair1, double[] pair2) {
                    return Double.valueOf(pair1[1]).compareTo(Double.valueOf(pair2[1]));
                }
            }
        );
        double[] initPair = {start, 0};
        pq.add(initPair);
        for(int i = 0; i < n; i++) {
            if(i != start) {
                distMap.put(i, Double.MAX_VALUE);
            }
        }
        while(!pq.isEmpty()) {
            double[] pair = pq.poll();
            int node = (int) pair[0];
            // System.out.println("node: " + node);
            if(node == end) return Math.exp(-distMap.get(end));
            if(neighbors.get(node) == null) return 0;
            for(double[] neighborPair : neighbors.get(node)) {
                double alt = distMap.get(node) + neighborPair[1];
                if(alt < distMap.get((int) neighborPair[0])) {
                    distMap.put((int) neighborPair[0], alt);
                    neighborPair[1] = alt;
                    pq.add(neighborPair);
                }
            }
        }
        return 0;
    }
}