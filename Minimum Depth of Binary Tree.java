/*
Easy Minimum Depth of Binary Tree Show Result My Submissions

38% Accepted
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Example
Tags Expand 
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        return minDepthHelper(root);
    }
    
    private int minDepthHelper(TreeNode pNode) {
        if (pNode.left == null && pNode.right == null) {
            return 1;
        }
        int left = -1;
        if (pNode.left != null) {
            left = minDepthHelper(pNode.left);
        }
        int right = -1;
        if (pNode.right != null) {
            right = minDepthHelper(pNode.right);
        }
        if (left != -1 && right != -1) {
            return Math.min(left, right) + 1;
        }
        else {
            return (left == -1) ? (right + 1) : (left + 1);
        }
    }
}
