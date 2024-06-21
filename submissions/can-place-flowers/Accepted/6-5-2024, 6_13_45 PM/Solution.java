// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            // System.out.println("i: " + i);
            // System.out.println(i == 0 ? 0 : flowerbed[i-1]);
            // System.out.println(flowerbed[i]);
            // System.out.println(i == flowerbed.length-1 ? 0 : flowerbed[i+1]);
            if ((i == 0 ? 0 : flowerbed[i-1]) + 
                flowerbed[i] + 
                (i == flowerbed.length-1 ? 0 : flowerbed[i+1]) == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }
}