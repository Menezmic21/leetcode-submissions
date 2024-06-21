// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        // printList(nums);

        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            twoSum(sums, i, i+1, nums.length-1, nums);
        }
        return sums;
    }
    public void twoSum(List<List<Integer>> sums, int i, int low, int high, int[] nums) {
        if(low >= high) return;

        int sum = nums[low] + nums[high];
        if(sum < -nums[i]) {
            int old = nums[low];
            while(low < nums.length && nums[low] == old) low++;
            twoSum(sums, i, low, high, nums);
        } else if(sum > -nums[i]) {
            int old = nums[high];
            while(high >= 0 && nums[high] == old) high--;
            twoSum(sums, i, low, high, nums);
        } else {
            addTriplet(sums, nums[i], nums[low], nums[high]);
            int old = nums[low];
            while(low < nums.length && nums[low] == old) low++;
            old = nums[high];
            while(high >= 0 && nums[high] == old) high--;
            twoSum(sums, i, low, high, nums);
        }
    }

    public void addTriplet(List<List<Integer>> sums, int a, int b, int c) {
        List<Integer> sum = new ArrayList<Integer>();
        sum.add(a);
        sum.add(b);
        sum.add(c);
        sums.add(sum);
    }

    public void printList(int[] list) {
        System.out.print("[");
        for(int i : list) {
            System.out.print("" + i + ", ");
        }
        System.out.println("]");
    }
}