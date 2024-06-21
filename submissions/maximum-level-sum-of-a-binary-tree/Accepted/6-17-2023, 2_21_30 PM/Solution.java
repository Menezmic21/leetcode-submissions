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
        ArrayList<Integer> sumLst = new ArrayList<Integer>();
        ArrayList<Object[]> queue = new ArrayList<Object[]>();
        Object[] initPair = {root, 1};
        queue.add(initPair);
        while(!queue.isEmpty()) {
            Object[] pair = queue.remove(0);
            TreeNode node = (TreeNode) pair[0];
            int level = (int) pair[1];
            if(node.left != null) {
                Object[] newPair = {node.left, level + 1};
                queue.add(newPair);
            }

            if(node.right != null) {
                Object[] newPair = {node.right, level + 1};
                queue.add(newPair);
            }

            if(sumLst.size() < level) {
                sumLst.add(node.val);
            } else {
                sumLst.set(level-1, sumLst.get(level-1) + node.val);
            }
        }

        int minLevel = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < sumLst.size(); i++) {
            if(sumLst.get(i) > maxVal) {
                maxVal = sumLst.get(i);
                minLevel = i + 1;
            }
        }

        return minLevel;
    }
}