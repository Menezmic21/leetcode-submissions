// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> queue = new ArrayList<Integer>();
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for(int room = 0; room < rooms.size(); room++) {
            visited.put(room, false);
        }
        queue.add(0);
        visited.put(0, true);
        while(queue.size() > 0) {
            int node = queue.remove(0);
            visited.put(node, true);
            List<Integer> neighbors = rooms.get(node);
            for(Integer room:neighbors) {
                if(!visited.get(room)) {
                    queue.add(room);
                }
            }
        }
        for(int room = 0; room < rooms.size(); room++) {
            if(!visited.get(room)) return false;
        }
        return true;
    }
}