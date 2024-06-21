// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks

class Solution {
    public int minimumRounds(int[] tasks) {
        //10:20
        HashMap<Integer, Integer> memory = new HashMap<Integer, Integer>();
        //create frequency hashmap
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int diff:tasks) {
            freq.put(diff, freq.getOrDefault(diff, 0) + 1);
        }
        //iterate
        int allRounds = 0;
        for (Map.Entry<Integer, Integer> set:freq.entrySet()) {
            int someRounds = computeRounds(set.getValue(), memory);
            if(someRounds == -1) return -1;
            // System.out.println(someRounds);
            allRounds += someRounds;
        }
        return allRounds;
    }
    // public int computeRounds(int z) {
    //     // double rounds = -1;
    //     // double x = 0;
    //     // double y = 0;
    //     // while(x >= 0) {
    //     //     x = (z - 3.0 * y) / 2.0;
    //     //     if(x >= 0 && x == (int) x) {
    //     //         rounds = x + y;
    //     //         break;
    //     //     }
    //     //     y++;
    //     // }
    //     int rounds = -1;

    //     for(int x = 0; x < z; x++) {
    //         for(int y = 0; y < z; y++) {
    //             if(2 * x + 3 * y == z) {
    //                 if(rounds == -1 || rounds > x + y) {
    //                     rounds = x + y;
    //                 }
    //             }
    //         }
    //     }

    //     return rounds;
    // }

    public int computeRounds(int z, HashMap<Integer, Integer> memory){
        if (z == 0) return 0;
        if (z < 0) return -1;
        if(memory.getOrDefault(z, null) != null) return memory.get(z);
        int option1 = computeRounds(z - 2, memory);
        int option2 = computeRounds(z - 3, memory);
        if(option1 == -1 && option2 == -1) {
            memory.put(z, -1);
            return -1;
        } else if(option1 == -1 || option2 == -1) {
            int value = Math.max(computeRounds(z - 2, memory), computeRounds(z - 3, memory));
            // memory.put(z, value);
            return 1 + value;
        }
        int value = Math.min(computeRounds(z - 2, memory), computeRounds(z - 3, memory));
        memory.put(z, 1 + value);
        return 1 + value;
    }
}