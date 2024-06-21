// https://leetcode.com/problems/k-th-smallest-prime-fraction

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        ArrayList<Double[]> fracs = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                double newFrac = ((double) arr[i]) / arr[j];
                Double[] newEntry = {newFrac, (double) arr[i], (double) arr[j]};
                fracs.add(newEntry);
            }
        }
        Collections.sort(fracs, (a, b) -> Double.compare(a[0], b[0]));
        Double[] resEntry = fracs.get(k-1);
        int[] res = {(int) ((double) resEntry[1]), (int) ((double) resEntry[2])};
        return res;
    }
}