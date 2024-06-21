// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }
    private void dfs(List<List<Integer>> rooms, int curr, HashSet<Integer> visited) {
        if (visited.size() == rooms.size()) {
            return;
        }
        visited.add(curr);
        List<Integer> keys = rooms.get(curr);
        for (int key : keys) {
            if (!visited.contains(key)) {
                dfs(rooms, key, visited);
            }
        }
    }
}