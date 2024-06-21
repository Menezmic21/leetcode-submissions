// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int prev = -1;
        for (int aster : asteroids) {
            if (aster < 0) { // aster heading left
                if (prev < 0) { // prev heading left
                    // System.out.println("both happy, same dir");
                    stack.addFirst(aster);
                } else  { // prev heading right -> collision
                    boolean alive = true;
                    while (prev > 0) {
                        if (prev > -aster) { // prev wins, aster destroyed
                            // System.out.println("prev wins, aster destroyed");
                            alive = false;
                            break;
                        } else if (prev == -aster) { // both lose
                            // System.out.println("mutual destruction");
                            alive = false;
                            stack.removeFirst();
                            // prev = -1;
                            break;
                        } else { // aster wins, prev destroyed
                            // System.out.println("aster wins, prev destroyed");
                            stack.removeFirst();
                            if (stack.isEmpty()) {
                                // prev = -1;
                                break;
                            }
                            prev = stack.peekFirst();
                        }
                    }
                    if (alive) {
                        stack.addFirst(aster);
                    }
                }
            } else { // aster heading right
                // System.out.println("both happy, op dirs");
                stack.addFirst(aster);
            }
            prev = stack.isEmpty() ? -1 : stack.peekFirst();
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length-1; i >= 0; i--) {
            ans[i] = stack.pollFirst();
        }
        return ans;
    }
}