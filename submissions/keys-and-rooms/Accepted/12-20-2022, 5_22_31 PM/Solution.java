// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        dfs(0, rooms, visited);
        for(int room = 0; room < rooms.size(); room++){
            if(!visited.getOrDefault(room, false)) return false;
        }
        return true;
    }
    public void dfs(int node, List<List<Integer>> rooms, HashMap<Integer, Boolean> visited){
        List<Integer> neighbors = rooms.get(node);
        visited.put(node, true);
        if(neighbors.size() == 0) return;
        for(int room:neighbors){
            if(!visited.getOrDefault(room, false)) dfs(room, rooms, visited);
        }
    }
}