// https://leetcode.com/problems/minimum-absolute-difference-in-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    public int getMinimumDifference(TreeNode root) {

        traverseTree(root);

        int min = Integer.MAX_VALUE;
        int prev = pq.poll();

        while(!pq.isEmpty()) {
            int curr = pq.poll();
            int diff = curr - prev;
            if(diff < min) min = diff;
            prev = curr;
        }

        return min;
    }

    public void traverseTree(TreeNode root) {
        pq.add(root.val);
        if(root.left != null) traverseTree(root.left);
        if(root.right != null) traverseTree(root.right);
    }
}