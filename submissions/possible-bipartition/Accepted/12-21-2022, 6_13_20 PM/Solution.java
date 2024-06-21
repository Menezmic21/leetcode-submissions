// https://leetcode.com/problems/possible-bipartition

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        ArrayList<Integer>[] dislikeMap = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            dislikeMap[i] = new ArrayList<Integer>();
        }
        for(int[] relationship:dislikes) {
            dislikeMap[relationship[0]-1].add(relationship[1]);
            dislikeMap[relationship[1]-1].add(relationship[0]);
        }

        int[] states = new int[n];

        for(int i = 0; i < n; i++) {
           if(states[i] == 0 && !bfs(n, i+1, dislikeMap, states)) return false;
        }
        return true;
    }

    public boolean bfs(int n, int s, ArrayList<Integer>[] dislikeMap, int[] states) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        queue.add(s);
        while(queue.size() > 0) {
            int node = queue.remove(0);
            // System.out.println("{" + node[0] + " " + node[1] + "}");
            int color = 1;
            if(states[node-1] == 1) color = 2;
            ArrayList<Integer> elements = new ArrayList<Integer>();
            elements = dislikeMap[node-1];
            for(Integer element:elements) {
                if(states[element-1] == 0) {
                    states[element-1] = color;
                    queue.add(element);
                } else if(states[element-1] != color) {
                    return false;
                }
            }
        }
        return true;
    }
    //0 = unvisited; 1 = color 1; 2 = color 2    
}