// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>(rooms.size());
        for (int i = 0; i < rooms.size(); i++) {
            visited.add(i);
        }
        dfs(rooms, 0, visited);
        return visited.isEmpty();
    }
    private void dfs(List<List<Integer>> rooms, int curr, HashSet<Integer> visited) {
        visited.remove(curr);
        List<Integer> keys = rooms.get(curr);
        for (int key : keys) {
            if (visited.contains(key)) {
                dfs(rooms, key, visited);
            }
        }
    }
}