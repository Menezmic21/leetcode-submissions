// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

class Solution {
    public int minReorder(int n, int[][] connections) {
        HashSet<Integer>[] neighbors = (HashSet<Integer>[]) new HashSet[n];
        HashSet<Integer>[] flippedNeighbors = (HashSet<Integer>[]) new HashSet[n];
        for (int i = 0 ; i < n; i++) {
            neighbors[i] = new HashSet<Integer>();
            flippedNeighbors[i] = new HashSet<Integer>();
        }
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            neighbors[a].add(b);
            flippedNeighbors[b].add(a);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        int n_flips = 0;
        while(!queue.isEmpty()) {
            int node = queue.pollFirst();
            // System.out.println(node);
            visited[node] = true;
            for (int neighbor : neighbors[node]) {
                if (visited[neighbor]) {
                    continue;
                }
                n_flips++;
                queue.addLast(neighbor);
            }
            for (int neighbor : flippedNeighbors[node]) {
                if (visited[neighbor]) {
                    continue;
                }
                queue.addLast(neighbor);
            }
        }
        return n_flips;
    }
}