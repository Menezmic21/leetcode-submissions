// https://leetcode.com/problems/binary-tree-right-side-view

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Deque<Integer> depth = new ArrayDeque<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = root;
        depth.addLast(0);
        queue.addLast(node);
        int prev = -1;
        int level = -1;
        while (!queue.isEmpty()) {
            prev = level;
            level = depth.pollFirst();
            node = queue.pollFirst();
            if (prev != level) {
                answer.add(node.val);
            }
            if (node.right != null) {
                depth.addLast(level+1);
                queue.addLast(node.right);
            }
            if (node.left != null) {
                depth.addLast(level+1);
                queue.addLast(node.left);
            }
        }
        return answer;
    }
}