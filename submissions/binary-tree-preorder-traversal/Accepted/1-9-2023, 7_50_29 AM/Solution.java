// https://leetcode.com/problems/binary-tree-preorder-traversal

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rLst = new ArrayList<Integer>();
        if(root == null) return rLst;
        rLst.add(root.val);
        if(root.left != null) {
            // System.out.println("left");
            rLst.addAll(preorderTraversal(root.left));
        }
        if(root.right != null) {
            // System.out.println("right");
            rLst.addAll(preorderTraversal(root.right));
        }
        return rLst;
    }
}