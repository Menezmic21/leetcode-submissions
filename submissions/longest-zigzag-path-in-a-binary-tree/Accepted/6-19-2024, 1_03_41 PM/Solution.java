// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

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
    public int longestZigZag(TreeNode root) {
        // System.out.println(LZZB(root));
        return dfs(root)-1;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = LZZB(root);
        max = Math.max(max, dfs(root.left));
        max = Math.max(max, dfs(root.right));
        return max;
    }
    private int LZZB(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(LZZR(root), LZZL(root));
    } 
    private int LZZR(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + LZZL(root.right);
    } 
    private int LZZL(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + LZZR(root.left);
    } 
}