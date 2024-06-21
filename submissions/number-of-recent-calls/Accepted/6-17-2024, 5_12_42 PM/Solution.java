// https://leetcode.com/problems/number-of-recent-calls

class RecentCounter {

    Deque<Integer> queue = new ArrayDeque<>();

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        queue.addLast(t);
        while (queue.peekFirst() < t-3000) {
            queue.removeFirst();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */