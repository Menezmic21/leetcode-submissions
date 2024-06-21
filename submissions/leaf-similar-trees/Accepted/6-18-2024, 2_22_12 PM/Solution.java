// https://leetcode.com/problems/leaf-similar-trees

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
    int i = 0;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq = new ArrayList<>();
        makeLeafSeq(leafSeq, root1);
        this.i = 0;
        return compareLeafSeq(leafSeq, root2) && leafSeq.size() == i;
    }
    private boolean compareLeafSeq(List<Integer> leafSeq, TreeNode root) {
        if (root.left == null && root.right == null) {
            if (i == leafSeq.size()) {
                return false;
            }
            return root.val == leafSeq.get(this.i++);
        }
        boolean ans = true;
        if (root.left != null) {
            ans &= compareLeafSeq(leafSeq, root.left);
        }
        if (root.right != null) {
            ans &= compareLeafSeq(leafSeq, root.right);
        }
        return ans;
    }
    private void makeLeafSeq(List<Integer> leafSeq, TreeNode root) {
        if (root.left == null && root.right == null) {
            leafSeq.add(root.val);
        }
        if (root.left != null) {
            makeLeafSeq(leafSeq, root.left);
        }
        if (root.right != null) {
            makeLeafSeq(leafSeq, root.right);
        }
    }
}