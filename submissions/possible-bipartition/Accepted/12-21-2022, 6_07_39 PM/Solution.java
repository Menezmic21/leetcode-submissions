// https://leetcode.com/problems/possible-bipartition

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] adjLists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjLists[i] = new ArrayList<>();
        }
        for (int[] pair: dislikes) {
            adjLists[pair[0]-1].add(pair[1]-1);
            adjLists[pair[1]-1].add(pair[0]-1);
        } 

        int[] color = new int[N];
        for (int i = 0; i < N; i++) {
            if (color[i] == 0 && !bfs(adjLists, i, color)) return false;
        }

        return true;
    }
    private boolean bfs(List<Integer>[] adjLists, int s, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        color[s] = 1;
        q.offer(s);
        while (!q.isEmpty()) {
          Integer v = q.poll();
          for (Integer neighbor: adjLists[v]) {
            if (color[neighbor] == 0) {
              color[neighbor] = color[v] == 1 ? 2 : 1;
              q.offer(neighbor);
            } else if (color[v] == color[neighbor]) {
              return false;
            }
          }
        }
      return true;
      
    }
}