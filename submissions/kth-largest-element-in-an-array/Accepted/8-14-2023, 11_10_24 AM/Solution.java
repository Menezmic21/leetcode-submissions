// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // O(n*logk) vs O(nlogn) vs O(n*logk)
        ArrayList<Integer> topK = new ArrayList<Integer>();
        for(int i = 0; i < k; i++) {
            boolean isAdded = false;
            int low = 0, high = topK.size()-1;
            for(; low <= high;) {
                int mid = high - ((high - low) / 2);
                if(topK.get(mid) < nums[i]) {
                    low = mid + 1;
                } else if(topK.get(mid) > nums[i]) {
                    high = mid - 1;
                } else {
                    isAdded = true;
                    topK.add(mid, nums[i]);
                    break;
                }
            }
            if(!isAdded) topK.add(low, nums[i]);
        }
        // print(topK);
        for(int i = k; i < nums.length; i++) {
            update(topK, nums[i], k);
            // print(topK);
        }
        return topK.get(0);
    }
    public void update(ArrayList<Integer> topK, int num, int k) {
        if(topK.get(k-1) <= num) {
            topK.add(num);
            topK.remove(0);
            return;
        }
        if(topK.get(0) >= num) return;
        int low = 0, high = k-1;
        for(; low <= high;) {
            int mid = high - ((high - low) / 2);
            if(topK.get(mid) < num) {
                low = mid + 1;
            } else if (topK.get(mid) > num) {
                high = mid - 1;
            } else {
                topK.add(mid, num);
                topK.remove(0);
                return;
            }
        }
        topK.add(low, num);
        topK.remove(0);
    }
    // public void print(ArrayList<Integer> list) {
    //     System.out.print("[");
    //     for(int i = 0; i < list.size(); i++) {
    //         System.out.print("" + list.get(i) + ", ");
    //     }
    //     System.out.println("]");
    // }
}