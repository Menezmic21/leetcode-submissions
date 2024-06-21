// https://leetcode.com/problems/relative-sort-array

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // HashMap<Integer, Integer> fMap = new HashMap<Integer, Integer>();
        // for (int num : arr1) {
        //     fMap.put(num, fMap.getOrDefault(num, 0) + 1);
        // }
        // for (int i = 0; i < arr2.length; i++) {
        //     int j = 0;
        //     for ( ; j < fMap.get(arr2[i]); j++) {
        //         arr1[i+j] = arr2[i];
        //     }
        //     i = j;
        // }
        List<Integer> rarr = new ArrayList<Integer>(arr1.length);
        for (int num : arr1) {
            rarr.add(num);
        }
        Collections.sort(rarr, (Integer v1, Integer v2) -> (compare(v1, v2, arr2)));
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rarr.get(i);
        }
        return arr1;
    }
    private int compare(Integer v1, Integer v2, int[] arr2) {
        int idx1 = -1;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == v1) {
                idx1 = i;
                break;
            }
        }

        int idx2 = -1;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == v2) {
                idx2 = i;
                break;
            }
        }

        if (idx1 == -1) {
            idx1 = arr2.length + v1;
        }

        if (idx2 == -1) {
            idx2 = arr2.length + v2;
        }

        return Integer.valueOf(idx1).compareTo(idx2);
    }
}