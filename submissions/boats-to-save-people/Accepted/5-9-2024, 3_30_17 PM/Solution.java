// https://leetcode.com/problems/boats-to-save-people

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        ArrayList<Integer> peeps = new ArrayList<Integer>(people.length);
        for (int i : people) {
            peeps.add(i);
        }
        peeps.sort(Collections.reverseOrder());
        int n_boats = 0;
        while (!peeps.isEmpty()) {
            // System.out.println("peeps: " + peeps);
            int weightA = peeps.remove(0);
            removeGuyB(peeps, limit - weightA);
            n_boats++;
        }
        return n_boats;
    }

    private void removeGuyB(ArrayList<Integer> peeps, int limit) {
        if (peeps.isEmpty()) return;
        if (limit <= 0) return;
        if (peeps.get(0) <= limit) {
            peeps.remove(0);
            return;
        }
        if (peeps.size()-1 > 0 && peeps.get(peeps.size()-1) <= limit) {
            peeps.remove(peeps.size()-1);
            return;
        }
        int mid = 0;
        for (int left = 0, right = peeps.size()-1; left < right; ) {
            mid = (left + right) / 2;
            int mid_val = peeps.get(mid);
            if (mid_val > limit) { // mid is too big, move left rightward
                left = mid + 1;
            } else if (mid_val < limit) { // move right leftward
                right = mid - 1;
            } else { // mid is limit
                peeps.remove(mid);
                return;
            }
        }
        if (peeps.get(mid) <= limit) {
            peeps.remove(mid);
        }
        // for (int i = 0; i < peeps.size(); i++) {
        //     if (peeps.get(i) <= limit) {
        //         peeps.remove(i);
        //         return;
        //     }
        // }
    }
}