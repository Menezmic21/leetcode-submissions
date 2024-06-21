// https://leetcode.com/problems/dota2-senate

class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Character> queue = new ArrayDeque<>();
        int allR = 0;
        int allD = 0;
        for (char c : senate.toCharArray()) {
            queue.add(c);
            if (c == 'R') {
                allR++;
            } else {
                allD++;
            }
        }
        // System.out.println("allR: " + allR);
        // System.out.println("allD: " + allD);
        int R = 0;
        int D = 0;
        while (allR != 0 && allD != 0) {
            char senator = queue.pollFirst();
            if (senator == 'R') {
                if (D == 0) {
                    R++;
                    queue.addLast('R');
                } else {
                    D--;
                    allR--;
                }
            } else {
                if (R == 0) {
                    D++;
                    queue.addLast('D');
                } else {
                    R--;
                    allD--;
                }
            }
        }
        if (allD == 0) {
            return "Radiant";
        }
        return "Dire";
    }
}