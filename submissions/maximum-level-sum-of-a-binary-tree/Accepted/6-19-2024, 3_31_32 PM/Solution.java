// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree

/**
 * Definition for a binary tree pair[0].
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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int n_at_depth = 1;
        int n_at_next_depth = 0;
        int argmax = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int depth = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            n_at_depth--;
            sum += node.val;
            if (node.left != null) {
                queue.addLast(node.left);
                n_at_next_depth++;
            }
            if (node.right != null) {
                queue.addLast(node.right);
                n_at_next_depth++;
            }
            if (n_at_depth == 0) {
                if (sum > max) {
                    max = sum;
                    argmax = depth;
                }
                sum = 0;
                depth++;
                n_at_depth = n_at_next_depth;
                n_at_next_depth = 0;
            }
        }
        return argmax;
    }
}