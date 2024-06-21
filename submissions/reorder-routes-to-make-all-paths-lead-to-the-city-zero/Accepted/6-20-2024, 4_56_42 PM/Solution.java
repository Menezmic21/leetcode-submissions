// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

class Solution {
    public int minReorder(int n, int[][] connections) {
        HashSet<Integer>[] neighbors = (HashSet<Integer>[]) new HashSet[n];
        for (int i = 0 ; i < n; i++) {
            neighbors[i] = new HashSet<Integer>();
        }
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            neighbors[a].add(b);
            neighbors[b].add(-a);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        int n_flips = 0;
        while(!queue.isEmpty()) {
            int node = queue.pollFirst();
            visited[node] = true;
            for (int neighbor : neighbors[node]) {
                if (visited[Math.abs(neighbor)]) {
                    continue;
                }
                if (neighbor > 0) {
                    n_flips++;
                }
                queue.addLast(Math.abs(neighbor));
            }
        }
        return n_flips;
    }
}