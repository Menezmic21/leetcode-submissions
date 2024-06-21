// https://leetcode.com/problems/path-sum-iii

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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return n_pathSumFrNode(root, 0, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    private int n_pathSumFrNode(TreeNode root, long sum, int target) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        if (sum == target) {
            return 1 + n_pathSumFrNode(root.left, sum, target) + n_pathSumFrNode(root.right, sum, target);
        }
        return n_pathSumFrNode(root.left, sum, target) + n_pathSumFrNode(root.right, sum, target);
    }
}