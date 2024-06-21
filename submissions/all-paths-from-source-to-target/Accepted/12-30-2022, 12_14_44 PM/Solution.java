// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(0, graph);
    }
    public List<List<Integer>> dfs(int node, int[][] graph) {
        int endNode = graph.length-1;
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        if(node == endNode) {
            List<Integer> path = new ArrayList<Integer>();
            path.add(endNode);
            pathsList.add(path);
            return pathsList;
        }
        for(int buddy:graph[node]) {
            List<List<Integer>> newPathsList = dfs(buddy, graph);
            for(List<Integer> path:newPathsList) {
                path.add(0, node);
                pathsList.add(path);
            }
        }
        return pathsList;
    }
}