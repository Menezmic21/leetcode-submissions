// https://leetcode.com/problems/count-good-nodes-in-binary-tree

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
    public int goodNodes(TreeNode root) {
        return dfs(Integer.MIN_VALUE, root);
    }
    private int dfs(int max, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int n_good = 0;
        max = Math.max(max, root.val);
        if (root.left != null) {
            n_good += dfs(max, root.left);
        }
        if (root.right != null) {
            n_good += dfs(max, root.right);
        }
        return root.val == max ? 1 + n_good : n_good;
    }
}