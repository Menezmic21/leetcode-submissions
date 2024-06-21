// https://leetcode.com/problems/k-radius-subarray-averages

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] rarr = new int[nums.length];
        if(2 * k + 1 > nums.length) {
            for(int i = 0; i < nums.length; i++) {
                rarr[i] = -1;
            }
            return rarr;
        }
        int i = 0;
        java.math.BigInteger[] avgs = new java.math.BigInteger[nums.length];
        avgs[0] = java.math.BigInteger.valueOf(nums[0]);
        while(i < k) {
            avgs[i+1] = avgs[i].add(java.math.BigInteger.valueOf(nums[i+1]));
            avgs[i] = java.math.BigInteger.valueOf(-1);
            avgs[nums.length-1-i] = java.math.BigInteger.valueOf(-1);
            i++;
        }
        for(int j = 1; j <= k; j++) {
            avgs[i] = avgs[i].add(java.math.BigInteger.valueOf(nums[i+j]));
        }
        i++;
        while(i < nums.length - k) {
            avgs[i] = avgs[i-1].add(java.math.BigInteger.valueOf(-nums[i-1-k])).add(java.math.BigInteger.valueOf(nums[i+k]));
            i++;
        }
        i--;
        while(i >= k) {
            avgs[i] = avgs[i].divide(java.math.BigInteger.valueOf(2 * k + 1));
            i--;
        }
        for(int j = 0; j < nums.length; j++) {
                rarr[j] = avgs[j].intValue();
            }
        return rarr;
    }
}


        // int[] avgs = new int[nums.length];
        // int i = 0;
        // avgs[0] = nums[0];
        // while(i < k && i < nums.length) {
        //     if(i + k < nums.length) {
        //         avgs[i+1] += avgs[i] + nums[i+1];
        //     }
        //     avgs[i] = -1;
        //     avgs[nums.length-1-i] = -1;
        //     i++;
        // }
        // for(int j = 1; j <= k && i+j < nums.length; j++) {
        //     avgs[i] += nums[i+j];
        // }
        // i++;
        // while(i < nums.length - k) {
        //     avgs[i] = avgs[i-1] - nums[i-1-k] + nums[i+k];
        //     i++;
        // }
        // i--;
        // while(i >= k && i < nums.length) {
        //     avgs[i] = avgs[i] / (2 * k + 1);
        //     i--;
        // }
        // return avgs;

    //     int[] avgs = new int[nums.length];
    //     for(int i = 0; i < nums.length; i++) {
    //         int cnt = 0;
    //         int j = i;
    //         while(j >= 0 && Math.abs(j-i) <= k) { //left
    //             avgs[i] += nums[j];
    //             j--;
    //             cnt++;
    //         }
    //         j = i + 1;
    //         while(j < nums.length && Math.abs(j-i) <= k) { //right
    //             avgs[i] += nums[j];
    //             j++;
    //             cnt++;
    //         }
    //         if(cnt == 2 * k + 1) {
    //             avgs[i] = (int) (avgs[i] / cnt);
    //         } else {
    //             avgs[i] = -1;
    //         }
    //     }
    //     return avgs;
    // }