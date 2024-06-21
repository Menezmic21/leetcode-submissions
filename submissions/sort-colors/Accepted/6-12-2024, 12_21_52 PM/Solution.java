// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length-1;
        for (int i = red; i <= blue; ) {
            while (red < nums.length && nums[red] == 0) red++;
            while (blue >= 0 && nums[blue] == 2) blue--;
            i = Math.max(i, red);
            if (i > blue) {
                break;
            }
            // System.out.print("(" + i + ", " + red + ", " + blue + ")");
            int temp = nums[i];
            if (nums[i] == 0) {
                // if red, swap current to end of red and increment
                nums[i] = nums[red];
                nums[red] = temp;
            } else if (nums[i] == 2) {
                // if blue, swap current to end of blue and decrement
                nums[i] = nums[blue];
                nums[blue] = temp;
            }
            if (nums[i] == temp) {
                i++;
            }
            // if (i < red) {
            //     i = red;
            // } else {
            //     i++;
            // }
            // print_arr(nums);
        }
    }
    private void print_arr(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("" + nums[i] + (i != nums.length-1 ? "," : "]\n"));
        }
    }
}