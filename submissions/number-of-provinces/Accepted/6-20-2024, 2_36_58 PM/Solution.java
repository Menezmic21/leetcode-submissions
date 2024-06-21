// https://leetcode.com/problems/number-of-provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cc = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cc++;
                dfs(isConnected, i, visited);
            }
        }
        return cc;
    }
    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (i == j) {
                continue;
            }
            if (isConnected[i][j] == 1) {
                dfs(isConnected, j, visited);
            }
        }
    }

}