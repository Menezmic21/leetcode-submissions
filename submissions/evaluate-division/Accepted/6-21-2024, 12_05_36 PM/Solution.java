// https://leetcode.com/problems/evaluate-division

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String A = equation.get(0);
            String B = equation.get(1);
            HashMap<String, Double> neighbors = graph.getOrDefault(A, new HashMap<String, Double>());
            neighbors.put(B, values[i]);
            graph.put(A, neighbors);

            // reverse edge
            neighbors = graph.getOrDefault(B, new HashMap<String, Double>());
            neighbors.put(A, 1/values[i]);
            graph.put(B, neighbors);
        }
        double[] answers = new double[queries.size()];
        for (int j = 0; j < answers.length; j++) {
            List<String> query = queries.get(j);
            String A = query.get(0);
            String B = query.get(1);
            if (graph.keySet().contains(A) && graph.keySet().contains(B)) {
                HashSet<String> visited = new HashSet<>();
                answers[j] = dfs(graph, A, B, visited);

                // add result to graph
                HashMap<String, Double> neighbors = graph.getOrDefault(A, new HashMap<String, Double>());
                neighbors.put(B, answers[j]);
                graph.put(A, neighbors);
            } else {
                answers[j] = -1;
            }
        }
        return answers;
    }
    private double dfs(HashMap<String, HashMap<String, Double>> graph, String curr, String dest, HashSet<String> visited) {
        if (visited.size() == graph.keySet().size()) {
            return -1;
        }
        if (visited.contains(curr)) {
            return -1;
        }
        if (curr.equals(dest)) {
            return 1;
        }
        visited.add(curr);
        HashMap<String, Double> neighbors = graph.get(curr);
        double curr_res = -1;
        for (String neighbor : neighbors.keySet()) {
            double next_res = neighbors.get(neighbor);
            if (next_res != -1) {
                curr_res = Math.max(curr_res, neighbors.get(neighbor) * dfs(graph, neighbor, dest, visited));
                if (curr_res < 0) {
                    curr_res = -1;
                }
            }
        }
        return curr_res;
    }
}