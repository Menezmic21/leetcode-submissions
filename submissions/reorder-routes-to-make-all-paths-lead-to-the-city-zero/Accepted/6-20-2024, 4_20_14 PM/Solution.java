// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

class Solution {
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> flippedNeighbors = new HashMap<>();
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            HashSet<Integer> neighborSet = neighbors.getOrDefault(a, new HashSet<Integer>());
            neighborSet.add(b);
            neighbors.put(a, neighborSet);

            neighborSet = flippedNeighbors.getOrDefault(b, new HashSet<Integer>());
            neighborSet.add(a);
            flippedNeighbors.put(b, neighborSet);
        }
        HashSet<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        int n_flips = 0;
        while(!queue.isEmpty()) {
            int node = queue.pollFirst();
            // System.out.println(node);
            visited.add(node);
            if (neighbors.get(node) != null) {
                for (int neighbor : neighbors.get(node)) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    // System.out.println("flipping");
                    n_flips++;
                    queue.addLast(neighbor);
                }
            } 
            if (flippedNeighbors.get(node) != null) {
                for (int neighbor : flippedNeighbors.get(node)) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    queue.addLast(neighbor);
                }
            }
        }
        return n_flips;
    }
}